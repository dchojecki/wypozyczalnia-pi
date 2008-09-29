package wypozyczalniaklient.views.plyty;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import wypozyczalniaklient.eventprovider.GlobalListener;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;

public class DaneFilmu extends ViewPart implements GlobalListener {
	private Table viewer;
	private Action action1;
	private Action action2;

	public static String ID = "wypozyczalniaklient.views.plyty.DaneFilmu";
	private ZarzadzaniePlytamiDelegacja plytyDelegacja;
	FilmTOZbior zbiorFilmow;

	/**
	 * The constructor.
	 */
	public DaneFilmu() {
		plytyDelegacja = ZarzadzaniePlytamiDelegacja.getInstance();

		SelectionEventProvider.addListener(this);
	}

	public void createPartControl(Composite parent) {
		viewer = new Table(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		viewer.setLinesVisible(true);
		viewer.setHeaderVisible(true);

		TableColumn c1 = new TableColumn(viewer, SWT.NONE);
		c1.setText("Atrybut");
		c1.setWidth(100);
		TableColumn c2 = new TableColumn(viewer, SWT.NONE);
		c2.setText("Wartosc");
		c2.setWidth(100);

		zbiorFilmow = plytyDelegacja.zwrocListeWszystkichFilmow();
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
				DaneFilmu.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer);
		viewer.setMenu(menu);
		// getSite().registerContextMenu(menuMgr, viewer.getse);
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

		getSite().getWorkbenchWindow().getSelectionService()
				.addSelectionListener(new ISelectionListener() {

					@Override
					public void selectionChanged(IWorkbenchPart arg0,
							ISelection arg1) {
						System.out.println("adf");

					}
				});
		action1 = new Action() {
			public void run() {
				zbiorFilmow = plytyDelegacja.zwrocListeWszystkichFilmow();
				// viewer.setInput(zbiorFilmow);
			}
		};
		action1.setText("Pobierz plyty");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

		action2 = new Action() {
			public void run() {
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

	private void hookDoubleClickAction() {
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.setFocus();
	}

	@Override
	public void FilmTOSelected(FilmTO film) {
		viewer.removeAll();
		TableItem t1 = new TableItem(viewer, SWT.NONE);
		t1.setText(0, "Tytul");
		t1.setText(1, film.getTytul());

		TableItem t2 = new TableItem(viewer, SWT.NONE);
		t2.setText(0, "Identyfikator");
		t2.setText(1, film.getId().toString());

		TableItem t3 = new TableItem(viewer, SWT.NONE);
		t3.setText(0, "Rok premiery");
		if (film.getRokPremiery() != null)
			t3.setText(1, film.getRokPremiery().toString());
		else
			t3.setText(1, "");

		TableItem t4 = new TableItem(viewer, SWT.NONE);
		t4.setText(0, "Opis fabuly");
		t4.setText(1, film.getOpisFabuly());

	}

	@Override
	public void PlytaTOSelected(PlytaTO plyta) {
		// TODO Auto-generated method stub

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