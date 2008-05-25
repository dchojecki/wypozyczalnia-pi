/*
 * UtworzKonto.java
 *
 * Created on 29 kwiecień 2008, 03:42
 */

package wypozyczalniaForma;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author  Luke
 */
public class UtworzKonto extends javax.swing.JFrame {
    private boolean[] valid;
    /** Creates new form UtworzKonto */
    public UtworzKonto() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //getContentPane().add(emptyLabel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tytulLabel = new javax.swing.JLabel();
        imieLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        peselLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        nazwiskoLabel = new javax.swing.JLabel();
        nazwiskoText = new javax.swing.JTextField();
        imieText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        peselText = new javax.swing.JTextField();
        dataUrodzenia = new com.imagine.component.calendar.CalendarComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        wyslij = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(wypozyczalniaForma.WypozyczalniaForma.class).getContext().getResourceMap(UtworzKonto.class);
        tytulLabel.setText(resourceMap.getString("tytulLabel.text")); // NOI18N
        tytulLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tytulLabel.setName("tytulLabel"); // NOI18N

        imieLabel.setText(resourceMap.getString("imieLabel.text")); // NOI18N
        imieLabel.setName("imieLabel"); // NOI18N

        dataLabel.setText(resourceMap.getString("dataLabel.text")); // NOI18N
        dataLabel.setName("dataLabel"); // NOI18N

        peselLabel.setText(resourceMap.getString("peselLabel.text")); // NOI18N
        peselLabel.setName("peselLabel"); // NOI18N

        emailLabel.setText(resourceMap.getString("emailLabel.text")); // NOI18N
        emailLabel.setName("emailLabel"); // NOI18N

        nazwiskoLabel.setText(resourceMap.getString("nazwiskoLabel.text")); // NOI18N
        nazwiskoLabel.setName("nazwiskoLabel"); // NOI18N

        nazwiskoText.setName("nazwiskoText"); // NOI18N
        nazwiskoText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nazwiskoTextKeyReleased(evt);
            }
        });

        imieText.setName("imieText"); // NOI18N
        imieText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imieTextActionPerformed(evt);
            }
        });
        imieText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imieTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                imieTextKeyReleased(evt);
            }
        });

        emailText.setName("emailText"); // NOI18N
        emailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTextKeyReleased(evt);
            }
        });

        peselText.setName("peselText"); // NOI18N
        peselText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                peselTextKeyReleased(evt);
            }
        });

        dataUrodzenia.setName("dataUrodzenia"); // NOI18N

        jLabel8.setName("jLabel8"); // NOI18N

        jLabel7.setName("jLabel7"); // NOI18N

        jLabel11.setName("jLabel11"); // NOI18N

        jLabel10.setName("jLabel10"); // NOI18N

        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(wypozyczalniaForma.WypozyczalniaForma.class).getContext().getActionMap(UtworzKonto.class, this);
        wyslij.setAction(actionMap.get("createAccount")); // NOI18N
        wyslij.setText(resourceMap.getString("wyslij.text")); // NOI18N
        wyslij.setName("wyslij"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tytulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(wyslij)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imieLabel)
                            .addComponent(dataLabel)
                            .addComponent(peselLabel)
                            .addComponent(emailLabel)
                            .addComponent(nazwiskoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nazwiskoText, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(imieText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(emailText, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(peselText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(dataUrodzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tytulLabel)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imieLabel)
                            .addComponent(imieText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nazwiskoLabel)
                            .addComponent(nazwiskoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataLabel)
                            .addComponent(dataUrodzenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(peselLabel)
                            .addComponent(peselText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wyslij, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nazwiskoTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nazwiskoTextKeyReleased
        Pattern p = Pattern.compile("[A-Ża-ż-]*");
        String imie = nazwiskoText.getText();
        Matcher m = p.matcher(imie);
        if(!m.matches() && imie.length()>2) {
            jLabel8.setText("Błąd w nazwisku");
            valid[1] = false;
        } else
            jLabel8.setText("");
        valid[1] = true;
}//GEN-LAST:event_nazwiskoTextKeyReleased

    private void imieTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imieTextActionPerformed
        
}//GEN-LAST:event_imieTextActionPerformed

    private void imieTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imieTextKeyPressed
        
}//GEN-LAST:event_imieTextKeyPressed

    private void imieTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imieTextKeyReleased
        Pattern p = Pattern.compile("[A-Ż]+[a-ż]*");
        String imie = imieText.getText();
        Matcher m = p.matcher(imie);
        if(!m.matches() && imie.length()>2) {
            jLabel7.setText("Błąd w imieniu");
            valid[0] = false;
        } else
            jLabel7.setText("");
        valid[0] = true;
}//GEN-LAST:event_imieTextKeyReleased

    private void emailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextKeyReleased
        Pattern p = Pattern.compile("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        String mail = emailText.getText();
        Matcher m = p.matcher(mail);
        //valid[3] = false;
        if(!m.matches()) {
            jLabel11.setText("Błędny adres e-mail");
            valid[3] = false;
        } else
            jLabel11.setText("");
        valid[3] = true;
}//GEN-LAST:event_emailTextKeyReleased

    private void peselTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_peselTextKeyReleased
        Pattern p = Pattern.compile("[0-9]{11}");
        String pesel = peselText.getText();
        Matcher m = p.matcher(pesel);
        
        if(m.matches()==false) {
            jLabel10.setText("Błąd w numerze PESEL");
            valid[2] = false;
        } else {
            char[] peselNr  = pesel.toCharArray();
            int suma = 0;
            int[] mlt = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
            for (int i = 0; i < 10; i++) {
                suma+=(peselNr[i]-48)*mlt[i];
            }
            suma %= 10;
            suma = 10-suma;
            if (suma == peselNr[10]-48) {
                jLabel10.setText("");
                valid[2] = true;
            }
        }
}//GEN-LAST:event_peselTextKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UtworzKonto().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataLabel;
    private com.imagine.component.calendar.CalendarComboBox dataUrodzenia;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel nazwiskoLabel;
    private javax.swing.JTextField nazwiskoText;
    private javax.swing.JLabel peselLabel;
    private javax.swing.JTextField peselText;
    private javax.swing.JLabel tytulLabel;
    private javax.swing.JButton wyslij;
    // End of variables declaration//GEN-END:variables
    
}
