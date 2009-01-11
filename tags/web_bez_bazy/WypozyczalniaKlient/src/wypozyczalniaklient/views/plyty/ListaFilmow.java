package wypozyczalniaklient.views.plyty;


import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import wypozyczalniaklient.editors.plyty.DaneFilmuInput;
import wypozyczalniaklient.editors.plyty.FilmEdytor;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import wypozyczalniaklient.views.plyty.listafilmow.NameSorter;
import wypozyczalniaklient.views.plyty.listafilmow.ViewContentProvider;
import wypozyczalniaklient.views.plyty.listafilmow.ViewLabelProvider;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;

public class ListaFilmow extends ViewPart {
	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	private ZarzadzaniePlytamiDelegacja plytyDelegacja;
	FilmTOZbior zbiorFilmow;
	public static String ID = "wypozyczalniaklient.views.plyty.ListaFilmow";
	 
	/**
	 * The constructor.
	 */
	public ListaFilmow() {
		plytyDelegacja = ZarzadzaniePlytamiDelegacja.getInstance();
	}

	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		zbiorFilmow = plytyDelegacja.zwrocListeWszystkichFilmow();

		viewer.setInput(zbiorFilmow);

		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ListaFilmow.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				try {
					DaneFilmuInput in = new DaneFilmuInput();
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection)
							.getFirstElement();
					in.setKonto((FilmTO) obj);
					ListaFilmow.this.getSite().getWorkbenchWindow()
							.getActivePage().openEditor(in, FilmEdytor.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				action1.run();
			}
		};
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				ISelection selection = viewer.getSelection();
				if (selection == null) return;
				IStructuredSelection ssel = (IStructuredSelection) selection;
				if (ssel == null) return;
				FilmTO film = (FilmTO)ssel.getFirstElement();
				if (film == null) return;
				
				SelectionEventProvider.filmTOSelected(film);
				
				
			}});
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Lista filmów",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}