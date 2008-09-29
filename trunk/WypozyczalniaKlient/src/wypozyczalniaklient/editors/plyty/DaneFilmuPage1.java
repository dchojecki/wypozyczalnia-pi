package wypozyczalniaklient.editors.plyty;

import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;

import zarzadzanieplytami.FilmTO;

public class DaneFilmuPage1 extends FormPage {
	/**
	 * @param id
	 * @param title
	 */

	private FilmTO film;
	
	public DaneFilmuPage1(FormEditor editor) {
		super(editor, "first", "Konto"); //$NON-NLS-1$ //$NON-NLS-2$
		DaneFilmuInput i = (DaneFilmuInput) editor.getEditorInput();
		i.getKonto();
		film = i.getKonto();

	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText("Edycja danych konta"); //$NON-NLS-1$
		TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		form.getBody().setLayout(layout);
		TableWrapData td;
		td = new TableWrapData();
		td.align = TableWrapData.LEFT;
	}

}