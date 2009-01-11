package wypozyczalniaklient.wizards.zablokujkonto;

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

import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiWyjatek;

public class ZablokujKontoWizard extends Wizard implements INewWizard {
	private ZablokujKontoWizardPage page;
	private KontoTO konto;
	private ISelection selection;

	public ZablokujKontoWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	public void addPages() {
		page = new ZablokujKontoWizardPage(selection, konto);
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
	public boolean performFinish() {
		final String nrPesel = page.getNrPeselKlienta();

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(monitor, nrPesel);
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

	private void doFinish(IProgressMonitor monitor, String nrPesel)
			throws CoreException {
		monitor.worked(1);
		ZarzadzanieKontamiDelegacja konta = ZarzadzanieKontamiDelegacja.getInstance();
		try {
			KlientTO konto = konta.zwrocDaneKlienta(nrPesel);
			konta.zablokujKonto(konto);
		} catch (ZarzadzanieKontamiWyjatek e) {
		}
		monitor.setTaskName("Blokowanie konta...");
		monitor.worked(1);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;

		if (selection != null && selection.getFirstElement() instanceof KontoTO)
			konto = (KontoTO) selection.getFirstElement();
	}
}