package wypozyczalniaForma;


import java.util.Collection;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;

/**
 *
 * @author marcin
 */
public class ModelDrzewa implements TableModel{

    private ZamowienieTO[] zamowienia;
    public ModelDrzewa() {        
    }

    void setZamowienia(Collection<ZamowienieTO> zamowienia) {
        this.zamowienia = zamowienia.toArray(new ZamowienieTO[zamowienia.size()]);
    }
    
    
    public int getRowCount() {
        if (zamowienia == null) return 0;
        return zamowienia.length;
    }

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int arg0) {
        
        // TODO
        if (arg0 == 0)
        return "kolumnaName";
        else
            return "kolumnaName1";
    }

    public Class<?> getColumnClass(int arg0) {
        return String.class;        
    }

    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    public Object getValueAt(int arg0, int arg1) {        
        if (arg1 == 0)
            return zamowienia[arg0].getKlient().getImie();
        
           if (arg1 == 1)
            return zamowienia[arg0].getKlient().getNazwisko();        
        return "dummy";
    }

    public void setValueAt(Object arg0, int arg1, int arg2) {        
    }

    public void addTableModelListener(TableModelListener arg0) {        
    }

    public void removeTableModelListener(TableModelListener arg0) {
        
    }

}
