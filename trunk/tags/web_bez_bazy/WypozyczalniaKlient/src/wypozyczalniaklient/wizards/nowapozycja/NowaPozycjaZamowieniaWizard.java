package wypozyczalniaklient.wizards.nowapozycja;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;
import wypozyczalniaklient.wizards.nowezamowienie.NoweZamowieniePozycjaPage;
import zarzadzanieplytami.PlytaTO;

public class NowaPozycjaZamowieniaWizard extends Wizard implements INewWizard {
	private NoweZamowieniePozycjaPage page;
	private ISelection selection;
	private ZamowienieTO zamowienie;

	/**
	 * Constructor for NowaPozycjaZamowieniaWizard.
	 */
	public NowaPozycjaZamowieniaWizard(ZamowienieTO zamowienie) {
		super();
		this.zamowienie = zamowienie;
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
		page = new NoweZamowieniePozycjaPage(selection);
		addPage(page);
	}

	public boolean performFinish() {
		final ZamowienieTO z = zamowienie;
		final PlytaTO zz = page.getPlyta();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(z, zz, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}
		return true;
	}

	private void doFinish(ZamowienieTO z, PlytaTO p, IProgressMonitor monitor)
			throws CoreException {
		monitor.beginTask("Aktualizacja zamówienia...", 1);
		monitor.worked(1);
		ZarzadzanieWypozyczeniamiDelegacja zz = ZarzadzanieWypozyczeniamiDelegacja
				.getInstance();
		PozycjaZamowieniaTO pozycja = new PozycjaZamowieniaTO();
		pozycja.setPlyta(page.getPlyta());
		z.getPozycjezamowienia().add(pozycja);
		zz.scalDaneZamowienia(z);
		
		monitor.done();
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}