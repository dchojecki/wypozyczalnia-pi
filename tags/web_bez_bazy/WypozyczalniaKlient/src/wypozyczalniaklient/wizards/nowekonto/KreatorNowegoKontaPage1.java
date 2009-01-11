package wypozyczalniaklient.wizards.nowekonto;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import wypozyczalniaklient.delegacje.konta.walidacja.IWalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKonta;
import wypozyczalniaklient.delegacje.konta.walidacja.WalidatorDanychKontaWyjatek;
import wypozyczalniaklient.kontrolki.KontrolkaKalendarza;

public class KreatorNowegoKontaPage1 extends WizardPage {
	private Text containerText;
	private Text nazwiskoText;
	private Text imieText;
	private Text mailText;
	private Text dataUrodzeniaText;
	private Text peselText;

	private IWalidatorDanychKonta walidator = WalidatorDanychKonta
			.pobierzWalidator(false);

	public KreatorNowegoKontaPage1() {
		super("utworzKontoKreatorPage");
		setTitle("Wy�lij pro�b� o utworzenie konta");
		setDescription("Dane potrzebne do utworzenia nowego konta:");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		layout.marginTop = 40;
		layout.marginLeft = 30;

		Label nazwiskoLabel = new Label(container, SWT.NULL);
		nazwiskoLabel.setText("&Nazwisko:");

		nazwiskoText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData();
		gd.widthHint = 150;
		nazwiskoText.setLayoutData(gd);
		ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		};
		nazwiskoText.addModifyListener(modifyListener);
		nazwiskoText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		// placeholder
		nazwiskoLabel = new Label(container, SWT.NULL);

		Label imieLabel = new Label(container, SWT.NULL);
		imieLabel.setText("&Imi�:");

		imieText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 150;
		imieText.setLayoutData(gd);
		imieText.addModifyListener(modifyListener);
		nazwiskoLabel = new Label(container, SWT.NULL);

		Label mailLabel = new Label(container, SWT.NULL);
		mailLabel.setText("&Adres e-mailowy:");

		mailText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 120;
		mailText.setLayoutData(gd);
		mailText.addModifyListener(modifyListener);
		nazwiskoLabel = new Label(container, SWT.NULL);

		Label dataUrodzeniaLabel = new Label(container, SWT.NULL);
		dataUrodzeniaLabel.setText("&Data urodzenia:");

		dataUrodzeniaText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 90;
		dataUrodzeniaText.setLayoutData(gd);
		dataUrodzeniaText.addModifyListener(modifyListener);

		Button otworzKalendarz = new Button(container, SWT.PUSH);
		otworzKalendarz.setText("Kalendarz");
		otworzKalendarz.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				final Shell shell = getShell();
				KontrolkaKalendarza cd = new KontrolkaKalendarza(shell);
				String dataString = (String) cd.open();
				// Date data = new Date(dataString);
				dataUrodzeniaText.setText(dataString);
				// dataUrodzeniaText.setData(data);
			}
		});
		gd = new GridData();
		gd.widthHint = 100;
		otworzKalendarz.setLayoutData(gd);

		Label peselLabel = new Label(container, SWT.NULL);
		peselLabel.setText("&Numer PESEL:");

		peselText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 90;
		peselText.setLayoutData(gd);
		peselText.addModifyListener(modifyListener);
		nazwiskoLabel = new Label(container, SWT.NULL);
		dialogChanged();
		setControl(container);
	}

	private void dialogChanged() {
		String wynikWalidacji = null;

		try {
			walidator.zwalidujNazwisko(nazwiskoText.getText());
			walidator.zwalidujImie(imieText.getText());
			walidator.zwalidujMail(mailText.getText());
			walidator.zwalidujPESEL(peselText.getText());
			walidator.zwalidujDateUrodzenia(dataUrodzeniaText.getText());
//			walidator.zwalidujDateUrodzeniaZPeselem(dataUrodzeniaText.getText(), peselText.getText());
		} catch (WalidatorDanychKontaWyjatek e) {
			wynikWalidacji = e.getMessage();
		}

		if (wynikWalidacji != null) {
			updateStatus(wynikWalidacji);
			return;
		}
		// ok:
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setPageComplete(message == null);
		setErrorMessage(message);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getNazwisko() {
		return nazwiskoText.getText();
	}

	public String getImie() {
		return imieText.getText();
	}

	public String getMail() {
		return mailText.getText();
	}

	public String getDataUrodzenia() {
		return dataUrodzeniaText.getText();
	}

	public String getPesel() {
		return peselText.getText();
	}

}