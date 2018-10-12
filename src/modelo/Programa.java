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
    private int id_pais;
    private String alumno_rut;

    public Programa(int id_programa, String nombre_programa, int duracion_programa, int id_pais, String alumno_rut) {
        this.id_programa = id_programa;
        this.nombre_programa = nombre_programa;
        this.duracion_programa = duracion_programa;
        this.id_pais = id_pais;
        this.alumno_rut = alumno_rut;
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

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getAlumno_rut() {
        return alumno_rut;
    }

    public void setAlumno_rut(String alumno_rut) {
        this.alumno_rut = alumno_rut;
    }
    
    
}
