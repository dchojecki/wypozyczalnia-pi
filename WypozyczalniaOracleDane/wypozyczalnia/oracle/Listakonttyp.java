package wypozyczalnia.oracle;

import java.sql.SQLException;
import java.sql.Connection;
import oracle.jdbc.OracleTypes;
import oracle.sql.ORAData;
import oracle.sql.ORADataFactory;
import oracle.sql.Datum;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.jpub.runtime.MutableArray;

public class Listakonttyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.LISTAKONTTYP";
  public static final int _SQL_TYPECODE = OracleTypes.ARRAY;

  MutableArray _array;

private static final Listakonttyp _ListakonttypFactory = new Listakonttyp();

  public static ORADataFactory getORADataFactory()
  { return _ListakonttypFactory; }
  /* constructors */
  public Listakonttyp()
  {
    this((Kontotyp[])null);
  }

  public Listakonttyp(Kontotyp[] a)
  {
    _array = new MutableArray(2002, a, Kontotyp.getORADataFactory());
  }

  /* ORAData interface */
  public Datum toDatum(Connection c) throws SQLException
  {
    return _array.toDatum(c, _SQL_NAME);
  }

  /* ORADataFactory interface */
  public ORAData create(Datum d, int sqlType) throws SQLException
  {
    if (d == null) return null; 
    Listakonttyp a = new Listakonttyp();
    a._array = new MutableArray(2002, (ARRAY) d, Kontotyp.getORADataFactory());
    return a;
  }

  public int length() throws SQLException
  {
    return _array.length();
  }

  public int getBaseType() throws SQLException
  {
    return _array.getBaseType();
  }

  public String getBaseTypeName() throws SQLException
  {
    return _array.getBaseTypeName();
  }

  public ArrayDescriptor getDescriptor() throws SQLException
  {
    return _array.getDescriptor();
  }

  /* array accessor methods */
  public Kontotyp[] getArray() throws SQLException
  {
    return (Kontotyp[]) _array.getObjectArray(
      new Kontotyp[_array.length()]);
  }

  public Kontotyp[] getArray(long index, int count) throws SQLException
  {
    return (Kontotyp[]) _array.getObjectArray(index,
      new Kontotyp[_array.sliceLength(index, count)]);
  }

  public void setArray(Kontotyp[] a) throws SQLException
  {
    _array.setObjectArray(a);
  }

  public void setArray(Kontotyp[] a, long index) throws SQLException
  {
    _array.setObjectArray(a, index);
  }

  public Kontotyp getElement(long index) throws SQLException
  {
    return (Kontotyp) _array.getObjectElement(index);
  }

  public void setElement(Kontotyp a, long index) throws SQLException
  {
    _array.setObjectElement(a, index);
  }

}
