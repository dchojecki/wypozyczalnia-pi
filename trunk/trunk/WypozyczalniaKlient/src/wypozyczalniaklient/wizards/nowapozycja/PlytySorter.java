package wypozyczalniaklient.wizards.nowapozycja;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import wypozyczalnia.dao.StanPlyty;
import zarzadzanieplytami.PlytaTO;

public class PlytySorter extends ViewerSorter {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (!(e1 instanceof PlytaTO))
			return 0;
		if (!(e2 instanceof PlytaTO))
			return 0;

		PlytaTO plyta1 = (PlytaTO) e1;
		PlytaTO plyta2 = (PlytaTO) e2;
		StanPlyty stan1 = plyta1.getStan();
		StanPlyty stan2 = plyta2.getStan();

		if (stan1 == stan2) {
			if (plyta1.getIdPlyty() > plyta2.getIdFilmu())
				return 1;
			else
				return -1;
		}
		
		

		if (stan1.ordinal() < stan2.ordinal())
			return 1;
		else
			return -1;
		/*
		 * * WYPOZYCZONA, /** NIEWYPOZYCZONA, ZAREZERWOWANA WDRODZE} }
		 */
	}
}