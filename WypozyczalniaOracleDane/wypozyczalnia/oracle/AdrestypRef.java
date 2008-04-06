package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class AdrestypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PI.ADRESTYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final AdrestypRef _AdrestypRefFactory = new AdrestypRef();

  public static ORADataFactory getORADataFactory()
  { return _AdrestypRefFactory; }
  /* constructor */
  public AdrestypRef()
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
    AdrestypRef r = new AdrestypRef();
    r._ref = (REF) d;
    return r;
  }

  public static AdrestypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (AdrestypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to AdrestypRef: "+exn.toString()); }
  }

  public Adrestyp getValue() throws SQLException
  {
     return (Adrestyp) Adrestyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(Adrestyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
