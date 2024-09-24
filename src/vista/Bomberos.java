/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.ctrlBomberos;
import modelo.mdlBomberos;

/**
 *
 * @author Rene Garcia
 */
public class Bomberos extends javax.swing.JFrame {

    /**
     * Creates new form Bomberos
     */
    public Bomberos() {
        initComponents();
    }

     public static void initBomberos() {
         mdlBomberos modelo = new mdlBomberos();
        Bomberos vista = new Bomberos();
       
         ctrlBomberos controlador = new ctrlBomberos(modelo, vista);
        vista.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtEdadBombero = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        txtPesoBombero = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        txtNombreBombero = new javax.swing.JTextField();
        lblfecha = new javax.swing.JLabel();
        lblMotivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBomberos = new javax.swing.JTable();
        txtCorreoBombero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 30, 30));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEdadBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEdadBomberoActionPerformed(evt);
            }
        });
        jPanel1.add(txtEdadBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 334, 40));

        lblDescripcion.setText("Peso");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 37));
        jPanel1.add(txtPesoBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 330, 30));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 294, 28));
        jPanel1.add(txtNombreBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 334, 30));

        lblfecha.setText("Nombre");
        jPanel1.add(lblfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        lblMotivo.setText("Edad");
        jPanel1.add(lblMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        tbBomberos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbBomberos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 730, 280));

        txtCorreoBombero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoBomberoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoBombero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 330, 30));

        jLabel1.setText("Correo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        btnBuscar.setText("Buscar");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoBomberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoBomberoActionPerformed

    private void txtEdadBomberoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEdadBomberoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadBomberoActionPerformed

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
            java.util.logging.Logger.getLogger(Bomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bomberos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initBomberos();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDescripcion;
    public javax.swing.JLabel lblMotivo;
    public javax.swing.JLabel lblfecha;
    public javax.swing.JTable tbBomberos;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCorreoBombero;
    public javax.swing.JTextField txtEdadBombero;
    public javax.swing.JTextField txtNombreBombero;
    public javax.swing.JTextField txtPesoBombero;
    // End of variables declaration//GEN-END:variables
}
