/**
 * 
 */
package wypozyczalniaklient.views.plyty.listafilmow;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import zarzadzanieplytami.FilmTO;
import zarzadzanieplytami.FilmTOZbior;

public class ViewContentProvider implements IStructuredContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {

		if (parent instanceof FilmTOZbior) {
			FilmTOZbior filmy = (FilmTOZbior) parent;
			FilmTO filmyTab[] = new FilmTO[filmy.zwrocWszystkieFilmy().size()];

			return filmyTab = filmy.zwrocWszystkieFilmy().toArray(filmyTab);
		}
		return null;
	}
}