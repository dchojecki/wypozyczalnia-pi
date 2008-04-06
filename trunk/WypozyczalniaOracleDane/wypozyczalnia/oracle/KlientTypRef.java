package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.REF;
import oracle.sql.STRUCT;

public class KlientTypRef implements ORAData, ORADataFactory
{
  public static final String _SQL_BASETYPE = "PI.KLIENTTYP";
  public static final int _SQL_TYPECODE = OracleTypes.REF;

  REF _ref;

private static final KlientTypRef _KlientTypRefFactory = new KlientTypRef();

  public static ORADataFactory getORADataFactory()
  { return _KlientTypRefFactory; }
  /* constructor */
  public KlientTypRef()
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
    KlientTypRef r = new KlientTypRef();
    r._ref = (REF) d;
    return r;
  }

  public static KlientTypRef cast(ORAData o) throws SQLException
  {
     if (o == null) return null;
     try { return (KlientTypRef) getORADataFactory().create(o.toDatum(null), OracleTypes.REF); }
     catch (Exception exn)
     { throw new SQLException("Unable to convert "+o.getClass().getName()+" to KlientTypRef: "+exn.toString()); }
  }

  public KlientTyp getValue() throws SQLException
  {
     return (KlientTyp) KlientTyp.getORADataFactory().create(
       _ref.getSTRUCT(), OracleTypes.REF);
  }

  public void setValue(KlientTyp c) throws SQLException
  {
    _ref.setValue((STRUCT) c.toDatum(_ref.getJavaSqlConnection()));
  }
}
