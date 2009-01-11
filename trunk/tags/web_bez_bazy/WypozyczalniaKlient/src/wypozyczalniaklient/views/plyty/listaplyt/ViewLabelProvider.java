/**
 * 
 */
package wypozyczalniaklient.views.plyty.listaplyt;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import zarzadzanieplytami.PlytaTO;

public class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	
	public String getColumnText(Object obj, int index) {
		PlytaTO plyta = (PlytaTO) obj;
		if (plyta != null) {
			if (index == 0)
			return ((Integer) plyta.getIdPlyty()).toString();
			if (index == 1)
				return plyta.getStan().toString();
		}
		return null;
	}
	public Image getColumnImage(Object obj, int index) {
		return getImage(obj);
	}
	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().
				getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
}