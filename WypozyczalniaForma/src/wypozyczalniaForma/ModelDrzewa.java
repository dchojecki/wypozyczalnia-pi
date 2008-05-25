package wypozyczalniaForma;


import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
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
        return 5;
    }

    public String getColumnName(int arg0) {
        String name = "";
        switch(arg0){
            case 0:
                name = "Imię";
                break;
            case 1:
                name = "Nazwisko";
                break;
            case 2:
                name = "Nr PESEL";
                break;
            case 3:
                name = "Data zamówienia";
                break;
            case 4:
                name = "Stan zamówienia";
                break;
                      
        }
        return name;

    }

    public Class<?> getColumnClass(int arg0) {
        return String.class;        
    }

    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    public Object getValueAt(int arg0, int arg1) {        
        
        switch(arg1){
            case 0:
                return zamowienia[arg0].getKlient().getImie();
            case 1:
                return zamowienia[arg0].getKlient().getNazwisko();
            case 2:
                return zamowienia[arg0].getKlient().getNrPeselKlienta();
            case 3:
                Date data = new Date();
                data = zamowienia[arg0].getDataPrzyjecia();
                DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
                return  df.format(data);
            case 4:
                return zamowienia[arg0].getStanzamowienia().toString();
            case 5:
                return zamowienia[arg0].getId();
        }
        return "dummy";

    }

    public void setValueAt(Object arg0, int arg1, int arg2) {        
    }

    public void addTableModelListener(TableModelListener arg0) {        
    }

    public void removeTableModelListener(TableModelListener arg0) {
        
    }

}
