/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package wypozyczalniaklient.perspectives;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import wypozyczalniaklient.views.plyty.DaneFilmu;
import wypozyczalniaklient.views.plyty.DanePlyty;
import wypozyczalniaklient.views.plyty.ListaFilmow;
import wypozyczalniaklient.views.plyty.ListaPlyt;
import wypozyczalniaklient.wizards.nowezamowienie.NoweZamowienie;


/**
 *  This class is meant to serve as an example for how various contributions 
 *  are made to a perspective. Note that some of the extension point id's are
 *  referred to as API constants while others are hardcoded and may be subject 
 *  to change. 
 */
public class PlytyPerspektywa implements IPerspectiveFactory {

	private IPageLayout factory;

	public PlytyPerspektywa() {
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
		factory.setEditorAreaVisible(true);
		IFolderLayout topLeft =
			factory.createFolder(
				"topLeft", //NON-NLS-1
				IPageLayout.LEFT,
				0.25f,
				factory.getEditorArea());
		
		IFolderLayout bottom =
			factory.createFolder(
				"bottom", //NON-NLS-1
				IPageLayout.BOTTOM,
				0.60f,
				factory.getEditorArea());

		
		IFolderLayout centerRight =
			factory.createFolder(
					"bottomRight", //NON-NLS-1
					IPageLayout.RIGHT,
					0.60f,
					factory.getEditorArea());

		topLeft.addView(ListaFilmow.ID);
		bottom.addView(ListaPlyt.ID);
		
		centerRight.addView(DaneFilmu.ID);
		centerRight.addView(DanePlyty.ID);
	}

	private void addActionSets() {
	}

	private void addPerspectiveShortcuts() {
	}

	private void addNewWizardShortcuts() {
		factory.addNewWizardShortcut(NoweZamowienie.ID);
	}

	private void addViewShortcuts() {
	}

}
