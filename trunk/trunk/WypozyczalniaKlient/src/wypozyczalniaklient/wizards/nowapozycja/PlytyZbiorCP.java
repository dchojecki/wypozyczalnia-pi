package wypozyczalniaklient.wizards.nowapozycja;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

public class PlytyZbiorCP implements IStructuredContentProvider {
	public static String[] getChoices(String property) {
			return new String[]{"aasfd", "bb", "WDRODZE"};
	}
	@Override
	public Object[] getElements(Object arg0) {
		
		if (arg0 instanceof PlytaTOZbior) {
			PlytaTOZbior zbior = (PlytaTOZbior) arg0;
			int childCount = zbior.zwrocWszystkiePlyty().size();
			
			PlytaTO tab []= new PlytaTO[childCount];
			tab = zbior.zwrocWszystkiePlyty().toArray(tab);
			return tab;
		}
		return null;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

}
