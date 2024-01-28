/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Registro_oficio;
import vista_Oficios.ActualizarOpcion;

/**
 *
 * @author orteg
 */
public class Registro_OficioControlador {
    
private Registro_oficio registro_ficio; 

    ConexionRegistro  conexion = new ConexionRegistro();
    //OBJETO 
    Connection conectado = (Connection) conexion.conectar();
    //DOWNCASTING
    PreparedStatement sesion;
    ResultSet res;
    Statement stmt;

    public Registro_OficioControlador() {
    }

    public Registro_OficioControlador(Registro_oficio registro_ficio) {
        this.registro_ficio = registro_ficio;
    }

    public Registro_oficio getRegistro_ficio() {
        return registro_ficio;
    }

    public void setRegistro_ficio(Registro_oficio registro_ficio) {
        this.registro_ficio = registro_ficio;
    }
    
    public void crearRegistro_oficio (Registro_oficio r,int id){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "INSERT INTO registro_oficio (numero_of, solicitud, observaciones, responsable_of,fkres_cedula, fkaso_id_aso, aprobado, pdf) VALUES ('"+ r.getNumero_of() +  "','" +r.getSolicitud() +  "','" +r.getObservaciones() +  "','" + r.getResponsable_of()  + "','" + r.getFkres_cedula() + "','" + id +  "','" +r.getAprobado() +  "','" +r.getPdf()+"')";
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
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REALIZAR EL REGISTRO");
        }
        
    }  
    public void actualizarRegistro(Registro_oficio r,int id,int id_of) {
        try {
            String consulta = "UPDATE registro_oficio SET numero_of = ?, solicitud = ?, observaciones = ?, responsable_of = ?,fkres_cedula = ? , fkaso_id_aso = ?, aprobado  = ?, pdf = ? WHERE id_of = ?";
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            sesion.setString(1, r.getNumero_of());
            sesion.setString(2, r.getSolicitud());
            sesion.setString(3, r.getObservaciones());
            sesion.setString(4, r.getResponsable_of());
            sesion.setInt(5, r.getFkres_cedula());
            sesion.setInt(6, id);
            sesion.setString(7,r.getAprobado());
            sesion.setString(8,r.getPdf());
            sesion.setInt(9,r.getFkres_cedula());
            sesion.setInt(9,r.getId_of());

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
        public void buscarOficio(int cedula) throws SQLException{
        String consulta = "SELECT * FROM registros.registro_oficio WHERE fkres_cedula = " +cedula;
            //INICIAR SESIÓN A NIVEL DE MYSQL
            int i = 1;
            try{
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);

            ResultSet resul = sesion.executeQuery();
            while (resul.next()){
                System.out.println(i + ". " +resul.getString(3) + resul.getString(6));
                i++;
            }
            }catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
         
        }
        
    public int comprobarOficio( int indice) throws SQLException {
    String cedula = null;
        String consulta = "SELECT * FROM registros.registro_oficio WHERE fkres_cedula = " + cedula + " LIMIT " + (indice - 1) + "," + indice;
        //INICIAR SESIÓN A NIVEL DE MYSQL
        int id_of = 0;
        try {
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            ResultSet resul = sesion.executeQuery();
            while (resul.next()) {
                System.out.println(indice + ". " + resul.getString(2));
                id_of = resul.getInt(1);
            }
        }catch (SQLException e){
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
        return id_of;
    }
    
    public void eliminarOficio (int  id_of){
        //TRY Y CATCH
        try {
            //GENERAR LA CONSULTA SQL
            String consulta = "DELETE FROM registro_oficio WHERE  id_of = ?";
            //INICIAR SESIÓN A NIVEL DE MYSQL
            sesion = (PreparedStatement) conectado. prepareStatement(consulta);
            sesion.setInt(1, id_of);
            int resul = sesion.executeUpdate();
            if (resul > 0){
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "ELIMINADO CON EXITO");
                sesion.close();
            }
            
        } catch (SQLException e){
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO EXISTE");
        }
    }
    public void ActualizarAprobado(String fecha_entrega, String aprobado,String pdf,int id_of){
        try {
            String consulta = "UPDATE registro_oficio SET fecha_entrega = ?, aprobado  = ?, pdf = ? WHERE id_of = ?";
            sesion = (PreparedStatement) conectado.prepareStatement(consulta);
            sesion.setString(1, fecha_entrega);
            sesion.setString(2, aprobado);
            sesion.setString(3, pdf);
            sesion.setInt(4, id_of);

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
    public void buscarR(int cedula){
        try {
            String consulta = "SELECT o.id_of, r.cedula_res, r.nombres_res, r.apellidos_res, r.tipo_res, o.numero_of, o.solicitud, o.observaciones,o.fecha_recepcion, o.fecha_entrega, b.nombre_bc, a.nombre_aso, o.pdf, o.aprobado " +
                              "FROM registro_oficio o " +
                              "INNER JOIN responsable r on r.cedula_res = o.fkres_cedula  " +
                              "INNER JOIN barrio_convenio b  on  b.id_bc = r.fkbc_id_bc  " +
                              "INNER JOIN asosiaciones a on a.id_aso = o.fkaso_id_aso  " +
                              "WHERE fkres_cedula = " + cedula ;
            sesion=(PreparedStatement) conectado.prepareStatement(consulta);
            //res CONTIENE EL RESULTADO DE LA CONSULTA QUE ES UNA FILA
            res=sesion.executeQuery();
            while (res.next()){
                System.out.println("ID: " + res.getString(1));
                System.out.println("CEDULA: " + res.getString("cedula_res"));
                System.out.println("NOMBRES: " + res.getString("nombres_res"));
                System.out.println("APELLIDOS: " + res.getString("apellidos_res"));
                System.out.println("TIPO RESPONSABLE: " + res.getString("tipo_res"));
                System.out.println("NUMERO OFICIO: " + res.getString("numero_of"));
                System.out.println("SOLICITUD: " + res.getString("solicitud"));
                System.out.println("OBSERVACIONES: " + res.getString("observaciones"));
                System.out.println("FECHA RECEPCION: " + res.getString("fecha_recepcion"));
                System.out.println("FECHA ENTREGA: " + res.getString("fecha_entrega"));
                System.out.println("NOMBRE BARRIO O CONVENIO: " + res.getString("nombre_bc"));
                System.out.println("NOMBRE ASOCIACION: " + res.getString("nombre_aso"));
                System.out.println("ARCHIVO PDF: " + res.getString("pdf"));
                System.out.println("APROBADO: " + res.getString("aprobado"));
                System.out.println("--------------------");
                
            }
            sesion.close();
        } catch (SQLException e) {
            Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REALIZAR LO SOLICITADO");
        }
    
}

    /**
     *
     * @return
     */
   /** public ArrayList<Registro_oficio> getRegistro_Ofico(){
    
        ArrayList<Registro_oficio> listaRegistro_oficio = new ArrayList<>();
        
        try{
            stmt = (Statement) conectado.createStatement();
            res = stmt.executeQuery("SELECT * FROM registro_oficio");
            
            while(res.next()){
                Registro_oficio ro = new Registro_oficio();
                ro.setId_of(res.getInt("id_of"));
                ro.setNumero_of(res.getString("numero_of"));
                listaRegistro_oficio.add(ro);
            }
        }catch (SQLException e) { 
        }
        return listaRegistro_oficio;
    }*/
   
    
}
