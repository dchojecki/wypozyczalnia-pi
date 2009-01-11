package wypozyczalniaklient.editors;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import zarzadzanieplytami.PlytaTO;

public class DanePlytyPage1 extends FormPage {
	/**
	 * @param id
	 * @param title
	 */

	private PlytaTO plyta;
	private FormToolkit toolkit;
	
	public DanePlytyPage1(FormEditor editor) {
		super(editor, "first", "P³yta"); //$NON-NLS-1$ //$NON-NLS-2$
		DanePlytyInput i = (DanePlytyInput) editor.getEditorInput();
		plyta = i.getKonto();

	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		form.setText("Edycja danych p³yty"); //$NON-NLS-1$
		TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);
		TableWrapData td;
		td = new TableWrapData();
		td.align = TableWrapData.LEFT;
		
	}

}