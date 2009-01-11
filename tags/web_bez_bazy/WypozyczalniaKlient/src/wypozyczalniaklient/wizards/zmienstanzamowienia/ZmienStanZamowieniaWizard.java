package wypozyczalniaklient.wizards.zmienstanzamowienia;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;

public class ZmienStanZamowieniaWizard extends Wizard implements INewWizard {
	private ZmienStanZamowieniaWizardPage page;
	private ZamowienieTO zamowienie;

	public ZmienStanZamowieniaWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	public static final String ID = "wypozyczalniaklient.wizards.zmienstanzamowienia.ZmienStanZamowieniaWizard";
	public void addPages() {
		page = new ZmienStanZamowieniaWizardPage(zamowienie);
		addPage(page);
	}

	public boolean performFinish() {
		zamowienie.setStanzamowienia(page.getStan());
		final ZamowienieTO z = zamowienie;
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(z, monitor);
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
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}
	

	private void doFinish(
			ZamowienieTO z,
		IProgressMonitor monitor)
		throws CoreException {
		monitor.beginTask("Zmiana stanu zamówienia", 2);
		ZarzadzanieWypozyczeniamiDelegacja wypozyczenia = ZarzadzanieWypozyczeniamiDelegacja.getInstance();
		wypozyczenia.scalDaneZamowienia(z);
		monitor.worked(1);
		monitor.setTaskName("Zapisywanie zmian");
		monitor.worked(1);
	}
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof ZamowienieTO) {
			zamowienie = (ZamowienieTO) selection.getFirstElement();
		}
	}
}