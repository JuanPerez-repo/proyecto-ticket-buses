/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JComboBox;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author sport
 */
public class ComprarTicketBus extends javax.swing.JFrame {

    /**
     * Creates new form ComprarTicketBus
     */
    public ComprarTicketBus() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboLugarOrigen = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboDestino = new javax.swing.JComboBox<>();
        jDateFechaIngresada = new com.toedter.calendar.JDateChooser();
        jButtonCTB_Viajes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jComboHoras = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboAsientos = new javax.swing.JComboBox<>();
        jTextID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextNombres = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextApellidos = new javax.swing.JTextField();
        jButtonCTB_ReservarTicket = new javax.swing.JButton();
        jButtonCTB_Volver = new javax.swing.JButton();
        jLabelFondoAzul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agendar ticket de bus:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lugar de partida:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jComboLugarOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Malambo", "Palmar de Varela", "Sabanalarga", "Puerto Colombia", "Salgar", "Suan", "Campo de la Cruz", "Repelon", "Baranoa", "Galapa" }));
        getContentPane().add(jComboLugarOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lugar de destino:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de partida:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jComboDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Malambo", "Palmar de Varela", "Sabanalarga", "Puerto Colombia", "Salgar", "Suan", "Campo de la Cruz", "Repelon", "Baranoa", "Galapa" }));
        getContentPane().add(jComboDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 170, -1));
        getContentPane().add(jDateFechaIngresada, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 170, -1));

        jButtonCTB_Viajes.setText("Buscar viajes");
        getContentPane().add(jButtonCTB_Viajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hora de partida:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        jComboHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Horas de partida encontradas" }));
        jComboHoras.setEnabled(false);
        getContentPane().add(jComboHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 170, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Seleccione su asiento:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Doc. Identidad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jComboAsientos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de asiento", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
        jComboAsientos.setEnabled(false);
        getContentPane().add(jComboAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 170, -1));
        getContentPane().add(jTextID, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 170, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombres:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));
        getContentPane().add(jTextNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 170, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Apellidos:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));
        getContentPane().add(jTextApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 170, -1));

        jButtonCTB_ReservarTicket.setText("Reservar ticket");
        jButtonCTB_ReservarTicket.setEnabled(false);
        getContentPane().add(jButtonCTB_ReservarTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jButtonCTB_Volver.setText("Volver");
        getContentPane().add(jButtonCTB_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        jLabelFondoAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3e11d0b4-01f7-4495-b1fc-1eea5bfc8a14.jpg"))); // NOI18N
        jLabelFondoAzul.setText("jLabel11");
        getContentPane().add(jLabelFondoAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ComprarTicketBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprarTicketBus().setVisible(true);
            }
        });
    }// le a??ad?? el Look and feel, pero no se si est?? bien...

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCTB_ReservarTicket;
    public javax.swing.JButton jButtonCTB_Viajes;
    public javax.swing.JButton jButtonCTB_Volver;
    public javax.swing.JComboBox<String> jComboAsientos;
    public javax.swing.JComboBox<String> jComboDestino;
    public javax.swing.JComboBox<String> jComboHoras;
    public javax.swing.JComboBox<String> jComboLugarOrigen;
    public com.toedter.calendar.JDateChooser jDateFechaIngresada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFondoAzul;
    public javax.swing.JTextField jTextApellidos;
    public javax.swing.JTextField jTextID;
    public javax.swing.JTextField jTextNombres;
    // End of variables declaration//GEN-END:variables

    public void jComboHoras(JComboBox seleccionarHorasRuta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
