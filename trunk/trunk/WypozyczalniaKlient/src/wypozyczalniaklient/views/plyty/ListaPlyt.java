package wypozyczalniaklient.views.plyty;

import java.util.LinkedList;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import wypozyczalniaklient.editors.DanePlytyInput;
import wypozyczalniaklient.editors.PlytaEdytor;
import wypozyczalniaklient.eventprovider.GlobalListener;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import wypozyczalniaklient.views.plyty.listaplyt.NameSorter;
import wypozyczalniaklient.views.plyty.listaplyt.ViewContentProvider;
import wypozyczalniaklient.views.plyty.listaplyt.ViewLabelProvider;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

public class ListaPlyt extends ViewPart implements GlobalListener {
	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	public static String ID = "wypozyczalniaklient.views.plyty.ListaPlyt";
	private ZarzadzaniePlytamiDelegacja plytyDelegacja;
	PlytaTOZbior zbiorPlyt = new PlytaTOZbior(new LinkedList<PlytaTO>());

	/**
	 * The constructor.
	 */
	public ListaPlyt() {
		plytyDelegacja = ZarzadzaniePlytamiDelegacja.getInstance();
		SelectionEventProvider.addListener(this);
	}

	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(zbiorPlyt);

		Table table = viewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("Numer plyty");
		column.setWidth(80);

		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Stan");
		column.setWidth(400);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				ISelection selection = viewer.getSelection();
				if (selection == null)
					return;
				IStructuredSelection ssel = (IStructuredSelection) selection;
				if (ssel == null)
					return;
				PlytaTO plyta = (PlytaTO) ssel.getFirstElement();
				if (plyta == null)
					return;
				SelectionEventProvider.plytaTOSelected(plyta);

			}
		});
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
				ListaPlyt.this.fillContextMenu(manager);
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
					DanePlytyInput in = new DanePlytyInput();
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection)
							.getFirstElement();
					in.setKonto((PlytaTO) obj);
					ListaPlyt.this.getSite().getWorkbenchWindow()
							.getActivePage().openEditor(in, PlytaEdytor.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};
		action1.setText("Edytuj dane p³yty");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				action1.run();
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Lista p³yt", message);
	}

	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void FilmTOSelected(FilmTO film) {
		viewer.getTable().setEnabled(true);
		zbiorPlyt = plytyDelegacja.zwrocListeWszystkichPlyt(film);
		viewer.setInput(zbiorPlyt);
	}

	@Override
	public void PlytaTOSelected(PlytaTO plyta) {

	}

	public void dispose() {
		SelectionEventProvider.removeListener(this);
	}

	@Override
	public void PozycjaZamowieniaTOSelected(PozycjaZamowieniaTO plyta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ZamowienieTOSelected(ZamowienieTO plyta) {
		// TODO Auto-generated method stub
		
	}
}