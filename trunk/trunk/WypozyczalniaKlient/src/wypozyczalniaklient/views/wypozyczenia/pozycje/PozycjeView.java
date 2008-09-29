package wypozyczalniaklient.views.wypozyczenia.pozycje;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.eventprovider.GlobalListener;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;

public class PozycjeView extends ViewPart implements GlobalListener {
	private Table viewer;
	private Action action1;
	private Action action2;
	private PozycjaZamowieniaTO pozycja;

	public static final String ID = "wypozyczalniaklient.views.wypozyczenia.pozycje.PozycjeView";

	public PozycjeView() {
		SelectionEventProvider.addListener(this);
	}

	public void createPartControl(Composite parent) {
		viewer = new Table(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setLinesVisible(true);
		viewer.setHeaderVisible(true);

		TableColumn c1 = new TableColumn(viewer, SWT.NONE);
		c1.setText("Atrybut");
		c1.setWidth(200);
		TableColumn c2 = new TableColumn(viewer, SWT.NONE);
		c2.setText("Wartosc");
		c2.setWidth(300);

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
				PozycjeView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer);
		viewer.setMenu(menu);
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
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

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
		// TODO Auto-generated method stub

	}

	@Override
	public void PlytaTOSelected(PlytaTO plyta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void PozycjaZamowieniaTOSelected(PozycjaZamowieniaTO plyta) {
		pozycja = plyta;
		
		viewer.removeAll();
		TableItem t1 = new TableItem(viewer, SWT.NONE);
		t1.setText(0, "Identyfikator filmu");
		t1.setText(1, ((Integer)pozycja.getPlyta().getIdFilmu()).toString());

		TableItem t2 = new TableItem(viewer, SWT.NONE);
		t2.setText(0, "Identyfikator p³yty");
		t2.setText(1, ((Integer)pozycja.getPlyta().getIdPlyty()).toString());

		
		TableItem t3 = new TableItem(viewer, SWT.NONE);
		t3.setText(0, "Cena");
		t3.setText(1, pozycja.getCenaJednostkowa().toString());

		TableItem t4 = new TableItem(viewer, SWT.NONE);
		t4.setText(0, "Tytu³");
		t4.setText(1, pozycja.getPlyta().getTytul());
		
		TableItem t5 = new TableItem(viewer, SWT.NONE);
		t5.setText(0, "Stan");
		t5.setText(1, pozycja.getPlyta().getStan().toString());
		
	}

	@Override
	public void ZamowienieTOSelected(ZamowienieTO plyta) {
		// TODO Auto-generated method stub

	}

	public void dispose() {
		SelectionEventProvider.removeListener(this);
	}
}