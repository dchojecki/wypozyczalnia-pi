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

import wypozyczalniaklient.views.listakont.ListaKont;



public class KontaPerspektywa implements IPerspectiveFactory {

	public static final String ID = "wypozyczalniaklient.perspectives.KontaPerspektywa";
	private IPageLayout factory;

	public KontaPerspektywa() {
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
		
		IFolderLayout bottom =
			factory.createFolder(
				"bottomRight", //NON-NLS-1
				IPageLayout.BOTTOM,
				0.60f,
				factory.getEditorArea());

		IFolderLayout topLeft =
			factory.createFolder(
				"topLeft", //NON-NLS-1a
				IPageLayout.LEFT,
				0.25f,
				factory.getEditorArea());
		bottom.addView(ListaKont.ID);
		
	}

	private void addActionSets() {
/*		factory.addActionSet("org.eclipse.debug.ui.launchActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.debug.ui.debugActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.debug.ui.profileActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.jdt.debug.ui.JDTDebugActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.jdt.junit.JUnitActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.team.ui.actionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.team.cvs.ui.CVSActionSet"); //NON-NLS-1
		factory.addActionSet("org.eclipse.ant.ui.actionSet.presentation"); //NON-NLS-1
		factory.addActionSet(JavaUI.ID_ACTION_SET);
		factory.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
		factory.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET); //NON-NLS-1
*/	}

	private void addPerspectiveShortcuts() {
/*		factory.addPerspectiveShortcut("org.eclipse.team.ui.TeamSynchronizingPerspective"); //NON-NLS-1
		factory.addPerspectiveShortcut("org.eclipse.team.cvs.ui.cvsPerspective"); //NON-NLS-1
		factory.addPerspectiveShortcut("org.eclipse.ui.resourcePerspective"); //NON-NLS-1
*/	}

	private void addNewWizardShortcuts() {
/*		factory.addNewWizardShortcut("org.eclipse.team.cvs.ui.newProjectCheckout");//NON-NLS-1
		factory.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//NON-NLS-1
		factory.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//NON-NLS-1
*/	}

	private void addViewShortcuts() {
	}


}
