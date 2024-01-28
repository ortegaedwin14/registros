/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import controlador.ConexionRegistro;
import controlador.Registro_OficioControlador;
import controlador.RellenarCombos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orteg
 */
public class Consultar extends javax.swing.JFrame {

    public static int id_of;
    Registro_OficioControlador ec = new Registro_OficioControlador();

    RellenarCombos rc = new RellenarCombos();
    private String query;
    
    public Consultar() {
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
   

    public void mostrarTabla(String cedula) {
        String Consulta;
        if (txt_cedula.getText().isBlank()) {
            Consulta = "SELECT r.cedula_res, r.nombres_res, r.apellidos_res, r.tipo_res, o.solicitud, o.fecha_recepcion, o.fecha_entrega, b.nombre_bc, a.nombre_aso, o.pdf, o.aprobado " +
                  "FROM registro_oficio o " +
                  "INNER JOIN responsable r ON r.cedula_res = o.fkres_cedula " +
                  "INNER JOIN barrio_convenio b ON b.id_bc = r.fkbc_id_bc " +
                  "INNER JOIN asosiaciones a ON a.id_aso = o.fkaso_id_aso";
        } else {
            Consulta = "SELECT r.cedula_res, r.nombres_res, r.apellidos_res, r.tipo_res, o.solicitud, o.fecha_recepcion, o.fecha_entrega, b.nombre_bc, a.nombre_aso, o.pdf, o.aprobado " +
                  "FROM registro_oficio o " +
                  "INNER JOIN responsable r ON r.cedula_res = o.fkres_cedula " +
                  "INNER JOIN barrio_convenio b ON b.id_bc = r.fkbc_id_bc " +
                  "INNER JOIN asosiaciones a ON a.id_aso = o.fkaso_id_aso "+
                  "WHERE fkres_cedula LIKE '" + cedula + "%'";
        }

        Statement st;
        ConexionRegistro con = new ConexionRegistro();
        Connection ConexionRegistro = (Connection) con.conectar();

        // metodo para evitar que editen la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        // añadir columnas
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("TIPO");
        modelo.addColumn("SOLICITUD");
        modelo.addColumn("RECEPCION");
        modelo.addColumn("ENTREGA");
        modelo.addColumn("BARRIO");
        modelo.addColumn("DEPARTAMENTO");
        modelo.addColumn("PDF");
         modelo.addColumn("APROBADO");

        Oficio1.setModel(modelo);

        // llenar datos obtenidos de la bdd (Consulta)
        String[] datos = new String[11];
        try {
            st = (Statement) ConexionRegistro.createStatement();
            ResultSet resul = st.executeQuery(Consulta);
            while (resul.next()) {
                datos[0] = resul.getString(1);
                datos[1] = resul.getString(2);
                datos[2] = resul.getString(3);
                datos[3] = resul.getString(4);
                datos[4] = resul.getString(5);
                datos[5] = resul.getString(6);
                datos[6] = resul.getString(7);
                datos[7] = resul.getString(8);
                datos[8] = resul.getString(9);
                datos[9] = resul.getString(10);
                datos[10] = resul.getString(11);
                

                modelo.addRow(datos);
            }
            resul.close();
            Oficio1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "error" + e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Oficio1 = new javax.swing.JTable();
        txt_cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Oficio1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Oficio1);

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyReleased(evt);
            }
        });

        jLabel2.setText("cedula:");

        jButton1.setText("<-- atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel6.setText("ACTUALIZAR");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setText("CONSULTAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(458, 458, 458)
                    .addComponent(jLabel6)
                    .addContainerGap(458, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(263, 263, 263)
                    .addComponent(jLabel6)
                    .addContainerGap(263, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        MenuPrincipalF m = new MenuPrincipalF();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyReleased
        mostrarTabla(txt_cedula.getText());
    }//GEN-LAST:event_txt_cedulaKeyReleased

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
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Oficio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_cedula;
    // End of variables declaration//GEN-END:variables
}
