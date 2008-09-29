package wypozyczalniaklient.wizards.nowezamowienie;

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

import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;

public class NoweZamowienie extends Wizard implements INewWizard {
	private NoweZamowienieKontoPage page1;
	private ISelection selection;

	public static final String ID = "wypozyczalniaklient.wizards.NoweZamowienie";

	/**
	 * Constructor for NoweZamowienie.
	 */
	public NoweZamowienie() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle("Nowe zamówienie");
	}

	@Override
	public boolean canFinish() {
		if (page1.isPageComplete())
			return true;
		return false;
	}

	public void addPages() {
		page1 = new NoweZamowienieKontoPage(selection);
		addPage(page1);
	}

	public boolean performFinish() {
		final String nrPesel = page1.getNrPeselKlienta();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(nrPesel, monitor);
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
			MessageDialog.openError(getShell(), "B³¹d", realException
					.getMessage());
			return false;
		}
		return true;
	}

	private void doFinish(String nrPesel, IProgressMonitor monitor)
			throws CoreException {

		monitor.beginTask("Tworzenie konta.. ", 1);
		monitor.worked(1);
		ZarzadzanieKontamiDelegacja zk = ZarzadzanieKontamiDelegacja
				.getInstance();
		ZarzadzanieWypozyczeniamiDelegacja zz = ZarzadzanieWypozyczeniamiDelegacja
				.getInstance();
		try {
			KontoTO konto;
			ZamowienieTO zamowienie = zz.utworzNoweZamowienie();
			konto = zk.zwrocDaneKonta(nrPesel);
			zamowienie.setKonto(konto);
			zz.scalDaneZamowienia(zamowienie);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}