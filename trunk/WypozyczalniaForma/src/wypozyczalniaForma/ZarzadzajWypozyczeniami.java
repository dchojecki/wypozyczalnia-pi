/*
 * ZarzadzajWypozyczeniami.java
 *
 * Created on 11 maj 2008, 17:22
 */

package wypozyczalniaForma;

import java.util.Collection;
import java.util.LinkedList;
import javax.naming.Context;
import javax.naming.InitialContext;
import wypozyczalnia.dao.StanZamowienia;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniami;
import wypozyczalnia.ejb.zarzadzaniewypozyczeniami.ZarzadzanieWypozyczeniamiDummy;
import wypozyczalnia.to.zarzadzaniewypozyczeniami.ZamowienieTO;


/**
 *
 * @author  Luke
 */
public class ZarzadzajWypozyczeniami extends javax.swing.JFrame {
    public ZarzadzanieWypozyczeniami zarzadzanie ;
    public ModelDrzewa model;
    /** Creates new form ZarzadzajWypozyczeniami */
    public ZarzadzajWypozyczeniami() {
            super("Zarządzaj Wypożyczeniami");

        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        zarzadzanie = new ZarzadzanieWypozyczeniamiDummy();
        zarzadzanie.initialize();
        model = (ModelDrzewa) jTable1.getModel();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_stan = new javax.swing.ButtonGroup();
        buttonGroup_zmiana = new javax.swing.ButtonGroup();
        calendarComboBox1 = new com.imagine.component.calendar.CalendarComboBox();
        calendarComboBox2 = new com.imagine.component.calendar.CalendarComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        errorLabel = new javax.swing.JLabel();
        przyjeteRadioButton = new javax.swing.JRadioButton();
        zrealizowaneRadioButton = new javax.swing.JRadioButton();
        doOdbioruRadioButton = new javax.swing.JRadioButton();
        pozyczoneRadioButton = new javax.swing.JRadioButton();
        wszystkieRadioButton = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        przyjeteZmianaRadioButton = new javax.swing.JRadioButton();
        zrealizowaneZmianaRadioButton = new javax.swing.JRadioButton();
        doOdbioruZmianaRadioButton = new javax.swing.JRadioButton();
        pozyczoneZmianaRadioButton = new javax.swing.JRadioButton();
        anulowaneZmianaRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        calendarComboBox1.setName("calendar_od"); // NOI18N
        calendarComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calendarComboBox1MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                calendarComboBox1MouseReleased(evt);
            }
        });
        calendarComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarComboBox1PropertyChange(evt);
            }
        });

        calendarComboBox2.setName("calendar_do"); // NOI18N
        calendarComboBox2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarComboBox2PropertyChange(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(wypozyczalniaForma.WypozyczalniaForma.class).getContext().getResourceMap(ZarzadzajWypozyczeniami.class);
        jLabel1.setText(resourceMap.getString("jLabel_od.text")); // NOI18N
        jLabel1.setName("jLabel_od"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel_do.text")); // NOI18N
        jLabel2.setName("jLabel_do"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel_info.text")); // NOI18N
        jLabel3.setName("jLabel_info"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new wypozyczalniaForma.ModelDrzewa());
        jTable1.setCellSelectionEnabled(false);
        jTable1.setName("jTable1"); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        errorLabel.setName("jLabel_error"); // NOI18N

        buttonGroup_stan.add(przyjeteRadioButton);
        przyjeteRadioButton.setText(resourceMap.getString("jRadioButton_przyjete.text")); // NOI18N
        przyjeteRadioButton.setName("jRadioButton_przyjete"); // NOI18N

        buttonGroup_stan.add(zrealizowaneRadioButton);
        zrealizowaneRadioButton.setText(resourceMap.getString("jRadioButton_zrealizowane.text")); // NOI18N
        zrealizowaneRadioButton.setName("jRadioButton_zrealizowane"); // NOI18N

        buttonGroup_stan.add(doOdbioruRadioButton);
        doOdbioruRadioButton.setText(resourceMap.getString("jRadioButton_doOdbioru.text")); // NOI18N
        doOdbioruRadioButton.setName("jRadioButton_doOdbioru"); // NOI18N

        buttonGroup_stan.add(pozyczoneRadioButton);
        pozyczoneRadioButton.setText(resourceMap.getString("jRadioButton_pozyczone.text")); // NOI18N
        pozyczoneRadioButton.setName("jRadioButton_pozyczone"); // NOI18N

        buttonGroup_stan.add(wszystkieRadioButton);
        wszystkieRadioButton.setSelected(true);
        wszystkieRadioButton.setText(resourceMap.getString("jRadioButton_wszystkie.text")); // NOI18N
        wszystkieRadioButton.setName("jRadioButton_wszystkie"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton_wyszukaj.text")); // NOI18N
        jButton1.setName("jButton_wyszukaj"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("zmienStanButton.text")); // NOI18N
        jButton2.setName("zmienStanButton"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup_zmiana.add(przyjeteZmianaRadioButton);
        przyjeteZmianaRadioButton.setText(resourceMap.getString("przyjeteZmianaRadioButton.text")); // NOI18N
        przyjeteZmianaRadioButton.setName("przyjeteZmianaRadioButton"); // NOI18N

        buttonGroup_zmiana.add(zrealizowaneZmianaRadioButton);
        zrealizowaneZmianaRadioButton.setText(resourceMap.getString("zrealizowaneZmianaRadioButton.text")); // NOI18N
        zrealizowaneZmianaRadioButton.setName("zrealizowaneZmianaRadioButton"); // NOI18N

        buttonGroup_zmiana.add(doOdbioruZmianaRadioButton);
        doOdbioruZmianaRadioButton.setText(resourceMap.getString("doOdbioruZmianaRadioButton.text")); // NOI18N
        doOdbioruZmianaRadioButton.setName("doOdbioruZmianaRadioButton"); // NOI18N

        buttonGroup_zmiana.add(pozyczoneZmianaRadioButton);
        pozyczoneZmianaRadioButton.setText(resourceMap.getString("pozyczoneZmianaRadioButton.text")); // NOI18N
        pozyczoneZmianaRadioButton.setName("pozyczoneZmianaRadioButton"); // NOI18N

        buttonGroup_zmiana.add(anulowaneZmianaRadioButton);
        anulowaneZmianaRadioButton.setText(resourceMap.getString("anulowaneZmianaRadioButton.text")); // NOI18N
        anulowaneZmianaRadioButton.setName("anulowaneZmianaRadioButton"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(calendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(przyjeteRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(zrealizowaneRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(doOdbioruRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(pozyczoneRadioButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(wszystkieRadioButton)
                                                .addGap(246, 246, 246))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(calendarComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(69, 69, 69)
                                                .addComponent(jButton1)
                                                .addGap(89, 89, 89)))
                                        .addGap(33, 33, 33))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(anulowaneZmianaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(przyjeteZmianaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(zrealizowaneZmianaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(doOdbioruZmianaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(pozyczoneZmianaRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(przyjeteRadioButton)
                    .addComponent(zrealizowaneRadioButton)
                    .addComponent(doOdbioruRadioButton)
                    .addComponent(pozyczoneRadioButton)
                    .addComponent(wszystkieRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(pozyczoneZmianaRadioButton)
                    .addComponent(doOdbioruZmianaRadioButton)
                    .addComponent(zrealizowaneZmianaRadioButton)
                    .addComponent(przyjeteZmianaRadioButton)
                    .addComponent(anulowaneZmianaRadioButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {

                    if(calendarComboBox1.getDate().after(calendarComboBox2.getDate())){
            errorLabel.setText("Zakres dat jest nieprawidłowy");
            
            }
            else { 
                errorLabel.setText("");
                Collection<ZamowienieTO> zam = new LinkedList<ZamowienieTO>();
                if (wszystkieRadioButton.isSelected()) zam = zarzadzanie.pobierzZamowieniaWgCzasu(calendarComboBox1.getDate(), calendarComboBox2.getDate());
                if (przyjeteRadioButton.isSelected()) zam = zarzadzanie.pobierzZamowieniaWgStanu(calendarComboBox1.getDate(), calendarComboBox2.getDate(), "PRZYJETE");
                if (zrealizowaneRadioButton.isSelected()) zam = zarzadzanie.pobierzZamowieniaWgStanu(calendarComboBox1.getDate(), calendarComboBox2.getDate(), "ZREALIZOWANE");
                if (doOdbioruRadioButton.isSelected()) zam = zarzadzanie.pobierzZamowieniaWgStanu(calendarComboBox1.getDate(), calendarComboBox2.getDate(), "DOODIORU");
                if (pozyczoneRadioButton.isSelected()) zam = zarzadzanie.pobierzZamowieniaWgStanu(calendarComboBox1.getDate(), calendarComboBox2.getDate(), "POZYCZONE");
                model.setZamowienia(zam);
                jTable1.updateUI();      
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void calendarComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarComboBox1PropertyChange
        if(calendarComboBox1.getDate().after(calendarComboBox2.getDate())){
            errorLabel.setText("Zakres dat jest nieprawidłowy");
        }
        else 
            errorLabel.setText("");
    }//GEN-LAST:event_calendarComboBox1PropertyChange

    private void calendarComboBox2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarComboBox2PropertyChange
        if(calendarComboBox1.getDate().after(calendarComboBox2.getDate())){
            errorLabel.setText("Zakres dat jest nieprawidłowy");
        }
        else 
            errorLabel.setText("");
    }//GEN-LAST:event_calendarComboBox2PropertyChange

    private void calendarComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarComboBox1MouseExited
        if(calendarComboBox1.getDate().after(calendarComboBox2.getDate())){
            errorLabel.setText("Zakres dat jest nieprawidłowy");
        }
        else 
            errorLabel.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_calendarComboBox1MouseExited

    private void calendarComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarComboBox1MouseReleased
        if(calendarComboBox1.getDate().after(calendarComboBox2.getDate())){
            errorLabel.setText("Zakres dat jest nieprawidłowy");
        }
        else 
            errorLabel.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_calendarComboBox1MouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String stan = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        pozyczoneZmianaRadioButton.setEnabled(false);
        zrealizowaneZmianaRadioButton.setEnabled(false);
        doOdbioruZmianaRadioButton.setEnabled(false);
        przyjeteZmianaRadioButton.setEnabled(false);
        anulowaneZmianaRadioButton.setEnabled(false);
        pozyczoneZmianaRadioButton.setSelected(false);
        zrealizowaneZmianaRadioButton.setSelected(false);
        doOdbioruZmianaRadioButton.setSelected(false);
        przyjeteZmianaRadioButton.setSelected(false);
        anulowaneZmianaRadioButton.setSelected(false);
        if(stan.compareTo("PRZYJETE")==0){
            doOdbioruZmianaRadioButton.setEnabled(true);
            anulowaneZmianaRadioButton.setEnabled(true);
        }
        if(stan.compareTo("DOODBIORU")==0){
            pozyczoneZmianaRadioButton.setEnabled(true);
            anulowaneZmianaRadioButton.setEnabled(true);
        }        
        if(stan.compareTo("POZYCZONE")==0){
            zrealizowaneZmianaRadioButton.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int nr = Integer.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
        
        if (zrealizowaneZmianaRadioButton.isSelected()) zarzadzanie.setStan(nr, StanZamowienia.ZREALIZOWANE);
        if (pozyczoneZmianaRadioButton.isSelected()) zarzadzanie.setStan(nr, StanZamowienia.POZYCZONE);
        if (przyjeteZmianaRadioButton.isSelected()) zarzadzanie.setStan(nr, StanZamowienia.PRZYJETE);
        if (doOdbioruZmianaRadioButton.isSelected()) zarzadzanie.setStan(nr, StanZamowienia.DOODIORU);
        if (anulowaneZmianaRadioButton.isSelected()) zarzadzanie.setStan(nr, StanZamowienia.ANULOWANE);
        //model.setZamowienia(zamowienia);
        String stan = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        pozyczoneZmianaRadioButton.setEnabled(false);
        zrealizowaneZmianaRadioButton.setEnabled(false);
        doOdbioruZmianaRadioButton.setEnabled(false);
        przyjeteZmianaRadioButton.setEnabled(false);
        anulowaneZmianaRadioButton.setEnabled(false);
        pozyczoneZmianaRadioButton.setSelected(false);
        zrealizowaneZmianaRadioButton.setSelected(false);
        doOdbioruZmianaRadioButton.setSelected(false);
        przyjeteZmianaRadioButton.setSelected(false);
        anulowaneZmianaRadioButton.setSelected(false);
        if(stan.compareTo("PRZYJETE")==0){
            doOdbioruZmianaRadioButton.setEnabled(true);
            anulowaneZmianaRadioButton.setEnabled(true);
        }
        if(stan.compareTo("DOODIORU")==0){
            pozyczoneZmianaRadioButton.setEnabled(true);
            anulowaneZmianaRadioButton.setEnabled(true);
        }        
        if(stan.compareTo("POZYCZONE")==0){
            zrealizowaneZmianaRadioButton.setEnabled(true);
        }
        jTable1.updateUI();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZarzadzajWypozyczeniami().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton anulowaneZmianaRadioButton;
    private javax.swing.ButtonGroup buttonGroup_stan;
    private javax.swing.ButtonGroup buttonGroup_zmiana;
    private com.imagine.component.calendar.CalendarComboBox calendarComboBox1;
    private com.imagine.component.calendar.CalendarComboBox calendarComboBox2;
    private javax.swing.JRadioButton doOdbioruRadioButton;
    private javax.swing.JRadioButton doOdbioruZmianaRadioButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton pozyczoneRadioButton;
    private javax.swing.JRadioButton pozyczoneZmianaRadioButton;
    private javax.swing.JRadioButton przyjeteRadioButton;
    private javax.swing.JRadioButton przyjeteZmianaRadioButton;
    private javax.swing.JRadioButton wszystkieRadioButton;
    private javax.swing.JRadioButton zrealizowaneRadioButton;
    private javax.swing.JRadioButton zrealizowaneZmianaRadioButton;
    // End of variables declaration//GEN-END:variables
    
}