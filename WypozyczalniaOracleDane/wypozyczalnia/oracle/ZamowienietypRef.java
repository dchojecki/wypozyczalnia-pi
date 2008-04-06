package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class ZamowienietypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PI.ZAMOWIENIETYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final ZamowienietypRef _ZamowienietypRefFactory = new ZamowienietypRef();

  public static ORADataFactory getORADataFactory()
  { return _ZamowienietypRefFactory; }
  /* constructor */
  public ZamowienietypRef()
  {
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _ref;
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    ZamowienietypRef r = new ZamowienietypRef();
    r._ref = (REF) d;
    return r;
  }

  public static ZamowienietypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (ZamowienietypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to ZamowienietypRef: "+exn.toString()); }
  }

  public Zamowienietyp getValue() throws SQLException
  {
     return (Zamowienietyp) Zamowienietyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Zamowienietyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
