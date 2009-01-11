/**
 * 
 */
package wypozyczalniaklient.views.listawypozyczen;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

class ViewLabelProvider extends LabelProvider {

	/**
	 * 
	 */
	ViewLabelProvider() {
	}
	public String getText(Object obj) {
		if (obj instanceof ZamowienieTO) {
			ZamowienieTO z = (ZamowienieTO) obj;
			String s = z.getId().toString() + " / " + z.getStanzamowienia().toString();
			return s;
		}
		if (obj instanceof PozycjaZamowieniaTO) {
			PozycjaZamowieniaTO z = (PozycjaZamowieniaTO) obj;
			String s = z.getPlyta().getTytul();
			return s;
		}
		return "temp";
	}
	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof TreeParent)
		   imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}
}