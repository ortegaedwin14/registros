/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.BarrioConvenio;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import controlador.Barrio_ConvenioControlador;
import controlador.ConexionRegistro;
import controlador.Registro_OficioControlador;
import controlador.RellenarCombos;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.MenuPrincipalF;

/**
 *
 * @author orteg
 */
public class BarrioConvenio_F extends javax.swing.JFrame {
    public static int id_bc;
    

    public BarrioConvenio_F() {
        initComponents();
        this.setLocationRelativeTo(null);
        mostrarTabla(null);
    }

    ConexionRegistro conexion = new ConexionRegistro();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;
    Statement stmt;
    // se crea una variable tipo arrayList de auto
   

    public void mostrarTabla(String nombre ) {
        String Consulta;
        if (txt_nombreBC.getText().isBlank()) {
            Consulta = "SELECT * FROM barrio_convenio";
        } else {
            Consulta = "SELECT * FROM barrio_convenio WHERE nombre_bc LIKE'%"+nombre+"%'";
        }

        Statement st;
        ConexionRegistro con = new ConexionRegistro();
        Connection ConexionRegistro = (Connection) con.conectar();

        // metodo para evitar que editen la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        // añadir columnas 

        modelo.addColumn("NOMBRE");
        modelo.addColumn("TIPO");
 

        Barrio.setModel(modelo);

        // llenar datos obtenidos de la bdd (Consulta)
        String[] datos = new String[3];
        try {
            st = (Statement) ConexionRegistro.createStatement();
            ResultSet resul = st.executeQuery(Consulta);
            while (resul.next()) {

                datos[0] = resul.getString(2);
                datos[1] = resul.getString(3);


                modelo.addRow(datos);
            }
            resul.close();
            Barrio.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "error" + e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Barrio = new javax.swing.JTable();
        txt_nombreBC = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_crear = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Barrio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Barrio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BarrioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Barrio);

        txt_nombreBC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nombreBCKeyReleased(evt);
            }
        });

        btn_eliminar.setText("eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("nombre: ");

        btn_crear.setText("crear");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_actualizar.setText("actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        jButton1.setText("<-- atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("ADMINISTRAR BARRIO/CONVENIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(674, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(39, 39, 39)
                                        .addComponent(txt_nombreBC, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_actualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_crear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(273, 273, 273))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_nombreBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BarrioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarrioMouseClicked


        String nombre = txt_nombreBC.getText();
        int indice = Barrio.getSelectedRow();
        String consulta = "SELECT * FROM registros.barrio_convenio  LIMIT " + indice + "," + 1;
        //INICIAR SESIÓN A NIV
        try {
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            ResultSet resul = sesion.executeQuery();
            while (resul.next()) {
                id_bc = resul.getInt(1);
            }
        } catch (SQLException e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO SE PUEDE ELIMINAR");
        }


    }//GEN-LAST:event_BarrioMouseClicked

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (id_bc == 0) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE UN BARRIO/CONVENIO");
            return;
        } 
        Barrio_ConvenioControlador bcc = new Barrio_ConvenioControlador();
        bcc.eliminarBarrio_Convenio(BarrioConvenio_F.id_bc);
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        BC_CrearF c = new BC_CrearF();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if (id_bc == 0) {
            JOptionPane.showMessageDialog(rootPane, "POR FAVOR SELECCIONE UN BARRIO/CONVENIO");
            return;
        }
        Actualizar_bcF a = new Actualizar_bcF();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipalF m = new MenuPrincipalF();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nombreBCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreBCKeyReleased
        mostrarTabla(txt_nombreBC.getText());
    }//GEN-LAST:event_txt_nombreBCKeyReleased

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
            java.util.logging.Logger.getLogger(BarrioConvenio_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarrioConvenio_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarrioConvenio_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarrioConvenio_F.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarrioConvenio_F().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Barrio;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_nombreBC;
    // End of variables declaration//GEN-END:variables
}
