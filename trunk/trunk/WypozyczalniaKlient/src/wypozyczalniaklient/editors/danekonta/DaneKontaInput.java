package wypozyczalniaklient.editors.danekonta;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import wypozyczalnia.to.zarzadzaniekontami.KontoTO;

public class DaneKontaInput implements IEditorInput {

	private KontoTO konto;
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return "test";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return "aaa";
	}

	@Override
	public Object getAdapter(Class arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setKonto(KontoTO konto) {
		this.konto = konto;
	}

	public KontoTO getKonto() {
		return konto;
	}

}
