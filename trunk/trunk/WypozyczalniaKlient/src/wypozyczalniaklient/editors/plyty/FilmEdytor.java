package wypozyczalniaklient.editors.plyty;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class FilmEdytor extends FormEditor {


	@Override
	public String getTitleToolTip() {
		return "afd";
	}

	public static final String ID = "wypozyczalniaklient.editors.plyty.FilmEdytor";

	
	public FilmEdytor() {
		setTitleToolTip("adf");
		setPartName("aa");
	}
	@Override
	protected void addPages() {
		try {
			addPage(new DaneFilmuPage1(this));
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doSave(IProgressMonitor arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}
}
