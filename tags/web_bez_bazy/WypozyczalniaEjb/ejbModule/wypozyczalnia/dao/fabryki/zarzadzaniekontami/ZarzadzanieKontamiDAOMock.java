/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.dao.fabryki.zarzadzaniekontami;

import wypozyczalnia.mock.EntityManagerMock;

/**
 *
 * @author marcin
 */
public class ZarzadzanieKontamiDAOMock extends ZarzadzanieKontamiOracleDAO{

    private EntityManagerMock emMock;
    
    public ZarzadzanieKontamiDAOMock() {
        super(new EntityManagerMock());
        emMock = (EntityManagerMock) getEm();
    }
    
    public void reset() {
        emMock.clear();
    }
}
