/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author marcin
 */
@Local
public interface DerbyPUBeanLocal {

    EntityManager getEntityManager();
    
}
