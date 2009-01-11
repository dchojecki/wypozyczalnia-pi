/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.dao.fabryki.zarzadzaniewypozyczeniami;

import wypozyczalnia.mock.EntityManagerMock;

/**
 *
 * @author marcin
 */
public class ZarzWypOracleDAOMock extends ZarzWypOracleDAO {

    private EntityManagerMock em;

    public ZarzWypOracleDAOMock() {
        super(new EntityManagerMock());
        em = (EntityManagerMock) this.getEntityManager();

    }

    public void reset() {
        getEntityManagerMock().clear();
    }

    public EntityManagerMock getEntityManagerMock() {
        return em;
    }
}
