/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.Barrio_Convenio;

/**
 *
 * @author Sarita
 */
public class Barrio_ConvenioControlador {

    private Barrio_Convenio barrio_convenio;

    ConexionRegistro conexion = new ConexionRegistro();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;

    public Barrio_ConvenioControlador() {
    }

    public Barrio_ConvenioControlador(Barrio_Convenio barrio_convenio) {
        this.barrio_convenio = barrio_convenio;
    }

    public Barrio_Convenio getBarrio_convenio() {
        return barrio_convenio;
    }

    public void setBarrio_convenio(Barrio_Convenio barrio_convenio) {
        this.barrio_convenio = barrio_convenio;
    }

    public void crearBarrio_Convenio(Barrio_Convenio b) {
//TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "INSERT INTO barrio_convenio (nombre_bc,tipo_bc) VALUES ('" + b.getNombre_bc() + "','" + b.getTipo_bc() + "')";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            //EJECUTAR LA CONSULTA
            int resul = sesion.executeUpdate();
            if (resul > 0) {
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "REGISTRADO CON EXITO");
                sesion.close();
            }

        } catch (SQLException e) {
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTRAR");
        }

    }
    public void actualizarBarrio_Convenio(Barrio_Convenio b,int id_bc){
         //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "UPDATE barrio_convenio SET nombre_bc = ?, tipo_bc = ? WHERE  id_bc = ? ";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            sesion.setString(1, b.getNombre_bc());
            sesion.setString(2, b.getTipo_bc());
            sesion.setInt(3, b.getId_bc());
            //EJECUTAR LA CONSULTA
            int resul = sesion.executeUpdate();
            if (resul > 0) {
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "BARRIO CONVENIO ACTUALIZADO CON EXITO");
                sesion.close();
            }

        } catch (SQLException e) {
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ACTUALIZAR");
        }
    }
    public void eliminarBarrio_Convenio (int id_bc){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM barrio_convenio WHERE  id_bc = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            sesion.setInt(1, id_bc);
            int resul = sesion.executeUpdate();
            if (resul > 0){
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ELIMINADO CON EXITO");
                sesion.close();
            }
            
        } catch (SQLException e){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUEDE ELIMANAR- EN USO");
        }
    } 
    public int obtenerBC(String  nombreBarrioConvenio) throws SQLException{
        String consulta = "select * from barrio_convenio where nombre_bc = '" + nombreBarrioConvenio + "'";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int id_of = 0;
            try{
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = sesion.executeQuery();
            if (resul.next()){
                id_of = resul.getInt(1);
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "CONSULTA EXITOSA");
                sesion.close();
            }
            }catch (SQLException e){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
            return id_of;
    }
    public int brRepetir(String nombreC) {

        String consulta = "select * from barrio_convenio where nombre_bc = '" + nombreC + "'";
        //INICIAR SESIÓN A NIVEL DE MYSQL
        int i = 0;
        try {
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);

            ResultSet resul = sesion.executeQuery();
            if (resul.next()){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NOMBRE YA EXISTE");
                sesion.close();
                i = 1;
            } else {
                i = 2;
            }
        } catch (SQLException e) {
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
        return i;
    }

}