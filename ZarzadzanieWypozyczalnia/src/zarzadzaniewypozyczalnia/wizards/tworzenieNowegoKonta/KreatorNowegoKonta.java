package zarzadzaniewypozyczalnia.wizards.tworzenieNowegoKonta;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import zarzadzaniewypozyczalnia.logika.konta.ZarzadzanieKontamiDelegacja;
import zarzadzaniewypozyczalnia.logika.konta.ZarzadzanieKontamiWyjatek;

public class KreatorNowegoKonta extends Wizard implements INewWizard {
	
	private KreatorNowegoKontaStrona page;

	public KreatorNowegoKonta() {
		super();
		setWindowTitle("Nowe konto...");
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		page = new KreatorNowegoKontaStrona();
		addPage(page);
	}

	public boolean performFinish() {
		final String imie = page.getImie();
		final String nazwisko = page.getNazwisko();
		final String pesel = page.getPesel();
		final String mail = page.getMail();		
		final String dataUrodzenia = page.getDataUrodzenia();
		
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(nazwisko, imie, pesel, mail, dataUrodzenia, monitor);
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
			MessageDialog.openError(getShell(), "B³¹d", realException.getMessage());
			return false;
		}
		return true;
	}
	
	private void doFinish(
		String nazwisko,
		String imie,
		String pesel,
		String mail,
		String dataUrodzenia,
		IProgressMonitor monitor)
		throws CoreException {
		
		monitor.beginTask("Tworzenie konta.. ", 1);
		try {
			ZarzadzanieKontamiDelegacja.getInstance().utworzNoweKonto(nazwisko, imie, pesel, mail, dataUrodzenia);
		} catch (ZarzadzanieKontamiWyjatek e) {
			System.out.println("error");
		}
		monitor.worked(1);
	}

	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		// TODO Auto-generated method stub
		
	}
}