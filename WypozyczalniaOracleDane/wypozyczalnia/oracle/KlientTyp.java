package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class KlientTyp extends Osobatyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.KLIENTTYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected static int[] _sqlType =  { 12,12,12,12,2003,12,2002,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[8];
  static
  {
    _factory[4] = Listatelefonowtyp.getORADataFactory();
    _factory[6] = Adrestyp.getORADataFactory();
    _factory[7] = Listakonttyp.getORADataFactory();
  }
  protected static final KlientTyp _KlientTypFactory = new KlientTyp();

  public static ORADataFactory getORADataFactory()
  { return _KlientTypFactory; }
  static
  { _map.put("PI.KLIENTTYP", _KlientTypFactory); }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[8], _sqlType, _factory); }
  public KlientTyp()
  { _init_struct(true); }
  public KlientTyp(String imie, String nazwisko, String adresmailowy, String nazwiskorodowe, Listatelefonowtyp telefony, String nrpesel, Adrestyp adres, Listakonttyp konta) throws SQLException
  { _init_struct(true);
    setImie(imie);
    setNazwisko(nazwisko);
    setAdresmailowy(adresmailowy);
    setNazwiskorodowe(nazwiskorodowe);
    setTelefony(telefony);
    setNrpesel(nrpesel);
    setAdres(adres);
    setKonta(konta);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(KlientTyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new KlientTyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }

  /* accessor methods */
  public String getNrpesel() throws SQLException
  { return (String) _struct.getAttribute(5); }

  public void setNrpesel(String nrpesel) throws SQLException
  { _struct.setAttribute(5, nrpesel); }


  public Adrestyp getAdres() throws SQLException
  { return (Adrestyp) _struct.getAttribute(6); }

  public void setAdres(Adrestyp adres) throws SQLException
  { _struct.setAttribute(6, adres); }


  public Listakonttyp getKonta() throws SQLException
  { return (Listakonttyp) _struct.getAttribute(7); }

  public void setKonta(Listakonttyp konta) throws SQLException
  { _struct.setAttribute(7, konta); }

}
