package wypozyczalnia.dao.plyty;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import wypozyczalnia.dao.KontoDAO;
import wypozyczalnia.dao.PlytaDAO;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public abstract class StanPlyty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;

	public abstract void zamow(PlytaDAO p, KontoDAO komu);

	public abstract void anuluj(PlytaDAO p);

	public abstract void wydaj(PlytaDAO p);

	public abstract void zwroc(PlytaDAO p);

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
