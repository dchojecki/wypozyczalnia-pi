/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wypozyczalnia.ejb.zarzadzaniewypozyczeniami;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcin
 */
@Stateless(mappedName="DerbyPUBeanBean")
public class DerbyPUBeanBean implements DerbyPUBeanRemote, DerbyPUBeanLocal {

    //@PersistenceContext(unitName="DerbyPU")
    private EntityManager em;
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
