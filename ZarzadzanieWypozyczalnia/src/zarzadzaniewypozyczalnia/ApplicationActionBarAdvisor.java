package zarzadzaniewypozyczalnia;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private IWorkbenchAction wyjscieAkcja;
	private IWorkbenchAction oProgramieAkcja;
	private IWorkbenchWindow okno;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	okno = window;
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager menuPlik = new MenuManager("Plik", "Plik");
    	MenuManager menuPomoc = new MenuManager("Pomoc", "Pomoc");
    	wyjscieAkcja = ActionFactory.QUIT.create(okno);
    	oProgramieAkcja = ActionFactory.ABOUT.create(okno);
    	
    	
    	menuPlik.add(wyjscieAkcja);
    	menuPomoc.add(oProgramieAkcja);
    	
    	menuBar.add(menuPlik);
    	menuBar.add(menuPomoc);
    	
    }

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar);
//		toolbar.add(oProgramieAkcja);
		super.fillCoolBar(coolBar);
	}
    
}
