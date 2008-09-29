package wypozyczalniaklient.wizards.zmianastanukonta;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class ZmianaStanuKonta extends Wizard implements INewWizard {

private ZmianaStanuKontaPage page;

	public ZmianaStanuKonta() {
		super();
		setWindowTitle("Zmiana stanu konta");
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean canFinish() {
		return false;
	}

	public void addPages() {
		page = new ZmianaStanuKontaPage(null);
		addPage(page);
	}

	public boolean performFinish() {
		return true;
	}

	@Override
	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		// TODO Auto-generated method stub

	}
}