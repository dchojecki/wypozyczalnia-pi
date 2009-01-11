package wypozyczalniaklient.views.listakont;

import java.util.Date;

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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;

import wypozyczalnia.dao.StanPlyty;
import wypozyczalnia.ejb.zarzadzniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiWyjatek;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKontaWyjatek;
import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import wypozyczalniaklient.delegacje.wypozyczenia.ZarzadzanieWypozyczeniamiDelegacja;
import wypozyczalniaklient.editors.danekonta.DaneKontaEdytor;
import wypozyczalniaklient.editors.danekonta.DaneKontaInput;
import wypozyczalniaklient.wizards.nowekonto.KreatorNowegoKonta;
import wypozyczalniaklient.wizards.zablokujkonto.ZablokujKontoWizard;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.PlytaTO;

public class ListaKont extends ViewPart {

	public static final String ID = "wypozyczalniaklient.views.ListaKont";
	private TableViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action zalozKonto;
	private Action usunKonto;
	private Action zablokujKonto;
	private Action doubleClickAction;
	private Action testactionKonto;
	private Action testactionPlyta;

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ListaKont() {
	}

	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
		// drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ListaUzytkownikowCP(this));
		viewer.setLabelProvider(new ViewLabelProvider(this));
		viewer.setSorter(new NameSorter());

		Table table = viewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("Numer konta i klienta");
		column.setWidth(400);

		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Stan");
		column.setWidth(200);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();

		refreshViewer();
	}

	private void refreshViewer() {
		ZarzadzanieKontamiDelegacja k = ZarzadzanieKontamiDelegacja
				.getInstance();
		KontoTOZbior konta = k.pobierzWszystkieKonta();
		this.viewer.setInput(konta);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ListaKont.this.fillContextMenu(manager);
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
		manager.add(zalozKonto);
		manager.add(zablokujKonto);
		manager.add(new Separator());
		manager.add(usunKonto);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(zalozKonto);
		manager.add(usunKonto);
		manager.add(new Separator());
		manager.add(zablokujKonto);
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(zalozKonto);
		manager.add(usunKonto);
		manager.add(new Separator());
		manager.add(zablokujKonto);
		manager.add(testactionKonto);
		manager.add(testactionPlyta);

		// drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		zablokujKonto = new Action() {
			public void run() {
				ZablokujKontoWizard wizard = new ZablokujKontoWizard();
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.create();
				dialog.open();
				refreshViewer();
			}
		};
		zablokujKonto.setText("Zablokuj konto");
		zablokujKonto.setToolTipText("Blokowanie dostêpu do systemu");
		zablokujKonto.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_NEW_WIZARD));
		zalozKonto = new Action() {
			public void run() {
				KreatorNowegoKonta wizard = new KreatorNowegoKonta();
				IStructuredSelection selection = (IStructuredSelection) viewer
						.getSelection();
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				wizard.init(PlatformUI.getWorkbench(), selection);
				WizardDialog dialog = new WizardDialog(shell, wizard);
				dialog.create();
				dialog.open();
				refreshViewer();
			}
		};
		zalozKonto.setText("Za³ó¿ nowe konto");
		zalozKonto.setToolTipText("Kreator zak³adania konta");
		zalozKonto.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_ELEMENT));

		usunKonto = new Action() {
			public void run() {
				ZarzadzanieWypozyczeniami z = ZarzadzanieWypozyczeniamiDelegacja
						.getInstance().getRealSubject();
				KontoTO konto;
				try {
					konto = ZarzadzanieKontamiDelegacja.getInstance()
							.utworzNoweKonto("Kowalski", "Marcin", new Date(),
									"85110916799", "scinek@gmail.com");

					/*
					 * ZarzadzaniePlytamiDelegacja zp =
					 * ZarzadzaniePlytamiDelegacja.getInstance(); FilmTOZbior
					 * filmy = zp.zwrocListeWszystkichFilmow(); for (FilmTO
					 * film: filmy.zwrocWszystkieFilmy()) { PlytaTOZbior plyty =
					 * zp.zwrocListeWszystkichPlyt(film); if
					 * (plyty.zwrocWszystkiePlyty().size() == 0) continue;
					 * 
					 * PlytaTO p =
					 * plyty.zwrocWszystkiePlyty().iterator().next();
					 * ZamowienieTO zz = z.utworzNoweZamowienie();
					 * zz.setKonto(konto); PozycjaZamowieniaTO pz = new
					 * PozycjaZamowieniaTO(); pz.setPlyta(p);
					 * zz.getPozycjezamowienia().add(pz);
					 * z.scalDaneZamowienia(zz); }
					 */
					ListaKont.this.refreshViewer();
				} catch (ZarzadzanieKontamiWyjatek e) {
					e.printStackTrace();
				} catch (WalidatorDanychKontaWyjatek e) {
					e.printStackTrace();
				}

			}
		};
		usunKonto.setText("Usun konto");
		usunKonto.setToolTipText("Sluzy do usuwania konta");
		usunKonto.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_DELETE));
		doubleClickAction = new Action() {
			public void run() {
				try {
					DaneKontaInput in = new DaneKontaInput();
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection)
							.getFirstElement();
					in.setKonto((KontoTO) obj);
					ListaKont.this.getSite().getWorkbenchWindow()
							.getActivePage().openEditor(in, DaneKontaEdytor.ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		};

		testactionKonto = new Action() {
			public void run() {
				ZarzadzanieKontamiDelegacja zk = ZarzadzanieKontamiDelegacja
						.getInstance();
				KontoTO konto;
				try {
					konto = zk.utworzNoweKonto("Kowalski", "Marcin",
							new Date(), "85110916799", "scinek@gmail.com");

					AdresTO adres = new AdresTO();
					adres.setMiast("Wroclaw");
					adres.setNrPeselKlienta(konto.getNrPeselKlienta());
					adres.setUlica("Pilczycka");
					adres.setNrMieszkania(109);
					adres.setNrDomu(3);

					zk.uaktualnijDaneAdresu(adres);

					ListaKont.this.refreshViewer();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		testactionPlyta = new Action() {
			public void run() {
				ZarzadzaniePlytamiDelegacja zp = ZarzadzaniePlytamiDelegacja
						.getInstance();
				FilmTO f = new FilmTO();
				f.setOpisFabuly("fajny film");
				f.setRokPremiery("2008");
				f.setTytul("Indiana Jones");
				zp.dodajFilm(f);

				PlytaTO p = new PlytaTO();
				p.setDataNabycia(new Date());
				p.setStan(StanPlyty.NIEWYPOZYCZONA);
				p.setUwagiDoEgzemplarza("porysowana");
				zp.dodajPlyte(f, p);

				p = new PlytaTO();
				p.setDataNabycia(new Date());
				p.setStan(StanPlyty.NIEWYPOZYCZONA);
				p.setUwagiDoEgzemplarza("porysowana");
				zp.dodajPlyte(f, p);

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

	@SuppressWarnings("unused")
	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Lista u¿ytkowników", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}