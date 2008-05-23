/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.mock;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import wypozyczalnia.dao.ZamowienieDAO;

/**
 *
 * @author marcin
 */
public class EntityManagerMock implements EntityManager {

    private List<Object> persisted = new LinkedList<Object>();
    private EntityTransactionMock entityTransaction = new EntityTransactionMock();
    private boolean open;
    private Integer lastZamowienieId = 0;

    public EntityManagerMock() {
        open = true;
    }

    public void persist(Object arg0) {
        if (persisted.contains(arg0)) {
            persisted.remove(arg0);
        }

        if (arg0 instanceof ZamowienieDAO) {
            ZamowienieDAO z = (ZamowienieDAO) arg0;
            if (z.getId() == null) {
                z.setId(lastZamowienieId++);
            }
        }
        persisted.add(arg0);
    }

    public <T> T merge(T arg0) {
        persist(arg0);
        return arg0;
    }

    public void remove(Object arg0) {
        persisted.remove(arg0);
    }

    public <T> T find(Class<T> arg0, Object arg1) {
        if (arg0 == null || arg1 == null) {
            throw new IllegalArgumentException();
        }

        if (arg0.equals(ZamowienieDAO.class)) {
            if (!arg1.getClass().equals(Integer.class)) {
                throw new IllegalArgumentException();
            }
            Integer id = (Integer) arg1;
            for (Object o : persisted) {
                if (o instanceof ZamowienieDAO) {
                    ZamowienieDAO z = (ZamowienieDAO) o;
                    if (z.getId().equals(id)) {
                        return (T) z;
                    }
                }
            }
        }
        return null;
    }

    public <T> T getReference(Class<T> arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void flush() {
    }

    public void setFlushMode(FlushModeType arg0) {
    }

    public FlushModeType getFlushMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lock(Object arg0, LockModeType arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void refresh(Object arg0) {
    }

    public void clear() {
        persisted.clear();
        getTransactionMock().clear();
    }

    public void reset() {
        getTransactionMock().clear();
    }

    public boolean contains(Object arg0) {
        return persisted.contains(arg0);
    }

    public Query createQuery(String arg0) {
        return new QueryMock(this, arg0);
    }

    public Query createNamedQuery(String arg0) {
        return new QueryMock(this, arg0);
    }

    public Query createNativeQuery(String arg0) {
        return new QueryMock(this, arg0);
    }

    public Query createNativeQuery(String arg0, Class arg1) {
        return new QueryMock(this, arg0);
    }

    public Query createNativeQuery(String arg0, String arg1) {
        return new QueryMock(this, arg0);
    }

    public void joinTransaction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getDelegate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void close() {
        open = false;
    }

    public boolean isOpen() {
        return open;
    }

    public EntityTransaction getTransaction() {
        return entityTransaction;
    }

    public EntityTransactionMock getTransactionMock() {
        return entityTransaction;
    }

    public Collection<Object> getStorage() {
        return persisted;
    }
}
