package wypozyczalniaklient.wizards.nowapozycja;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import wypozyczalnia.dao.StanPlyty;
import wypozyczalniaklient.delegacje.plyty.ZarzadzaniePlytamiDelegacja;
import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;
import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

public class NoweZamowieniePozycjaPage extends WizardPage {

	private Label label;
	private Text input;
	private Group daneFilmowGrupa;
	private Group daneFilmuGrupa;
	private Group danePlytGrupa;

	private PlytaTO plyta;
	private Label tytulFilmu;
	private Label opisFabuly;
	private Label dataPremiery;

	private List filmy;
	private FilmTOZbior filmyTO;
	private PlytaTOZbior plytyTO;

	private Font font1 = new Font(null, "Arial", 14, SWT.NORMAL);
	private Font font2 = new Font(null, "Arial", 13, SWT.BOLD);
	private Font font3 = new Font(null, "Arial", 12, SWT.BOLD | SWT.ITALIC);

	private TableViewer plyty;

	String stany[] = new String[StanPlyty.values().length];
	{
		for (int i = 0; i < stany.length; ++i) {
			stany[i] = StanPlyty.values()[i].toString();
		}
	}

	public NoweZamowieniePozycjaPage(ISelection selection) {
		super("wizardPage");
		setTitle("Kreator nowego zamowienia");
		setDescription("");
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {

		ZarzadzaniePlytamiDelegacja d = ZarzadzaniePlytamiDelegacja
				.getInstance();
		filmyTO = d.zwrocListeWszystkichFilmow();
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		label = new Label(container, SWT.NULL);
		label.setText("&Tytu³ filmu:");

		input = new Text(container, SWT.BORDER | SWT.SINGLE);
		input.setFont(font1);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		input.setLayoutData(gd);
		input.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		daneFilmowGrupa = new Group(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		daneFilmowGrupa.setLayoutData(gd);
		layout = new GridLayout();
		layout.numColumns = 2;
		daneFilmowGrupa.setLayout(layout);
		daneFilmowGrupa.setText("Znalezione filmy:");

		filmy = new List(daneFilmowGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		filmy.setFont(font2);
		filmy.setLayoutData(gd);
		filmy.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				if (filmy.getSelectionCount() < 1)
					return;
				String selectedText = filmy.getSelection()[0];
				FilmTO film = (FilmTO) filmy.getData(selectedText);
				if (film == null)
					return;

				ZarzadzaniePlytamiDelegacja d = ZarzadzaniePlytamiDelegacja
						.getInstance();
				filmyTO = d.zwrocListeWszystkichFilmow();
				plytyTO = d.zwrocListeWszystkichPlyt(film);

				tytulFilmu.setText(film.getTytul());
				if (film.getRokPremiery() != null)
					dataPremiery.setText(film.getRokPremiery().toString());
				opisFabuly.setText(film.getOpisFabuly());

				plyty.setInput(plytyTO);
			}
		});

		daneFilmuGrupa = new Group(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		daneFilmuGrupa.setLayoutData(gd);
		daneFilmuGrupa.setText("Dane filmu:");
		layout = new GridLayout();
		layout.numColumns = 2;
		daneFilmuGrupa.setLayout(layout);

		label = new Label(daneFilmuGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		label.setLayoutData(gd);
		label.setText("Tytul filmu:");
		tytulFilmu = new Label(daneFilmuGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		// gd.verticalIndent = 20;
		gd.horizontalSpan = 2;
		tytulFilmu.setLayoutData(gd);
		tytulFilmu.setFont(font3);

		label = new Label(daneFilmuGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		label.setLayoutData(gd);
		label.setText("Rok premiery:");
		dataPremiery = new Label(daneFilmuGrupa, SWT.NONE);
		dataPremiery.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		dataPremiery.setLayoutData(gd);

		label = new Label(daneFilmuGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		label.setLayoutData(gd);
		label.setText("Opis fabuly:");
		opisFabuly = new Label(daneFilmuGrupa, SWT.NONE);
		opisFabuly.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		opisFabuly.setLayoutData(gd);

		danePlytGrupa = new Group(container, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		danePlytGrupa.setText("Dostêpne egzemplarze:");
		gd.horizontalSpan = 2;
		danePlytGrupa.setLayoutData(gd);
		layout = new GridLayout();
		layout.numColumns = 2;
		danePlytGrupa.setLayout(layout);

		plyty = new TableViewer(danePlytGrupa,  SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		plyty.setUseHashlookup(true);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
//		gd.heightHint = 200;
		Table table = plyty.getTable();
		table.setLayoutData(gd);
		plyty.setContentProvider(new PlytyZbiorCP());
		plyty.setLabelProvider(new PlytyZbiorLP());
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		plyty.setSorter(new PlytySorter());
		String[] kolumny = new String[] { "status", "uwagi" };
		plyty.setColumnProperties(kolumny);

		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("Stan");
		column.setWidth(150);

		column = new TableColumn(table, SWT.LEFT, 1);
		column.setText("Uwagi");
		column.setWidth(200);
		plyty.getTable().layout();
		danePlytGrupa.layout();
		CellEditor[] editors = new CellEditor[kolumny.length];
		editors[0] = new ComboBoxCellEditor(table, stany, SWT.NONE);
		editors[1] = null;
		plyty.setCellEditors(editors);
		plyty.setCellModifier(new PlytyZbiorCellModifier());
		
		initialize();
		dialogChanged();
		setControl(container);
	}

	private void initialize() {

	}

	private void dialogChanged() {
		String s = input.getText();
		if (s.length() == 0)
			return;
		Pattern p = null;
		p = Pattern.compile("\\p{ASCII}*" + s.toUpperCase() + "\\p{ASCII}*");
		Collection<FilmTO> wszystkie = filmyTO.zwrocWszystkieFilmy();
		filmy.removeAll();
		for (FilmTO f : wszystkie) {
			Matcher m = p.matcher(f.getTytul().toUpperCase());
			if (m.matches()) {
				filmy.add(f.getTytul());
				filmy.setData(f.getTytul(), f);
			}
		}
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	/**
	 * @param plyta the plyta to set
	 */
	public void setPlyta(PlytaTO plyta) {
		this.plyta = plyta;
	}

	/**
	 * @return the plyta
	 */
	public PlytaTO getPlyta() {
		return plyta;
	}

}