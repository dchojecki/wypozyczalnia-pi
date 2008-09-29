package wypozyczalniaklient.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * An example showing how to create a multi-page editor. This example has 3
 * pages:
 * <ul>
 * <li>page 0 contains a nested text editor.
 * <li>page 1 allows you to change the font used in page 2
 * <li>page 2 shows the words in page 0 in sorted order
 * </ul>
 */
public class PlytaEdytor extends FormEditor {


	@Override
	public String getTitleToolTip() {
		return "afd";
	}

	public static final String ID = "wypozyczalniaklient.editors.PlytaEdytor";

	
	public PlytaEdytor() {
		setTitleToolTip("adf");
		setPartName("aa");
	}
	@Override
	protected void addPages() {
		try {
			addPage(new DanePlytyPage1(this));
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
