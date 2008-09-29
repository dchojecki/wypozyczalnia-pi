package wypozyczalniaklient.views.plyty;


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
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalniaklient.eventprovider.GlobalListener;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;


public class DanePlyty extends ViewPart  implements GlobalListener{
	private Table viewer;
	public static String ID = "wypozyczalniaklient.views.plyty.DanePlyty";

	public DanePlyty() {
		SelectionEventProvider.addListener(this);
	}

	public void createPartControl(Composite parent) {
		viewer = new Table(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		viewer.setLinesVisible(true);
		viewer.setHeaderVisible(true);

		TableColumn c1 = new TableColumn(viewer, SWT.NONE);
		c1.setText("Atrybut");
		c1.setWidth(100);
		TableColumn c2 = new TableColumn(viewer, SWT.NONE);
		c2.setText("Wartosc");
		c2.setWidth(100);

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
				DanePlyty.this.fillContextMenu(manager);
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
	}

	private void fillContextMenu(IMenuManager manager) {
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
	}

	private void makeActions() {
		
	}

	private void hookDoubleClickAction() {
	}

	public void setFocus() {
		viewer.setFocus();
	}

	private FilmTO aktualnyFilm;
	@Override
	public void FilmTOSelected(FilmTO film) {
		if (film != aktualnyFilm)
			viewer.removeAll();
		aktualnyFilm = film;
		
	}

	@Override
	public void PlytaTOSelected(PlytaTO plyta) {
		
		viewer.removeAll();
		TableItem t4 = new TableItem(viewer, SWT.NONE);
		t4.setText(0, "Idenyfikator");
		t4.setText(1, ((Integer)plyta.getIdPlyty()).toString());

		TableItem t5 = new TableItem(viewer, SWT.NONE);
		t5.setText(0, "Tytul");
		t5.setText(1, plyta.getTytul());

		
		TableItem t1 = new TableItem(viewer, SWT.NONE);
		t1.setText(0, "Stan");
		t1.setText(1, plyta.getStan().toString());

		TableItem t2 = new TableItem(viewer, SWT.NONE);
		t2.setText(0, "Data nabycia");
		
		if (plyta.getDataNabycia() != null)
		t2.setText(1, plyta.getDataNabycia().toString());
		else
			t2.setText(1, "");

		TableItem t3 = new TableItem(viewer, SWT.NONE);
		t3.setText(0, "Uwagi");
		t3.setText(1, plyta.getUwagiDoEgzemplarza());


		
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