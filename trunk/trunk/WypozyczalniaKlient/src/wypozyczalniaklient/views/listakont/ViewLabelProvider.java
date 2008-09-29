/**
 * 
 */
package wypozyczalniaklient.views.listakont;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import wypozyczalnia.to.zarzadzaniekontami.KontoTO;

class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private final ListaKont listaUzytkownikow;

	/**
	 * @param listaUzytkownikow
	 */
	ViewLabelProvider(ListaKont listaUzytkownikow) {
		this.listaUzytkownikow = listaUzytkownikow;
	}

	public Image getColumnImage(Object obj, int arg1) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof KontoTO)
			imageKey = ISharedImages.IMG_TOOL_FORWARD;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

	@Override
	public String getColumnText(Object obj, int index) {
		KontoTO konto = (KontoTO) obj;
		if (konto != null) {
			if (index == 0)
				return konto.getNrKonta() + " / " + konto.getNrPeselKlienta();
			if (index == 1)
				return konto.getStanKonta().toString();
		}
		return null;
	}
}