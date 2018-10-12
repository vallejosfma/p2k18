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
public class Asignatura {
    private int id_asignatura;
    private String asignatura;
    private String alumno_rut;

    public Asignatura(int id_asignatura, String asignatura, String alumno_rut) {
        this.id_asignatura = id_asignatura;
        this.asignatura = asignatura;
        this.alumno_rut = alumno_rut;
    }
    
    
    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAlumno_rut() {
        return alumno_rut;
    }

    public void setAlumno_rut(String alumno_rut) {
        this.alumno_rut = alumno_rut;
    }
    
    
    
}
