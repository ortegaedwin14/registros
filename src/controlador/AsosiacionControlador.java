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
import javax.swing.JOptionPane;
import modelo.Asosiacion;

/**
 *
 * @author orteg
 */
public class AsosiacionControlador {
    
    private Asosiacion asosiacion;
    
    ConexionRegistro  conexion = new ConexionRegistro();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;

    public AsosiacionControlador() {
    }

    public AsosiacionControlador(Asosiacion asosiacion) {
        this.asosiacion = asosiacion;
    }

    public Asosiacion getAsosiacion() {
        return asosiacion;
    }

    public void setAsosiacion(Asosiacion asosiacion) {
        this.asosiacion = asosiacion;
    }

    
    public void crearAsosiacion (Asosiacion a){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "INSERT INTO asosiaciones (nombre_aso) VALUES ('" + a.getNombre_aso()+ "')";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            //EJECUTAR LA CONSULTA
            int resul = sesion.executeUpdate();
            if (resul > 0){
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "REGISTRADO CON EXITO");
                sesion.close();
            }
            
        } catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTAR");
        }
        
    }
    public void eliminarAsosiacion (int id_aso){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM asosiaciones WHERE  id_aso = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            sesion.setInt(1, id_aso);
            int resul = sesion.executeUpdate();
            if (resul > 0){
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ASOCIASION ELIMINADA CON EXITO");
                sesion.close();
            }
            
        } catch (SQLException e){
            System.out.println(e);
        }
        
    }
    public int obtenerId(String  nombreAsosiacion) throws SQLException{
        String consulta = "select * from asosiaciones where nombre_aso = '" + nombreAsosiacion + "'";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int id = 0;
            try{
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = sesion.executeQuery();
            if (resul.next()){
                id = resul.getInt(1);
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ASOSIACION ENCONTRADA");
                sesion.close();
            }
            }catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
            return id;
    }
    public void actualizarAsosiacion(Asosiacion a,int id_aso){
         //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "UPDATE asosiaciones SET nombre_aso = ? WHERE id_aso = ? ";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            sesion.setString(1, a.getNombre_aso());
            sesion.setInt(2, id_aso);
            //EJECUTAR LA CONSULTA
            int resul = sesion.executeUpdate();
            if (resul > 0) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ACTUALIZADO CON EXITO");
                sesion.close();
            }

        } catch (SQLException e) {
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ACTUALIZAR");
        }
    }
     public int asoRepetir(String nombreA) {

        String consulta = "select * from asosiaciones where nombre_aso = '" + nombreA + "'";
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
            
        }
        return i;
    }
    
}
