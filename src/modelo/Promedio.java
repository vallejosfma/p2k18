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
public class Promedio {
    private int id_cal;
    private int nota;
    private String persona_rut;

    public Promedio(int id_cal, int nota, String persona_rut) {
        this.id_cal = id_cal;
        this.nota = nota;
        this.persona_rut = persona_rut;
    }

    public int getId_cal() {
        return id_cal;
    }

    public void setId_cal(int id_cal) {
        this.id_cal = id_cal;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getPersona_rut() {
        return persona_rut;
    }

    public void setPersona_rut(String persona_rut) {
        this.persona_rut = persona_rut;
    }
    
    
}
