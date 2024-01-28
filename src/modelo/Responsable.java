/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author orteg
 */
public class Responsable {
    private int cedula_res;
    private String nombres_res;
    private String apellidos_res;
    private int contacto_res;
    private String tipo_res;
    private String fkbc_id_bc;

    public Responsable() {
    }

    public Responsable(int cedula_res, String nombres_res, String apellidos_res, int contacto_res, String tipo_res, String fkbc_id_bc) {
        this.cedula_res = cedula_res;
        this.nombres_res = nombres_res;
        this.apellidos_res = apellidos_res;
        this.contacto_res = contacto_res;
        this.tipo_res = tipo_res;
        this.fkbc_id_bc = fkbc_id_bc;
    }

    public int getCedula_res() {
        return cedula_res;
    }

    public void setCedula_res(int cedula_res) {
        this.cedula_res = cedula_res;
    }

    public String getNombres_res() {
        return nombres_res;
    }

    public void setNombres_res(String nombres_res) {
        this.nombres_res = nombres_res;
    }

    public String getApellidos_res() {
        return apellidos_res;
    }

    public void setApellidos_res(String apellidos_res) {
        this.apellidos_res = apellidos_res;
    }

    public int getContacto_res() {
        return contacto_res;
    }

    public void setContacto_res(int contacto_res) {
        this.contacto_res = contacto_res;
    }

    public String getTipo_res() {
        return tipo_res;
    }

    public void setTipo_res(String tipo_res) {
        this.tipo_res = tipo_res;
    }

    public String getFkbc_id_bc() {
        return fkbc_id_bc;
    }

    public void setFkbc_id_bc(String fkbc_id_bc) {
        this.fkbc_id_bc = fkbc_id_bc;
    }

    

    @Override
    public String toString() {
        return "cedula_res: " + getCedula_res() +"\n"+
                "nombres_res: " + getNombres_res() +"\n"+
                "apellidos_res: " + getApellidos_res() +"\n"+
                "contacto_res: " + getContacto_res() +"\n"+
                "tipo_res: " + getTipo_res() +"\n"+
                "nombre_bc: " + getFkbc_id_bc() ;
    }
    
    
}