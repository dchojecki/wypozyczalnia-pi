package wypozyczalniaklient.views.wypozyczenia;


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


public class ZamowienieView extends ViewPart implements GlobalListener{
	private Table viewer;
	private Action action1;
	private Action action2;
	private ZamowienieTO zamowienie;
	
	public static final String ID = "wypozyczalniaklient.views.wypozyczenia.ZamowienieView";

	public ZamowienieView() {
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
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ZamowienieView.this.fillContextMenu(manager);
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
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ZamowienieTOSelected(ZamowienieTO z) {
		zamowienie = z;
		
		viewer.removeAll();
		TableItem t1 = new TableItem(viewer, SWT.NONE);
		t1.setText(0, "Identyfikator");
		t1.setText(1, zamowienie.getId().toString());

		TableItem t2 = new TableItem(viewer, SWT.NONE);
		t2.setText(0, "Stan");
		t2.setText(1, zamowienie.getStanzamowienia().toString());

		TableItem t3 = new TableItem(viewer, SWT.NONE);
		t3.setText(0, "Data przyjecia");
		if (zamowienie.getDataPrzyjecia() != null)
			t3.setText(1, zamowienie.getDataPrzyjecia().toString());
		else
			t3.setText(1, "");

		TableItem t4 = new TableItem(viewer, SWT.NONE);
		t4.setText(0, "Data do-odbioru");
		if (zamowienie.getDataDoOdbioru() != null)
			t4.setText(1, zamowienie.getDataDoOdbioru().toString());
		else
			t4.setText(1, "");
		
		TableItem t5 = new TableItem(viewer, SWT.NONE);
		t5.setText(0, "Data realizacji");
		if (zamowienie.getDataRealizacji() != null)
			t5.setText(1, zamowienie.getDataRealizacji().toString());
		else
			t5.setText(1, "");
		
		TableItem t6 = new TableItem(viewer, SWT.NONE);
		t6.setText(0, "Data anulowania");
		if (zamowienie.getDataAnulowane() != null)
			t6.setText(1, zamowienie.getDataAnulowane().toString());
		else
			t6.setText(1, "");
		
		TableItem t7 = new TableItem(viewer, SWT.NONE);
		t7.setText(0, "Data zalegle");
		if (zamowienie.getDataZalegle() != null)
			t7.setText(1, zamowienie.getDataZalegle().toString());
		else
			t7.setText(1, "");
		
		
	}
	
	public void dispose() {
		SelectionEventProvider.removeListener(this);
	}
}