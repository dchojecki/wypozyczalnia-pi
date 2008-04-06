package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class KontotypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PI.KONTOTYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final KontotypRef _KontotypRefFactory = new KontotypRef();

  public static ORADataFactory getORADataFactory()
  { return _KontotypRefFactory; }
  /* constructor */
  public KontotypRef()
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
    KontotypRef r = new KontotypRef();
    r._ref = (REF) d;
    return r;
  }

  public static KontotypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (KontotypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to KontotypRef: "+exn.toString()); }
  }

  public Kontotyp getValue() throws SQLException
  {
     return (Kontotyp) Kontotyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Kontotyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
