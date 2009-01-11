/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.mock;

import javax.persistence.EntityTransaction;

/**
 *
 * @author marcin
 */
public class EntityTransactionMock implements EntityTransaction {

    private boolean active;
    private boolean comitDone;
    private boolean rollbackDone;

    public EntityTransactionMock() {
        clear();
    }

    public void begin() {
        clear();
        active = true;
    }

    public void commit() {
        comitDone = true;
        active = false;
    }

    public void rollback() {
        rollbackDone = true;
        active = false;
    }

    public void setRollbackOnly() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean getRollbackOnly() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isActive() {
        return active;
    }

    public boolean isComitDone() {
        return comitDone;
    }

    public boolean isRollbackDone() {
        return rollbackDone;
    }
    public void activeDone() {
        active = false;
    }

    public void comitDone() {
        comitDone = true;
        rollbackDone = false;
    }

    public void rollbackDone() {
        rollbackDone = true;
        comitDone = false;
    }

    public void clear() {
        active = false;
        comitDone = false;
        rollbackDone = false;
    }
}
