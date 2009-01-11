/**
 * 
 */
package wypozyczalniaklient.views.listawypozyczen;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import wypozyczalnia.to.zarzadzaniewypozyczeniami.PozycjaZamowieniaTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTOZbior;

class ViewContentProvider implements IStructuredContentProvider,
		ITreeContentProvider {
	/**
	 * 
	 */
	private ZamowienieTOZbior current;

	/**
	 * @param listaWypozyczen
	 */
	ViewContentProvider() {
	}

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		return current;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof ZamowienieTOZbior) {

			current = (ZamowienieTOZbior) parent;

			ZamowienieTOZbior zbior = ((ZamowienieTOZbior) parent);
			ZamowienieTO[] ret = new ZamowienieTO[zbior
					.zwrocWszystkieZamowienia().size()];
			return zbior.zwrocWszystkieZamowienia().toArray(ret);
		}
		if (parent instanceof ZamowienieTO) {

			ZamowienieTO z = (ZamowienieTO) parent;
			PozycjaZamowieniaTO[] ret = new PozycjaZamowieniaTO[z
					.getPozycjezamowienia().size()];
			return z.getPozycjezamowienia().toArray(ret);
		}
		return new Object[0];
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof ZamowienieTOZbior)
			return ((ZamowienieTOZbior) parent).zwrocWszystkieZamowienia()
					.size() > 0;
		if (parent instanceof ZamowienieTO)
			return ((ZamowienieTO) parent).getPozycjezamowienia().size() > 0;
		return false;
	}
}