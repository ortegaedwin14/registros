/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author orteg
 */
public class Asosiacion {

    private int id_aso;
    private String nombre_aso;

    public Asosiacion() {
    }

    public Asosiacion(int id_aso, String nombre_aso) {
        this.id_aso = id_aso;
        this.nombre_aso = nombre_aso;
    }

    public int getId_aso() {
        return id_aso;
    }

    public void setId_aso(int id_aso) {
        this.id_aso = id_aso;
    }

    public String getNombre_aso() {
        return nombre_aso;
    }

    public void setNombre_aso(String nombre_aso) {
        this.nombre_aso = nombre_aso;
    }
    


    @Override
    public String toString() {
        return  "nombre: " + getNombre_aso();
    }
    
    
}
