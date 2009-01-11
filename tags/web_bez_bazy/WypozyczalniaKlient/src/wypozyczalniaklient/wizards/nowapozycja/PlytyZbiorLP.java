package wypozyczalniaklient.wizards.nowapozycja;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import zarzadzanieplytami.PlytaTO;

public class PlytyZbiorLP extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object arg0, int arg1) {
		
		if (arg0 instanceof PlytaTO) {
			PlytaTO p = (PlytaTO) arg0;
			
			switch (arg1) {
			case 0:
				return p.getStan().toString();
			case 1:
				return p.getUwagiDoEgzemplarza();
			default:
				return null;
			}
		}
return null;
	}

}
