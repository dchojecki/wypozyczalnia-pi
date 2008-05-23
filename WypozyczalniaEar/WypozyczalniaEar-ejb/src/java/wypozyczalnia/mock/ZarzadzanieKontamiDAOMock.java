/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.mock;

import wypozyczalnia.dao.fabryki.zarzadzaniekontami.*;

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
