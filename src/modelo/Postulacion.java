/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Seba PC
 */
public class Postulacion {
    private int id_postulacion;
    private Date marca_temporal;
    private String alumno_rut;
    private int id_programa;

    public Postulacion(int id_postulacion, Date marca_temporal, String alumno_rut, int id_programa) {
        this.id_postulacion = id_postulacion;
        this.marca_temporal = marca_temporal;
        this.alumno_rut = alumno_rut;
        this.id_programa = id_programa;
    }

    public int getId_postulacion() {
        return id_postulacion;
    }

    public void setId_postulacion(int id_postulacion) {
        this.id_postulacion = id_postulacion;
    }

    public Date getMarca_temporal() {
        return marca_temporal;
    }

    public void setMarca_temporal(Date marca_temporal) {
        this.marca_temporal = marca_temporal;
    }

    public String getAlumno_rut() {
        return alumno_rut;
    }

    public void setAlumno_rut(String alumno_rut) {
        this.alumno_rut = alumno_rut;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }
    
    
}

