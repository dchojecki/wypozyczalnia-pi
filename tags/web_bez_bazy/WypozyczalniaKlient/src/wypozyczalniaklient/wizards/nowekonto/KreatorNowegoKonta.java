package wypozyczalniaklient.wizards.nowekonto;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;

public class KreatorNowegoKonta extends Wizard implements INewWizard {

	private KreatorNowegoKontaPage1 page1;
	private KreatorNowegoKontaPage2 page2;

	public KreatorNowegoKonta() {
		super();
		setWindowTitle("Nowe konto...");
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean canFinish() {
		if (page1.isPageComplete() && page2.isPageComplete())
			return true;
		return false;
	}

	public void addPages() {
		page1 = new KreatorNowegoKontaPage1();
		addPage(page1);
		page2 = new KreatorNowegoKontaPage2();
		addPage(page2);
	}

	public boolean performFinish() {
		final String imie = page1.getImie();
		final String nazwisko = page1.getNazwisko();
		final String pesel = page1.getPesel();
		final String mail = page1.getMail();
		final String dataUrodzenia = page1.getDataUrodzenia();
		final String miasto = page2.getMiasto();
		final String ulica = page2.getUlica();
		final Integer nrdomu = page2.getNrDomu();
		final Integer nrmieszkania = page2.getNrMieszkania();

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(nazwisko, imie, pesel, mail, dataUrodzenia,
							miasto, ulica, nrdomu, nrmieszkania, monitor);
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

	private void doFinish(String nazwisko, String imie, String pesel,
			String mail, String dataUrodzenia, String miasto, String ulica,
			Integer nrDomu, Integer nrMieszkania, IProgressMonitor monitor)
			throws CoreException {

		monitor.beginTask("Tworzenie konta.. ", 1);
		monitor.worked(1);
		ZarzadzanieKontamiDelegacja zk = ZarzadzanieKontamiDelegacja
				.getInstance();
		KontoTO konto;
		try {
			konto = zk.utworzNoweKonto(nazwisko, imie, new Date(), pesel, mail);

			AdresTO adres = new AdresTO();
			adres.setMiast(miasto);
			adres.setNrPeselKlienta(konto.getNrPeselKlienta());
			adres.setUlica(ulica);
			adres.setNrMieszkania(nrMieszkania);
			adres.setNrDomu(nrDomu);

			zk.uaktualnijDaneAdresu(adres);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		// TODO Auto-generated method stub

	}
}