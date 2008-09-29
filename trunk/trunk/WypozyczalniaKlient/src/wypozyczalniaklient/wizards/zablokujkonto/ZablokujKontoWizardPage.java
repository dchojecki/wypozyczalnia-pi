package wypozyczalniaklient.wizards.zablokujkonto;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import wypozyczalnia.dao.StanKonta;
import wypozyczalnia.to.zarzadzaniekontami.AdresTO;
import wypozyczalnia.to.zarzadzaniekontami.KlientTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiWyjatek;
import wypozyczalniaklient.delegacje.konta.walidacja.IWalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKontaWyjatek;

public class ZablokujKontoWizardPage extends WizardPage {

	private KontoTO konto;
	private Label label;
	private Text nrPeselKlienta;
	private Combo nrKontaCombo;
	private Group daneOsoboweGrupa;
	private Group daneKontaGrupa;
	private Label ostatnieLogowanie;
	private Label stanKonta;
	private Label imie, nazwisko;
	private Label miasto, ulica, nrDomu, nrMieszkania;
	private IWalidatorDanychKonta walidator = WalidatorDanychKonta
			.pobierzWalidator(false);
	private Color errorColor = new Color(null, 255, 0, 0);;
	private Color normalColor;
	private Font font2 = new Font(null, "Arial", 13, SWT.BOLD);
	private Font font3 = new Font(null, "Times", 11, SWT.NORMAL);

	public ZablokujKontoWizardPage(ISelection selection, KontoTO konto) {
		super("wizardPage");
		setTitle("Blokowanie konta");
		this.konto = konto;
		setDescription("");

	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 10;
		container.setLayout(layout);
		label = new Label(container, SWT.NULL);
		label.setText("&Numer PESEL klienta:");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setFont(font2);
		label.setLayoutData(gd);

		nrPeselKlienta = new Text(container, SWT.BORDER | SWT.SINGLE);
		nrPeselKlienta.setFont(font2);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nrPeselKlienta.setLayoutData(gd);
		nrPeselKlienta.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		label = new Label(container, SWT.NULL);
		label.setText("&Numer konta:");

		nrKontaCombo = new Combo(container, SWT.BORDER | SWT.SINGLE
				| SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nrKontaCombo.setLayoutData(gd);
		nrKontaCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged2();
			}
		});

		daneOsoboweGrupa = new Group(container, SWT.BORDER);
		daneOsoboweGrupa.setFont(font2);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		daneOsoboweGrupa.setText("Dane osobowe:");
		daneOsoboweGrupa.setLayoutData(gd);
		layout = new GridLayout();
		layout.numColumns = 2;
		daneOsoboweGrupa.setLayout(layout);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Nazwisko:");

		nazwisko = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nazwisko.setLayoutData(gd);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Imie:");
		imie = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		imie.setLayoutData(gd);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Miasto:");
		miasto = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		miasto.setLayoutData(gd);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Ulica:");
		ulica = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		ulica.setLayoutData(gd);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Numer domu:");
		nrDomu = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nrDomu.setLayoutData(gd);

		label = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Numer mieszkania:");
		nrMieszkania = new Label(daneOsoboweGrupa, SWT.NONE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nrMieszkania.setLayoutData(gd);

		daneKontaGrupa = new Group(container, SWT.BORDER);
		daneKontaGrupa.setFont(font2);
		gd = new GridData(GridData.FILL_BOTH);
		gd.horizontalSpan = 2;
		daneKontaGrupa.setText("Dane konta:");
		daneKontaGrupa.setLayoutData(gd);
		layout = new GridLayout();
		layout.numColumns = 2;
		daneKontaGrupa.setLayout(layout);

		label = new Label(daneKontaGrupa, SWT.NONE);
		label.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Stan konta:");
		stanKonta = new Label(daneKontaGrupa, SWT.NONE);
		stanKonta.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		stanKonta.setLayoutData(gd);
		normalColor = stanKonta.getBackground();

		label = new Label(daneKontaGrupa, SWT.NONE);
		label.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setText("Data ostatniego logowania");
		ostatnieLogowanie = new Label(daneKontaGrupa, SWT.NONE);
		ostatnieLogowanie.setFont(font3);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		ostatnieLogowanie.setLayoutData(gd);

		initialize();
		dialogChanged();
		setControl(container);
	}

	private void initialize() {
		if (this.konto != null)
			nrPeselKlienta.setText(konto.getNrPeselKlienta());

	}

	private void dialogChanged() {
		try {
			String input = nrPeselKlienta.getText();
			walidator.zwalidujPESEL(input);

			KlientTO poprzednie = (KlientTO) nazwisko.getData();

			if (poprzednie != null
					&& poprzednie.getNrPeselKlienta().equals(input))
				return;
			KlientTO k = ZarzadzanieKontamiDelegacja.getInstance()
					.zwrocDaneKlienta(input);
			AdresTO a = ZarzadzanieKontamiDelegacja.getInstance()
					.zwrocDaneAdresu(input);
			KontoTO konto = ZarzadzanieKontamiDelegacja.getInstance()
					.zwrocDaneKonta(input);
			nazwisko.setData(k);
			nazwisko.setText(k.getNazwisko());
			imie.setText(k.getImie());
			miasto.setText(a.getMiast());
			ulica.setText(a.getUlica());
			nrDomu.setText(a.getNrDomu().toString());
			nrMieszkania.setText(a.getNrMieszkania().toString());

			nrKontaCombo.clearSelection();
			nrKontaCombo.setData(konto);
			nrKontaCombo.add(konto.getNrKonta().toString());
			nrKontaCombo.select(0);

			updateStatus(null);
		} catch (WalidatorDanychKontaWyjatek e) {
			updateStatus("Nieprawid³owy numer PESEL");
		} catch (ZarzadzanieKontamiWyjatek e) {
			updateStatus("Nie znaleziono klienta o tym numerze PESEL");
		}
	}

	private void dialogChanged2() {
		KontoTO k = (KontoTO) nrKontaCombo.getData();
		stanKonta.setText(k.getStanKonta().toString());
		ostatnieLogowanie.setText(k.getDataOstatniegoLogowania().toString());
		if (k.getStanKonta().equals(StanKonta.ZABLOKOWANE)) {
			stanKonta.setBackground(errorColor);
		} else {
			stanKonta.setBackground(normalColor);
		}
	}

	private void updateStatus(String message) {
		KontoTO k = (KontoTO) nrKontaCombo.getData();
		StanKonta sk = k != null ? k.getStanKonta() : null;
		setErrorMessage(message);
		setPageComplete(message == null && sk != null
				&& sk != StanKonta.ZABLOKOWANE);
	}

	public String getNrPeselKlienta() {
		return nrPeselKlienta.getText();
	}

}