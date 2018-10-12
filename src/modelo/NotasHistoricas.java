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
public class NotasHistoricas {
    private int id_calificacion;
    private int nota;
    private int id_asignatura;

    public NotasHistoricas(int id_calificacion, int nota, int id_asignatura) {
        this.id_calificacion = id_calificacion;
        this.nota = nota;
        this.id_asignatura = id_asignatura;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }
    
    
}
