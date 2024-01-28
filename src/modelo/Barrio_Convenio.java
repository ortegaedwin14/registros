/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author orteg
 */
public class Barrio_Convenio {
    private int id_bc;
    private String nombre_bc;
    private String tipo_bc;

    public Barrio_Convenio() {
    }

    public Barrio_Convenio(int id_bc, String nombre_bc, String tipo_bc) {
        this.id_bc  =  id_bc;
        this.nombre_bc = nombre_bc;
        this.tipo_bc = tipo_bc;
    }

    public int getId_bc() {
        return id_bc;
    }

    public void setId_bc(int id_bc) {
        this.id_bc = id_bc;
    }
    

    public String getNombre_bc() {
        return nombre_bc;
    }

    public String getTipo_bc() {
        return tipo_bc;
    }

    public void setNombre_bc(String nombre_bc) {
        this.nombre_bc = nombre_bc;
    }

    public void setTipo_bc(String tipo_bc) {
        this.tipo_bc = tipo_bc;
    }

    @Override
    public String toString() {
        return  "nombre: " + getNombre_bc() +"\n"+ "tipo: " + getTipo_bc();
    }
    
    
    
}