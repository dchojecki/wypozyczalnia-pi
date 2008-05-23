/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.mock;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.FlushModeType;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import wypozyczalnia.dao.ZamowienieDAO;

/**
 *
 * @author marcin
 */
public class QueryMock implements Query {

    private String query;
    private EntityManagerMock mock;
    private Date startDate;
    private Date endDate;

    public QueryMock(EntityManagerMock mock, String query) {
        this.query = query;
        this.mock = mock;

    }

    public List getResultList() {

        if ("znajdzWszystkieZamowienia".equals(query)) {
            LinkedList<ZamowienieDAO> zamowienia = new LinkedList<ZamowienieDAO>();
            Collection<Object> all = mock.getStorage();

            try {
                for (Object o : all) {
                    if (o instanceof ZamowienieDAO) {
                        zamowienia.add((ZamowienieDAO) o);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mock.getTransactionMock().comitDone();
            return zamowienia;
        }

        if ("znajdzWszystkieZamowieniaOdDo".equals(query)) {
            LinkedList<ZamowienieDAO> zamowienia = new LinkedList<ZamowienieDAO>();
            Collection<Object> all = mock.getStorage();

            try {
                for (Object o : all) {
                    if (o instanceof ZamowienieDAO) {
                        ZamowienieDAO z = (ZamowienieDAO) o;
                        if (z.getDataPrzyjecia().before(startDate)) continue;
                        if (z.getDataPrzyjecia().after(endDate)) continue;
                        zamowienia.add(z);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            mock.getTransactionMock().comitDone();
            return zamowienia;
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Object getSingleResult() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int executeUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setMaxResults(int arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setFirstResult(int arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setHint(String arg0, Object arg1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setParameter(String arg0, Object arg1) {
        if (query.equals("znajdzWszystkieZamowieniaOdDo") && "od".equals(arg0)) {
            startDate = (Date) arg1;
        } else if (query.equals("znajdzWszystkieZamowieniaOdDo") && "do".equals(arg0)) {
            endDate = (Date) arg1;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return this;
    }

    public Query setParameter(String arg0, Date arg1, TemporalType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setParameter(String arg0, Calendar arg1, TemporalType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setParameter(int arg0, Object arg1) {

        if (query.equals("znajdzWszystkieZamowieniaOdDo") && arg0 == 0) {
            startDate = (Date) arg1;
        } else if (query.equals("znajdzWszystkieZamowieniaOdDo") && arg0 == 1) {
            endDate = (Date) arg1;
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        return this;
    }

    public Query setParameter(int arg0, Date arg1, TemporalType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setParameter(int arg0, Calendar arg1, TemporalType arg2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Query setFlushMode(FlushModeType arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
