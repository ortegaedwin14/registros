/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author orteg
 */
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author orteg
 */
public class ConexionRegistro {
   java.sql.Connection conexion;

    public java.sql.Connection conectar(){
        //LANZAR CÓDIGO DE PRUEBA 
        try {
            //Manera de Conexión a la Base de Datos
            Class.forName("com.mysql.jdbc.Driver");
            //Parámetros de conexión url/usuario/clave en mysql
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/registros?autoReconnect=true&useSSL=false","root","1005023849oe");
            //System.out.println("CONECTADO"); 
        } catch (ClassNotFoundException | SQLException e)//CAPTURAR ERRORES 
        {
             System.out.println("ERROR DE CONEXION A LA BASE DE DATOS");
        }
        return conexion;
    }
    
}
