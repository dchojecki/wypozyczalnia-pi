/**
 * 
 */
package wypozyczalniaklient.views.listakont;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import wypozyczalnia.to.zarzadzaniekontami.KontoTO;
import wypozyczalnia.to.zarzadzaniekontami.KontoTOZbior;

public class ListaUzytkownikowCP implements IStructuredContentProvider,
		ITreeContentProvider {
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private final ListaKont listaUzytkownikowWidok;

	/**
	 * @param listaUzytkownikowWidok
	 */
	public ListaUzytkownikowCP(ListaKont listaUzytkownikowWidok) {
		this.listaUzytkownikowWidok = listaUzytkownikowWidok;
	}

	private KontoTOZbior konta;

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	public Object[] getElements(Object parent) {
		return getChildren(parent);
	}

	public Object getParent(Object child) {
		return konta;
	}

	public Object[] getChildren(Object parent) {
		if (parent instanceof KontoTOZbior) {

			konta = (KontoTOZbior) parent;

			KontoTOZbior zbior = ((KontoTOZbior) parent);
			KontoTO[] ret = new KontoTO[zbior.getKonta().size()];
			return zbior.getKonta().toArray(ret);
		}
		return new Object[0];
	}

	public boolean hasChildren(Object parent) {
		if (parent instanceof KontoTOZbior)
			return ((KontoTOZbior) parent).getKonta().size() > 0;
		return false;
	}

}