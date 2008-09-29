package wypozyczalniaklient.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import wypozyczalnia.to.zarzadzaniekontami.KontoPracownikaTO;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiWyjatek;

public class LoginDialog extends Dialog {

	private Font font2 = new Font(null, "Arial", 13, SWT.BOLD);

	public LoginDialog(Shell parent) {
		super(parent);
	}

	protected Point getInitialSize() {
		return new Point(300, 187);
	}

	protected void okPressed() {
		ZarzadzanieKontamiDelegacja konta = ZarzadzanieKontamiDelegacja
				.getInstance();

		konta.wyloguj(loginText.getText());

		try {
			KontoPracownikaTO konto = konta.loguj(loginText.getText(), passText
					.getText());
			if (konto.getStan() == KontoPracownikaTO.Stan.aktywne)
				super.okPressed();			
		} catch (ZarzadzanieKontamiWyjatek e) {
			showMessage(e.getMessage());
		}
	}

	private void showMessage(String message) {
		MessageDialog.openError(getShell(), "Logowanie", message);
	}

	public static Image getImage(String s) {
		return PlatformUI.getWorkbench().getDisplay().getSystemImage(
				SWT.ICON_QUESTION);
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);

		Label message = new Label(container, SWT.CENTER);
		message.setText("Podaj login i has³o");
		message.setFont(font2);
		GridData gd;
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.verticalIndent = 20;
		message.setLayoutData(gd);

		Label sep1 = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.verticalIndent = 20;
		sep1.setLayoutData(gd);

		loginLab = new Label(container, SWT.LEFT);
		gd = new GridData();
		gd.widthHint = 100;
		loginLab.setLayoutData(gd);
		loginLab.setText("Login:");

		loginText = new Text(container, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		loginText.setLayoutData(gd);

		passLab = new Label(container, SWT.LEFT);
		gd = new GridData();
		gd.widthHint = 100;
		passLab.setLayoutData(gd);
		passLab.setText("Has³o:");

		passText = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		passText.setLayoutData(gd);

		Label sep2 = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		sep2.setLayoutData(gd);
		return container;
	}

	public String getLogin() {
		return loginText.getText();
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Okno logowania");
	}

	private Label loginLab, passLab;
	private Text loginText, passText;

	@Override
	protected Button createButton(Composite parent, int id, String label,
			boolean defaultButton) {
		if (label.equals("OK"))
			label = "Loguj";
		return super.createButton(parent, id, label, defaultButton);
	}

	@Override
	protected void cancelPressed() {
		// TODO Auto-generated method stub
		super.cancelPressed();
	}
}
