package wypozyczalniaklient;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import wypozyczalniaklient.delegacje.konta.ZarzadzanieKontamiDelegacja;
import wypozyczalniaklient.dialogs.LoginDialog;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
			if (!login(display)) {
				//return IApplication.EXIT_OK;
			}

			int returnCode = PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else
				return IApplication.EXIT_OK;
		} finally {
			display.dispose();
		}

	}

	private boolean login(Display display) {

		ZarzadzanieKontamiDelegacja konta = ZarzadzanieKontamiDelegacja.getInstance();
		konta.dodajPracownika("marcin", "kowalski", "mkowalski_user", "1234", false);
		konta.dodajPracownika("marcin", "kowalski", "mkowalski_root", "1234", true);
		
		LoginDialog login = new LoginDialog(null);
		if (login.open() != Window.OK) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
