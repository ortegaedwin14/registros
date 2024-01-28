/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author orteg
 */
public class Registro_oficio {
    
    private int id_of;
    private String numero_of;
    private String solicitud;
    private String observaciones;
    private String responsable_of;
    private String fecha_entrega;
    private int fkres_cedula;
    private String fknom_nombre_aso;
    private String aprobado;
    private String  pdf;

    public Registro_oficio() {
    }


    public Registro_oficio(int id_of, String numero_of, String solicitud, String observaciones, String responsable_of, String fecha_entrega,int fkres_cedula, String fknom_nombre_aso, String aprobado, String pdf) {
        this.id_of = id_of;
        this.numero_of = numero_of;
        this.solicitud = solicitud;
        this.observaciones = observaciones;
        this.responsable_of = responsable_of;
        this.fecha_entrega = fecha_entrega;
        this.fkres_cedula = fkres_cedula;
        this.fknom_nombre_aso = fknom_nombre_aso;
        this.aprobado = aprobado;
        this.pdf = pdf;
    }
    public Registro_oficio(int id_of, String numero_of){
        this.id_of = id_of;
        this.numero_of = numero_of;
    }
    

    public int getId_of() {
        return id_of;
    }

    public void setId_of(int id_of) {
        this.id_of = id_of;
    }

    public String getNumero_of() {
        return numero_of;
    }

    public String getNumero_of(String string) {
        return numero_of;
    }

    public void setNumero_of(String numero_of) {
        this.numero_of = numero_of;
    }

    public String getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(String solicitud) {
        this.solicitud = solicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResponsable_of() {
        return responsable_of;
    }

    public void setResponsable_of(String responsable_of) {
        this.responsable_of = responsable_of;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getFkres_cedula() {
        return fkres_cedula;
    }

    public void setFkres_cedula(int fkres_cedula) {
        this.fkres_cedula = fkres_cedula;
    }

    public String getFknom_nombre_aso() {
        return fknom_nombre_aso;
    }

    public void setFknom_nombre_aso(String fknom_nombre_aso) {
        this.fknom_nombre_aso = fknom_nombre_aso;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    
  
    @Override
    public String toString() {
        return  "id_of: " + getId_of() + "\n" +
                "numero_of: " + getNumero_of() + "\n" +
                "solicitud: " + getObservaciones() + "\n" +
                "observaciones: " + getObservaciones() + "\n" +
                "responsable_of: " + getResponsable_of() + "\n" +
                "fecha_entrega: : " + getFecha_entrega() + "\n" +
                "cedula : " + getFkres_cedula()+ "\n" +
                "fknom_nombre_aso: " + getFknom_nombre_aso() + "\n" +
                "aprobado: " + getAprobado() + "\n" +
                "pdf: " + getPdf() ;
    }
    
    
}
