package wypozyczalniaklient.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import wypozyczalniaklient.views.listakont.ListaKont;
import wypozyczalniaklient.views.listawypozyczen.ListaWypozyczen;
import wypozyczalniaklient.views.wypozyczenia.ZamowienieView;
import wypozyczalniaklient.views.wypozyczenia.pozycje.PozycjeView;

public class WypozyczeniaPerspektywa implements IPerspectiveFactory {

	private IPageLayout factory;

	public WypozyczeniaPerspektywa() {
		super();
	}

	public void createInitialLayout(IPageLayout factory) {
		this.factory = factory;
		addViews();
		addActionSets();
		addNewWizardShortcuts();
		addPerspectiveShortcuts();
		addViewShortcuts();
	}

	private void addViews() {
		factory.setEditorAreaVisible(false);
		IFolderLayout bottom = factory.createFolder("bottomRight", // NON-NLS-1
				IPageLayout.BOTTOM, 0.60f, factory.getEditorArea());
		IFolderLayout topLeft = factory.createFolder("topLeft", // NON-NLS-1
				IPageLayout.LEFT, 0.33f, factory.getEditorArea());
		topLeft.addView(ListaWypozyczen.ID);
		bottom.addView(ZamowienieView.ID);
		bottom.addView(PozycjeView.ID);
	}

	private void addActionSets() {
	}

	private void addPerspectiveShortcuts() {
		factory.addPerspectiveShortcut(KontaPerspektywa.ID);
	}

	private void addNewWizardShortcuts() {
	}

	private void addViewShortcuts() {
		factory.addShowViewShortcut(ListaWypozyczen.ID);
		factory.addShowViewShortcut(ListaKont.ID);
	}

}
