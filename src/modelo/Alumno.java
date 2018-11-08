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
public class Alumno {

    private String rut;
    private String nacionalidad;
    private String rut_familia;
    private double nota;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }


    public String getRut_familia() {
        return rut_familia;
    }

    public void setRut_familia(String rut_familia) {
        this.rut_familia = rut_familia;
    }


    
    public Alumno(String rut, String nacionalidad)
    {
        this.rut = rut;
        this.nacionalidad = nacionalidad;
        rut_familia = "";
        nota = 0;
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

}
