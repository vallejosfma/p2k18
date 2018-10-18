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
    private Date fecha_postulacion;
    private String persona_rut;
    private int id_programa;

    public Postulacion(int id_postulacion, Date marca_temporal, String alumno_rut, int id_programa) {
        this.id_postulacion = id_postulacion;
        this.fecha_postulacion = marca_temporal;
        this.persona_rut = alumno_rut;
        this.id_programa = id_programa;
    }

    public int getId_postulacion() {
        return id_postulacion;
    }

    public void setId_postulacion(int id_postulacion) {
        this.id_postulacion = id_postulacion;
    }

    public Date getFecha_postulacion() {
        return fecha_postulacion;
    }

    public void setFecha_postulacion(Date fecha_postulacion) {
        this.fecha_postulacion = fecha_postulacion;
    }

    public String getPersona_rut() {
        return persona_rut;
    }

    public void setPersona_rut(String persona_rut) {
        this.persona_rut = persona_rut;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }
    
    
}

