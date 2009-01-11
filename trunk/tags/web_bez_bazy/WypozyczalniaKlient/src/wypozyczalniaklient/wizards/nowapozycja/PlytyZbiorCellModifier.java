package wypozyczalniaklient.wizards.nowapozycja;

import org.eclipse.jface.viewers.ICellModifier;

import zarzadzanieplytami.PlytaTO;

public class PlytyZbiorCellModifier implements ICellModifier {

	public PlytyZbiorCellModifier() {
	}
	@Override
	public boolean canModify(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValue(Object arg0, String arg1) {
		Object result= null;
		if (arg0 instanceof PlytaTO) {
			PlytaTO p = (PlytaTO) arg0;
		
        String stringValue = p.getStan().toString();
        String[] choices = PlytyZbiorCP.getChoices(arg1);
        int i = choices.length - 1;
        while (!stringValue.equals(choices[i]) && i > 0)
            --i;
        result = new Integer(i);
		}
		return result;
	}

	@Override
	public void modify(Object arg0, String arg1, Object arg2) {
		System.out.println("mody");
	}

}
