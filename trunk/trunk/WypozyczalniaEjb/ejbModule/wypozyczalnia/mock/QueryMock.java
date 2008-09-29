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

import wypozyczalnia.dao.FilmDAO;
import wypozyczalnia.dao.KlientDAO;
import wypozyczalnia.dao.PlytaDAO;
import wypozyczalnia.dao.ZamowienieDAO;
import wypozyczalnia.dao.kontopracownika.KontoPracownikaDAO;

/**
 * 
 * @author marcin
 */
public class QueryMock implements Query {

	private String query;
	private EntityManagerMock mock;
	private Date startDate;
	private Date endDate;
	private String nrPesel;
	private Integer filmId;
	private Integer plytaId;
	private String login;

	public QueryMock(EntityManagerMock mock, String query) {
		this.query = query;
		this.mock = mock;

	}

	@SuppressWarnings("unchecked")
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
		if ("zwrocWszystkichKlientow".equals(query)) {
			LinkedList<KlientDAO> zamowienia = new LinkedList<KlientDAO>();
			Collection<Object> all = mock.getStorage();

			try {
				for (Object o : all) {
					if (o instanceof KlientDAO) {
						zamowienia.add((KlientDAO) o);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mock.getTransactionMock().comitDone();
			return zamowienia;
		}

		if ("pobierzDaneKlienta".equals(query)) {
			LinkedList<KlientDAO> zamowienia = new LinkedList<KlientDAO>();
			Collection<Object> all = mock.getStorage();

			try {
				for (Object o : all) {
					if (o instanceof KlientDAO) {
						KlientDAO k = (KlientDAO) o;
						if (nrPesel.equals(k.getNrpesel())) {
							zamowienia.add(k);
						}
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
						if (z.getDataPrzyjecia().before(startDate))
							continue;
						if (z.getDataPrzyjecia().after(endDate))
							continue;
						zamowienia.add(z);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			mock.getTransactionMock().comitDone();
			return zamowienia;
		}
		if ("zwrocListeWszystkichFilmow".equals(query)) {
			LinkedList<FilmDAO> filmy = new LinkedList<FilmDAO>();
			Collection<Object> all = mock.getStorage();

			try {
				for (Object o : all) {
					if (o instanceof FilmDAO) {
						FilmDAO z = (FilmDAO) o;
						filmy.add(z);
					}
				}
				return filmy;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("zwrocListePlyt".equals(query)) {
			LinkedList<PlytaDAO> filmy = new LinkedList<PlytaDAO>();
			Collection<Object> all = mock.getStorage();

			try {
				for (Object o : all) {
					if (o instanceof PlytaDAO) {
						PlytaDAO z = (PlytaDAO) o;
						if (z.getFilm().getId().equals(filmId))
							filmy.add(z);
					}
				}
				return filmy;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		throw new UnsupportedOperationException("Not supported yet.");
	}

	public Object getSingleResult() {
		if ("zwrocPlyte".equals(query)) {
			PlytaDAO plyta  = null;
			Collection<Object> all = mock.getStorage();
			
			try {
				for (Object o : all) {
					if (o instanceof PlytaDAO) {
						PlytaDAO z = (PlytaDAO) o;
						if (z.getId().equals(plytaId))
							plyta = z;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			mock.getTransactionMock().comitDone();
			return plyta;
		}
		
		if ("pobierzDaneKontaPracownika".equals(query)) {
			KontoPracownikaDAO konto = null;
			Collection<Object> all = mock.getStorage();
			
			try {
				for (Object o : all) {
					if (o instanceof KontoPracownikaDAO) {
						KontoPracownikaDAO z = (KontoPracownikaDAO) o;
						if (z.getLogin().equals(login))
							konto = z;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			mock.getTransactionMock().comitDone();
			return konto;
		}
		return null;
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
		if (query.equals("pobierzDaneKlienta") && "pesel".equals(arg0)) {
			nrPesel = (String) arg1;
		} else if (query.equals("znajdzWszystkieZamowieniaOdDo")
				&& "od".equals(arg0)) {
			startDate = (Date) arg1;
		} else if (query.equals("znajdzWszystkieZamowieniaOdDo")
				&& "do".equals(arg0)) {
			endDate = (Date) arg1;
		} else
		if (query.equals("pobierzDaneKontaPracownika") && "login".equals(arg0)) {
			login = (String) arg1;
		} else
		if (query.equals("zwrocListePlyt") && "id".equals(arg0)) {
			filmId = (Integer) arg1;
		} else if (query.equals("zwrocPlyte") && "id".equals(arg0)) {
			plytaId = (Integer) arg1;
		} else if (query.equals("pobierzDaneKlienta") && "pesel".equals(arg0)) {
			nrPesel = (String) arg1;
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
		if (query.equals("pobierzDaneKontaPracownika") && arg0 == 0) {
			login = (String) arg1;
		} else
		if (query.equals("zwrocListePlyt") && arg0 == 0) {
			filmId = (Integer) arg1;
		} else if (query.equals("zwrocPlyte") && arg0 == 0) {
			plytaId = (Integer) arg1;
		} else if (query.equals("pobierzDaneKlienta") && arg0 == 0) {
			nrPesel = (String) arg1;
		} else if (query.equals("znajdzWszystkieZamowieniaOdDo") && arg0 == 0) {
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
