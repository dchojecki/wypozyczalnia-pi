/**
 * 
 */
package wypozyczalniaklient.views.plyty.listaplyt;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import zarzadzanieplytami.PlytaTO;
import zarzadzanieplytami.PlytaTOZbior;

public class ViewContentProvider implements IStructuredContentProvider {
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {

		if (parent instanceof PlytaTOZbior) {
			PlytaTOZbior filmy = (PlytaTOZbior) parent;

			PlytaTO filmyTab[] = new PlytaTO[filmy.zwrocWszystkiePlyty().size()];

			return filmyTab = filmy.zwrocWszystkiePlyty().toArray(filmyTab);
		}
		return null;
	}
}