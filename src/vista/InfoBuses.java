/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author sport
 */
public class InfoBuses extends javax.swing.JFrame {

    /**
     * Creates new form InfoBuses
     */
    public InfoBuses() {
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

        jButtonAnadirBus = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonTablaBus = new javax.swing.JButton();
        jComboBoxBuscarBusID = new javax.swing.JComboBox<>();
        jButtonBuscarInfoBusParaModificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextBuscarPlacaBus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextNumBus = new javax.swing.JTextField();
        jTextPlaca = new javax.swing.JTextField();
        jComboBoxModeloBus = new javax.swing.JComboBox<>();
        jComboBoxEliminarBus = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxModeloBuscarBus = new javax.swing.JComboBox<>();
        jButtonHelpBus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfoBuses = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonIDsModificarBus = new javax.swing.JButton();
        jButtonModificarBus = new javax.swing.JButton();
        jButtonVerIDsEliminarBus = new javax.swing.JButton();
        jButtonEliminarBus = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButtonVolverBus = new javax.swing.JButton();
        jButtonNumeroAleatorio = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAnadirBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonAnadirBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAnadirBus.setText("A??adir");
        getContentPane().add(jButtonAnadirBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Modificar informaci??n del bus:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 24, -1, -1));

        jButtonTablaBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonTablaBus.setText("Actualizar tabla");
        getContentPane().add(jButtonTablaBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 150, 30));

        jComboBoxBuscarBusID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxBuscarBusID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de bus" }));
        jComboBoxBuscarBusID.setEnabled(false);
        getContentPane().add(jComboBoxBuscarBusID, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 120, -1));

        jButtonBuscarInfoBusParaModificar.setBackground(new java.awt.Color(204, 204, 255));
        jButtonBuscarInfoBusParaModificar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBuscarInfoBusParaModificar.setText("Buscar");
        jButtonBuscarInfoBusParaModificar.setEnabled(false);
        getContentPane().add(jButtonBuscarInfoBusParaModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 70, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("A??adir bus:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 24, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("N??mero del bus:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Placa de bus:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo del bus:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 30));

        jTextBuscarPlacaBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextBuscarPlacaBus.setEnabled(false);
        getContentPane().add(jTextBuscarPlacaBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 98, 100, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Placa de bus:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 95, 90, -1));

        jTextNumBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        getContentPane().add(jTextNumBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 58, 50, -1));

        jTextPlaca.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        getContentPane().add(jTextPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 91, 100, -1));

        jComboBoxModeloBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxModeloBus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Mitsubishi", "Marcopolo", "Busscar", "Volskwagen", "Coopetran" }));
        getContentPane().add(jComboBoxModeloBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 127, 100, -1));

        jComboBoxEliminarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxEliminarBus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numero de bus" }));
        jComboBoxEliminarBus.setEnabled(false);
        getContentPane().add(jComboBoxEliminarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 129, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo del bus:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 130, 100, -1));

        jComboBoxModeloBuscarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxModeloBuscarBus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Toyota", "Chevrolet", "Mitsubishi", "Marcopolo", "Busscar", "Volskwagen", "Coopetran" }));
        jComboBoxModeloBuscarBus.setEnabled(false);
        getContentPane().add(jComboBoxModeloBuscarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 90, -1));

        jButtonHelpBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonHelpBus.setText("Ayuda");
        getContentPane().add(jButtonHelpBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, 30));

        jTableInfoBuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Placa del bus", "Modelo del bus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableInfoBuses);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 760, 94));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar por Numero de bus:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        jButtonIDsModificarBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonIDsModificarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonIDsModificarBus.setText("Ver IDs");
        getContentPane().add(jButtonIDsModificarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 87, -1));

        jButtonModificarBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonModificarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonModificarBus.setText("Modificar informaci??n");
        jButtonModificarBus.setEnabled(false);
        getContentPane().add(jButtonModificarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jButtonVerIDsEliminarBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVerIDsEliminarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonVerIDsEliminarBus.setText("Ver IDs");
        getContentPane().add(jButtonVerIDsEliminarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, -1, -1));

        jButtonEliminarBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonEliminarBus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonEliminarBus.setText("Eliminar");
        jButtonEliminarBus.setEnabled(false);
        getContentPane().add(jButtonEliminarBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Eliminar bus:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, -1, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Buscar por N??mero de bus");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 170, -1));

        jButtonVolverBus.setBackground(new java.awt.Color(204, 204, 255));
        jButtonVolverBus.setText("Volver");
        getContentPane().add(jButtonVolverBus, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 105, 30));

        jButtonNumeroAleatorio.setText("R");
        jButtonNumeroAleatorio.setToolTipText("N??mero de bus aleatorio.");
        getContentPane().add(jButtonNumeroAleatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, 20));

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3e11d0b4-01f7-4495-b1fc-1eea5bfc8a14.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(InfoBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoBuses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoBuses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAnadirBus;
    public javax.swing.JButton jButtonBuscarInfoBusParaModificar;
    public javax.swing.JButton jButtonEliminarBus;
    public javax.swing.JButton jButtonHelpBus;
    public javax.swing.JButton jButtonIDsModificarBus;
    public javax.swing.JButton jButtonModificarBus;
    public javax.swing.JButton jButtonNumeroAleatorio;
    public javax.swing.JButton jButtonTablaBus;
    public javax.swing.JButton jButtonVerIDsEliminarBus;
    public javax.swing.JButton jButtonVolverBus;
    public javax.swing.JComboBox<String> jComboBoxBuscarBusID;
    public javax.swing.JComboBox<String> jComboBoxEliminarBus;
    public javax.swing.JComboBox<String> jComboBoxModeloBus;
    public javax.swing.JComboBox<String> jComboBoxModeloBuscarBus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableInfoBuses;
    public javax.swing.JTextField jTextBuscarPlacaBus;
    public javax.swing.JTextField jTextNumBus;
    public javax.swing.JTextField jTextPlaca;
    // End of variables declaration//GEN-END:variables
}
