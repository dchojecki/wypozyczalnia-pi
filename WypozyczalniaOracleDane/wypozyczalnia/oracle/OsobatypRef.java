package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class OsobatypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PI.OSOBATYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final OsobatypRef _OsobatypRefFactory = new OsobatypRef();

  public static ORADataFactory getORADataFactory()
  { return _OsobatypRefFactory; }
  /* constructor */
  public OsobatypRef()
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
    OsobatypRef r = new OsobatypRef();
    r._ref = (REF) d;
    return r;
  }

  public static OsobatypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (OsobatypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to OsobatypRef: "+exn.toString()); }
  }

  public Osobatyp getValue() throws SQLException
  {
     return (Osobatyp) Osobatyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Osobatyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
