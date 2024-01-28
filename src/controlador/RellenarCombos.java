/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Sarita
 */
public class RellenarCombos {
    
    public void RellenarComboBox(String tabla, String valor, JComboBox combo) throws SQLException{
        String Consulta = "SELECT * FROM" + tabla;
        Statement st;
        ConexionRegistro con = new ConexionRegistro();
        Connection ConexionRegistro = (Connection) con.conectar();
        try{
            st = (Statement) ConexionRegistro.createStatement();
            ResultSet resul = st.executeQuery(Consulta);
            while(resul.next()){
                combo.addItem(resul.getString(valor));
              }  
            }catch (SQLException e) {
            Component rootPane = null;
                JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        }
    }
    

