package wypozyczalnia.to.zarzadzaniekontami;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class KontoTOZbior implements Serializable {

	private static final long serialVersionUID = -4109915538355416509L;
	private Collection<KontoTO> konta;

	public KontoTOZbior(Collection<KontoTO> konta) {
		super();
		this.konta = konta;
	}

	public Collection<KontoTO> getKonta() {
		return Collections.unmodifiableCollection(konta);
	}
	
	
}
