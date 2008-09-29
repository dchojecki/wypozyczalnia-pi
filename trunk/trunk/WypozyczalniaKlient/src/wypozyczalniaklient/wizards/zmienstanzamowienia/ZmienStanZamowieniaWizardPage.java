package wypozyczalniaklient.wizards.zmienstanzamowienia;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

public class ZmienStanZamowieniaWizardPage extends WizardPage {

	private Label stanZamowienia;
	private Group stan;
	private Group przyciski;
	private Button przyjete;
	private Button doOdbioru;
	private Button pozyczone;
	private Button zrealizowane;
	private Button anulowane;
	private Button zalegle;
	/**
	 * Wyœwietlenie przycisków wyboru nastêpnego stanu: ‘przyjête’, ‘gotowe do
	 * odbioru’, ‘po¿yczone’, ‘zrealizowane’, ‘anulowane’ oraz ‘zaleg³e’
	 */

	private ZamowienieTO zamowienie;

	public ZmienStanZamowieniaWizardPage(ZamowienieTO zamowienie) {
		super("wizardPage");
		setTitle("Zmieñ stan zamówienia");
		setDescription("Zaznacz nowy stan");
		this.zamowienie = zamowienie;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		GridData gd;
		container.setLayout(layout);
		layout.numColumns = 1;
		layout.verticalSpacing = 9;

		stan = new Group(container, SWT.BORDER);
		stan.setText("Dane zamówienia");
		gd = new GridData(GridData.FILL_BOTH);
		layout = new GridLayout(2, false);
		stan.setLayout(layout);
		stan.setLayoutData(gd);

		Label t = new Label(stan, SWT.NONE);
		t.setText("Aktualny stan zamówienia:");
		gd = new GridData();
		t.setLayoutData(gd);

		stanZamowienia = new Label(stan, SWT.NONE);
		stanZamowienia.setText(zamowienie.getStanzamowienia().toString());
		gd = new GridData();
		stanZamowienia.setLayoutData(gd);

		przyciski = new Group(container, SWT.BORDER);
		przyciski.setText("Dane zamówienia");
		gd = new GridData(GridData.FILL_BOTH);
		layout = new GridLayout(1, false);
		przyciski.setLayout(layout);
		przyciski.setLayoutData(gd);

		final String przyjeteMsg = "Przyjête";
		final String doOdbioruMsg = "Gotowe do odbioru";
		final String pozyczoneMsg = "Po¿yczone";
		final String zrealizowaneMsg = "Zrealizowane";
		final String zalegleMsg = "Zaleg³e";
		final String anulowaneMsg = "Anulowane";

		przyjete = stworzPrzycisk(przyjeteMsg);
		doOdbioru = stworzPrzycisk(doOdbioruMsg);
		pozyczone = stworzPrzycisk(pozyczoneMsg);
		zrealizowane = stworzPrzycisk(zrealizowaneMsg);
		zalegle = stworzPrzycisk(zalegleMsg);
		anulowane = stworzPrzycisk(anulowaneMsg);

		initialize();
		dialogChanged();
		setControl(container);
	}

	private Button stworzPrzycisk(final String text) {
		Button przycisk;
		GridData gd;
		przycisk = new Button(przyciski, SWT.RADIO);
		przycisk.setText(text);
		gd = new GridData();
		przycisk.setLayoutData(gd);
		przycisk.setEnabled(false);
		return przycisk;
	}

	private void initialize() {

		switch (zamowienie.getStanzamowienia()) {
		case PRZYJETE:
			doOdbioru.setEnabled(true);
			anulowane.setEnabled(true);
			break;
		case DOODIORU:
			anulowane.setEnabled(true);
			pozyczone.setEnabled(true);
			break;
		case POZYCZONE:
			zrealizowane.setEnabled(true);
			break;
		case ZALEGLE:
			break;
		case ZREALIZOWANE:
			break;
		case ANULOWANE:
			break;
		}
	}

	private void dialogChanged() {
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public StanZamowienia getStan() {
		StanZamowienia ret = StanZamowienia.PRZYJETE;
		if (przyjete.getSelection())
			ret = StanZamowienia.PRZYJETE;
		if (doOdbioru.getSelection())
			ret = StanZamowienia.DOODIORU;
		if (anulowane.getSelection())
			ret = StanZamowienia.ANULOWANE;
		if (pozyczone.getSelection())
			ret = StanZamowienia.POZYCZONE;
		if (zalegle.getSelection())
			ret = StanZamowienia.ZALEGLE;
		if (zrealizowane.getSelection())
			ret = StanZamowienia.ZREALIZOWANE;

		return ret;

	}

}