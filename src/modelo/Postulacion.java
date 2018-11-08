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
    private java.sql.Date fecha_postulacion;
    private int Estado;
    private String persona_rut;
    private int id_programa;

    public Postulacion(int id_postulacion, java.sql.Date fecha_postulacion, int Estado, String persona_rut, int id_programa) {
        this.id_postulacion = id_postulacion;
        this.fecha_postulacion = fecha_postulacion;
        this.Estado = Estado;
        this.persona_rut = persona_rut;
        this.id_programa = id_programa;
    }

    
    
    
    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
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

    @Override
    public String toString() {
        return "Postulacion{" + "id_postulacion=" + id_postulacion + ", fecha_postulacion=" + fecha_postulacion + ", Estado=" + Estado + ", persona_rut=" + persona_rut + ", id_programa=" + id_programa + '}';
    }
    
    
}

