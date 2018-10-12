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
public class Curso {
    private int id_curso;
    private String nombre_curso;
    private int id_programa;
    private int situacion_curso_id_estado;

    public Curso(int id_curso, String nombre_curso, int id_programa, int situacion_curso_id_estado) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.id_programa = id_programa;
        this.situacion_curso_id_estado = situacion_curso_id_estado;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public int getSituacion_curso_id_estado() {
        return situacion_curso_id_estado;
    }

    public void setSituacion_curso_id_estado(int situacion_curso_id_estado) {
        this.situacion_curso_id_estado = situacion_curso_id_estado;
    }
    
    
}
