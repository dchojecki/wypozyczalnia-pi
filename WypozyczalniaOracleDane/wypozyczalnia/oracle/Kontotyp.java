package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Kontotyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.KONTOTYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 12,4,93,12,93,2003 };
  protected static ORADataFactory[] _factory = new ORADataFactory[6];
  static
  {
    _factory[5] = Listazamowientyp.getORADataFactory();
  }
  protected static final Kontotyp _KontotypFactory = new Kontotyp();

  public static ORADataFactory getORADataFactory()
  { return _KontotypFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[6], _sqlType, _factory); }
  public Kontotyp()
  { _init_struct(true); }
  public Kontotyp(String stan, Integer wygaslohaslo, java.sql.Timestamp dataostatniegologowania, String skrothasla, java.sql.Timestamp dataostatniejzmianyhasla, Listazamowientyp zamowienia) throws SQLException
  { _init_struct(true);
    setStan(stan);
    setWygaslohaslo(wygaslohaslo);
    setDataostatniegologowania(dataostatniegologowania);
    setSkrothasla(skrothasla);
    setDataostatniejzmianyhasla(dataostatniejzmianyhasla);
    setZamowienia(zamowienia);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(Kontotyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Kontotyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public String getStan() throws SQLException
  { return (String) _struct.getAttribute(0); }

  public void setStan(String stan) throws SQLException
  { _struct.setAttribute(0, stan); }


  public Integer getWygaslohaslo() throws SQLException
  { return (Integer) _struct.getAttribute(1); }

  public void setWygaslohaslo(Integer wygaslohaslo) throws SQLException
  { _struct.setAttribute(1, wygaslohaslo); }


  public java.sql.Timestamp getDataostatniegologowania() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(2); }

  public void setDataostatniegologowania(java.sql.Timestamp dataostatniegologowania) throws SQLException
  { _struct.setAttribute(2, dataostatniegologowania); }


  public String getSkrothasla() throws SQLException
  { return (String) _struct.getAttribute(3); }

  public void setSkrothasla(String skrothasla) throws SQLException
  { _struct.setAttribute(3, skrothasla); }


  public java.sql.Timestamp getDataostatniejzmianyhasla() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(4); }

  public void setDataostatniejzmianyhasla(java.sql.Timestamp dataostatniejzmianyhasla) throws SQLException
  { _struct.setAttribute(4, dataostatniejzmianyhasla); }


  public Listazamowientyp getZamowienia() throws SQLException
  { return (Listazamowientyp) _struct.getAttribute(5); }

  public void setZamowienia(Listazamowientyp zamowienia) throws SQLException
  { _struct.setAttribute(5, zamowienia); }

}
