package wypozyczalniaklient.editors.danezamowienia;

import org.eclipse.ui.editors.text.TextEditor;

public class DaneZamowienia extends TextEditor {
	public static final String ID = "";
	private ColorManager colorManager;

	public DaneZamowienia() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
