package wypozyczalniaklient.editors;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import zarzadzanieplytami.PlytaTO;

public class DanePlytyInput implements IEditorInput {

	private PlytaTO plyta;
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

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setKonto(PlytaTO p) {
		this.plyta = p;
	}

	public PlytaTO getKonto() {
		return plyta;
	}

}
