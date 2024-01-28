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
import modelo.Responsable;

/**
 *
 * @author Sarita
 */
public class ResponsableControlador {
    private Responsable responsable;
    
    ConexionRegistro conexion = new ConexionRegistro();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;

    public ResponsableControlador() {
    }

    public ResponsableControlador(Responsable responsable) {
        this.responsable = responsable;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
    
    public void crearResponsable(Responsable r, int id){
       //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "INSERT INTO Responsable (cedula_res,nombres_res,apellidos_res,contacto_res,tipo_res,fkbc_id_bc) VALUES ('" + r.getCedula_res() + "','" + r.getNombres_res() + "','" + r.getApellidos_res() + "','" + r.getContacto_res() + "','" + r.getTipo_res() + "','" + id + "')";
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
            JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTAR");
            
        } 
    }
    public void actualizarResponsable(Responsable r,int id){
         //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "UPDATE responsable SET nombres_res = ? ,apellidos_res = ? ,contacto_res = ? ,tipo_res = ? ,fkbc_id_bc = ?  WHERE cedula_res = ? ";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            sesion.setString(1, r.getNombres_res());
            sesion.setString(2, r.getApellidos_res());
            sesion.setInt(3, r.getContacto_res());
            sesion.setString(4, r.getTipo_res());
            sesion.setInt(5, id);
            sesion.setInt(6, r.getCedula_res());
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
    public void eliminarResponsable (int  cedula_res){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM responsable WHERE  cedula_res = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            sesion.setInt(1, cedula_res);
            int resul = sesion.executeUpdate();
            if (resul > 0){
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ELIMINADO CON EXITO");
                sesion.close();
                
            }
            
        } catch (SQLException e){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO ELIMINAR");
        }
    }  
    public int obtenerBC(String  nombreBarrioConvenio) throws SQLException{
        String consulta = "select * from barrio_convenio where nombre_bc = '" + nombreBarrioConvenio + "'";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int id = 0;
            try{
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = sesion.executeQuery();
            if (resul.next()){
                id = resul.getInt(1);
                 Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "BARRIO/VONVENIO ES VÁLIDO");
                sesion.close();
            }
            }catch (SQLException e){
             Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "INGRESE UN BARRIO/CONVENIO YA REGISTRADO");
        }
            return id;
    }
}
