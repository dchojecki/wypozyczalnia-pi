package wypozyczalniaklient.views.listawypozyczen;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTOZbior;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;
import wypozyczalniaklient.eventprovider.SelectionEventProvider;
import wypozyczalniaklient.wizards.nowapozycja.NowaPozycjaZamowieniaWizard;
import wypozyczalniaklient.wizards.nowezamowienie.NoweZamowienie;
import wypozyczalniaklient.wizards.zapytanieozamowienia.WypozyczeniaZapytanie;
import wypozyczalniaklient.wizards.zmienstanzamowienia.ZmienStanZamowieniaWizard;

public class ListaWypozyczen extends ViewPart {

	public static final String ID = "wypozyczalniaklient.views.ListaWypozyczen";
	private TreeViewer viewer;
	private ZamowienieTO current;
	private DrillDownAdapter drillDownAdapter;
	private Action zapytanie;
	private Action nowapozycja;
	private Action nowezamowienie;
	private Action zmienStanZamowienia;
	private Action doubleClickAction;

	/**
	 * The constructor.
	 */
	public ListaWypozyczen() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		refreshViewer();
	}

	public void refreshViewer() {
		ZarzadzanieWypozyczeniami z = ZarzadzanieWypozyczeniamiDelegacja
				.getInstance().getRealSubject();
		ZamowienieTOZbior zamowienia = z.pobierzWszystkieZamowienia();
		viewer.setInput(zamowienia);
		viewer.refresh();
		viewer.expandAll();

	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ListaWypozyczen.this.fillContextMenu(manager);
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
		manager.add(zapytanie);
		manager.add(new Separator());
		manager.add(nowezamowienie);
		manager.add(nowapozycja);
		manager.add(zmienStanZamowienia);

	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(zapytanie);
		manager.add(nowezamowienie);
		manager.add(nowapozycja);
		manager.add(new Separator());
		manager.add(zmienStanZamowienia);
		drillDownAdapter.addNavigationActions(manager);
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(zapytanie);
		manager.add(nowezamowienie);
		manager.add(nowapozycja);
		manager.add(zmienStanZamowienia);

		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	@SuppressWarnings("deprecation")
	private void makeActions() {
		zapytanie = new Action() {
			public void run() {
				WypozyczeniaZapytanie wizard = new WypozyczeniaZapytanie();
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.create();
				dialog.open();
				ListaWypozyczen.this.refreshViewer();
			}
		};
		zapytanie.setText("Listuj zamówienia");
		zapytanie.setToolTipText("Kreator nowego zapytania o zamówienia");
		zapytanie.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_FOLDER));

		nowezamowienie = new Action() {
			public void run() {

				NoweZamowienie wizard = new NoweZamowienie();
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.setPageSize(400, 400);
				dialog.create();
				dialog.open();
				ListaWypozyczen.this.refreshViewer();
			}
		};
		nowezamowienie.setText("Z³ó¿ zamowienie");
		nowezamowienie.setToolTipText("Kreator nowego zamówienia");
		nowezamowienie.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_FILE));
		doubleClickAction = new Action() {
			public void run() {
			}
		};

		nowapozycja = new Action() {
			public void run() {
				if (current == null)
					return;
				NowaPozycjaZamowieniaWizard wizard = new NowaPozycjaZamowieniaWizard(
						current);
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.setPageSize(400, 500);
				dialog.create();
				dialog.open();
				ListaWypozyczen.this.refreshViewer();
			}
		};
		nowapozycja.setText("Nowa pozycja zamówienia");
		nowapozycja.setToolTipText("Kreator nowego zamówienia");
		nowezamowienie.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJS_TASK_TSK));
		zmienStanZamowienia = new Action() {
			public void run() {
				if (current == null)
					return;
				ZmienStanZamowieniaWizard wizard = new ZmienStanZamowieniaWizard();
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.setPageSize(300, 250);
				dialog.create();
				dialog.open();
				ListaWypozyczen.this.refreshViewer();
			}
		};
		zmienStanZamowienia.setText("Zmieñ stan");
		zmienStanZamowienia.setToolTipText("Zmieñ stan zamówienia");
		zmienStanZamowienia.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_DEF_VIEW));

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent arg0) {
				IStructuredSelection ssel = (IStructuredSelection) arg0
						.getSelection();
				if (ssel == null)
					return;
				if ((ssel.getFirstElement() instanceof ZamowienieTO)) {
					ZamowienieTO z = (ZamowienieTO) ssel.getFirstElement();
					current = z;
					if (z == null)
						return;
					SelectionEventProvider.zamowienieTOSelected(z);
				}
				if ((ssel.getFirstElement() instanceof PozycjaZamowieniaTO)) {
					PozycjaZamowieniaTO z = (PozycjaZamowieniaTO) ssel
							.getFirstElement();
					SelectionEventProvider.pozyucjaTOSelected(z);
				}

			}
		});
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	@SuppressWarnings("unused")
	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Lista Wypozyczen", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}