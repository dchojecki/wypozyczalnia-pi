package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.STRUCT;
import oracle.jpub.runtime.MutableStruct;

public class Zamowienietyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.ZAMOWIENIETYP";
  public static final int _SQL_TYPECODE = OracleTypes.STRUCT;

  protected MutableStruct _struct;

  protected static int[] _sqlType =  { 93 };
  protected static ORADataFactory[] _factory = new ORADataFactory[1];
  protected static final Zamowienietyp _ZamowienietypFactory = new Zamowienietyp();

  public static ORADataFactory getORADataFactory()
  { return _ZamowienietypFactory; }
  /* constructors */
  protected void _init_struct(boolean init)
  { if (init) _struct = new MutableStruct(new Object[1], _sqlType, _factory); }
  public Zamowienietyp()
  { _init_struct(true); }
  public Zamowienietyp(java.sql.Timestamp datazlozenia) throws SQLException
  { _init_struct(true);
    setDatazlozenia(datazlozenia);
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _struct.toDatum(c, _SQL_NAME);
  }


  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  { return create(null, d, sqlType); }
  protected ORAData create(Zamowienietyp o, Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    if (o == null) o = new Zamowienietyp();
    o._struct = new MutableStruct((STRUCT) d, _sqlType, _factory);
    return o;
  }
  /* accessor methods */
  public java.sql.Timestamp getDatazlozenia() throws SQLException
  { return (java.sql.Timestamp) _struct.getAttribute(0); }

  public void setDatazlozenia(java.sql.Timestamp datazlozenia) throws SQLException
  { _struct.setAttribute(0, datazlozenia); }

}
