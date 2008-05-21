/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author marcin
 */
@Remote
public interface DerbyPUBeanRemote {

    EntityManager getEntityManager();
    
}
