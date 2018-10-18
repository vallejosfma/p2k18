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
    private int estado_curso;

    public Curso(int id_curso, String nombre_curso, int id_programa, int estado_curso) {
        this.id_curso = id_curso;
        this.nombre_curso = nombre_curso;
        this.id_programa = id_programa;
        this.estado_curso = estado_curso;
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

    public int getEstado_curso() {
        return estado_curso;
    }

    public void setEstado_curso(int estado_curso) {
        this.estado_curso = estado_curso;
    }
    
    
}
