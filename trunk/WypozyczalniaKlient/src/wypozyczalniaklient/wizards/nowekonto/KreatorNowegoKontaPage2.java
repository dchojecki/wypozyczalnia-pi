package wypozyczalniaklient.wizards.nowekonto;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class KreatorNowegoKontaPage2 extends WizardPage {
	private Text miasto;
	private Text ulica;
	private Text nrDomu;
	private Text nrMieszkania;

	public KreatorNowegoKontaPage2() {
		super("utworzKontoKreatorPage");
		setTitle("Wyœlij proœbê o utworzenie konta");
		setDescription("Dane adresu:");
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		layout.marginTop = 40;
		layout.marginLeft = 30;

		Label label = new Label(container, SWT.NULL);
		label.setText("&Miasto:");

		miasto = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData();
		gd.widthHint = 150;
		miasto.setLayoutData(gd);
		ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		};
		miasto.addModifyListener(modifyListener);
		// placeholder
		label = new Label(container, SWT.NULL);
		
		
		label = new Label(container, SWT.NULL);
		label.setText("&Ulica:");
		
		ulica = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 150;
		ulica.setLayoutData(gd);
		ulica.addModifyListener(modifyListener);
		// placeholder
		label = new Label(container, SWT.NULL);
		
		

		Label imieLabel = new Label(container, SWT.NULL);
		imieLabel.setText("&Numer domu:");

		nrDomu = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 150;
		nrDomu.setLayoutData(gd);
		nrDomu.addModifyListener(modifyListener);
		label = new Label(container, SWT.NULL);

		Label mailLabel = new Label(container, SWT.NULL);
		mailLabel.setText("&Numer mieszkania:");

		nrMieszkania = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData();
		gd.widthHint = 120;
		nrMieszkania.setLayoutData(gd);
		nrMieszkania.addModifyListener(modifyListener);
		label = new Label(container, SWT.NULL);

		dialogChanged();
		setControl(container);
		miasto.setFocus();
	}

	private void dialogChanged() {
		updateStatus(null);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}
	
	public String getMiasto() {
		return miasto.getText();
	}
	public String getUlica() {
		return ulica.getText();
	}
	public Integer getNrDomu() {
		return Integer.parseInt(nrDomu.getText());
	}
	public Integer getNrMieszkania() {
		return Integer.parseInt(nrMieszkania.getText());
	}

}