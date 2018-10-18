/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Seba PC
 */
public class Programa {
    private int id_programa;
    private String nombre_programa;
    private int duracion_programa;
    private int id_cel;

    public Programa(int id_programa, String nombre_programa, int duracion_programa, int id_cel) {
        this.id_programa = id_programa;
        this.nombre_programa = nombre_programa;
        this.duracion_programa = duracion_programa;
        this.id_cel = id_cel;
    }

    
    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre_programa() {
        return nombre_programa;
    }

    public void setNombre_programa(String nombre_programa) {
        this.nombre_programa = nombre_programa;
    }

    public int getDuracion_programa() {
        return duracion_programa;
    }

    public void setDuracion_programa(int duracion_programa) {
        this.duracion_programa = duracion_programa;
    }

    public int getId_cel() {
        return id_cel;
    }

    public void setId_cel(int id_cel) {
        this.id_cel = id_cel;
    }

    

}
