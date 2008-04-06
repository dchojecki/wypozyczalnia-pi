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

public class Listazamowientyp implements ORAData, ORADataFactory
{
  public static final String _SQL_NAME = "PI.LISTAZAMOWIENTYP";
  public static final int _SQL_TYPECODE = OracleTypes.ARRAY;

  MutableArray _array;

private static final Listazamowientyp _ListazamowientypFactory = new Listazamowientyp();

  public static ORADataFactory getORADataFactory()
  { return _ListazamowientypFactory; }
  /* constructors */
  public Listazamowientyp()
  {
    this((Zamowienietyp[])null);
  }

  public Listazamowientyp(Zamowienietyp[] a)
  {
    _array = new MutableArray(2002, a, Zamowienietyp.getORADataFactory());
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
    Listazamowientyp a = new Listazamowientyp();
    a._array = new MutableArray(2002, (ARRAY) d, Zamowienietyp.getORADataFactory());
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
  public Zamowienietyp[] getArray() throws SQLException
  {
    return (Zamowienietyp[]) _array.getObjectArray(
      new Zamowienietyp[_array.length()]);
  }

  public Zamowienietyp[] getArray(long index, int count) throws SQLException
  {
    return (Zamowienietyp[]) _array.getObjectArray(index,
      new Zamowienietyp[_array.sliceLength(index, count)]);
  }

  public void setArray(Zamowienietyp[] a) throws SQLException
  {
    _array.setObjectArray(a);
  }

  public void setArray(Zamowienietyp[] a, long index) throws SQLException
  {
    _array.setObjectArray(a, index);
  }

  public Zamowienietyp getElement(long index) throws SQLException
  {
    return (Zamowienietyp) _array.getObjectElement(index);
  }

  public void setElement(Zamowienietyp a, long index) throws SQLException
  {
    _array.setObjectElement(a, index);
  }

}
