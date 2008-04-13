package wypozyczalnia.ejb;

import javax.ejb.Stateless;

@Stateless(name="jeden1", mappedName="jeden1")
public class jedenImpl implements jeden{
	public String getValue(String arg)
	{
		return arg + "good";
	}
}
