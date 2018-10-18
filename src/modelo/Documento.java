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
public class Documento {
    private int id_doc;
    private String nombre_documento;
    private String ruta_documento;
    private String persona_rut;

    public Documento(int id_doc, String nombre_documento, String ruta_documento, String persona_rut) {
        this.id_doc = id_doc;
        this.nombre_documento = nombre_documento;
        this.ruta_documento = ruta_documento;
        this.persona_rut = persona_rut;
    }

    
    public int getId_doc() {
        return id_doc;
    }

    public void setId_doc(int id_doc) {
        this.id_doc = id_doc;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getRuta_documento() {
        return ruta_documento;
    }

    public void setRuta_documento(String ruta_documento) {
        this.ruta_documento = ruta_documento;
    }

    public String getPersona_rut() {
        return persona_rut;
    }

    public void setPersona_rut(String persona_rut) {
        this.persona_rut = persona_rut;
    }

  
    
}
