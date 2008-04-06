package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Osobatyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.OSOBATYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 12,12,12,12,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[5];
  static
  {
    _factory[4] = Listatelefonowtyp.getORADataFactory();
  }
  protected static final Osobatyp _OsobatypFactory = new Osobatyp();

  public static ORADataFactory getORADataFactory()
  { return _OsobatypFactory; }

  protected static java.util.Hashtable _map = new java.util.Hashtable();
  protected static boolean _initialized = false;
  protected static synchronized void init()
  { if (!_initialized)
    { _initialized=true;
      _map.put("PI.OSOBATYP",wypozyczalnia.oracle.Osobatyp.getORADataFactory());
      _map.put("PI.KLIENTTYP",wypozyczalnia.oracle.KlientTyp.getORADataFactory());
      _map.put("PI.PRACOWNIKTYP",wypozyczalnia.oracle.Osobatyp.getORADataFactory());
  } }

  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[5], _sqlType, _factory); }
  protected Osobatyp()
  { _init_struct(true); }
  protected Osobatyp(String imie, String nazwisko, String adresmailowy, String nazwiskorodowe, Listatelefonowtyp telefony) throws SQLException
  { _init_struct(true);
    setImie(imie);
    setNazwisko(nazwisko);
    setAdresmailowy(adresmailowy);
    setNazwiskorodowe(nazwiskorodowe);
    setTelefony(telefony);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(Osobatyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) return createFromFactory("Osobatyp", d, sqlType);
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createExact(Datum d, int sqlType) throws SQLException
  {
    Osobatyp o = new Osobatyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  protected ORAData createFromFactory(String s, Datum d, int sqlType) throws SQLException
  {
    String sql = ((STRUCT) d).getSQLTypeName();
    init();
    Osobatyp factory = (Osobatyp)_map.get(sql);
    if (factory == null) {
       int p;
       if ((p=sql.indexOf(".")) >= 0) {
          factory = (Osobatyp)_map.get(sql.substring(p+1));
          if (factory!=null) _map.put(sql,factory); }
       if (factory == null) throw new SQLException
          ("Unable to convert a "+sql+" to a "+s+" or a subclass of "+s);
    }
    return factory.createExact(d,sqlType);
  }

  /* accessor methods */
  public String getImie() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setImie(String imie) throws SQLException
  { _struct.setAttribute(0, imie); }


  public String getNazwisko() throws SQLException
  { return (String) _struct.getAttribute(1); }

  public void setNazwisko(String nazwisko) throws SQLException
  { _struct.setAttribute(1, nazwisko); }


  public String getAdresmailowy() throws SQLException
  { return (String) _struct.getAttribute(2); }

  public void setAdresmailowy(String adresmailowy) throws SQLException
  { _struct.setAttribute(2, adresmailowy); }


  public String getNazwiskorodowe() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setNazwiskorodowe(String nazwiskorodowe) throws SQLException
  { _struct.setAttribute(3, nazwiskorodowe); }


  public Listatelefonowtyp getTelefony() throws SQLException
  { return (Listatelefonowtyp) _struct.getAttribute(4); }

  public void setTelefony(Listatelefonowtyp telefony) throws SQLException
  { _struct.setAttribute(4, telefony); }

}
