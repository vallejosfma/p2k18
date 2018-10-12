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
    private int id_documento;
    private String desc_familia;
    private int id_familia;

    public Documento(int id_documentos, String desc_familia, int id_familia) {
        this.id_documento = id_documentos;
        this.desc_familia = desc_familia;
        this.id_familia = id_familia;
    }

    public int getId_documentos() {
        return id_documento;
    }

    public void setId_documentos(int id_documentos) {
        this.id_documento = id_documentos;
    }

    public String getDesc_familia() {
        return desc_familia;
    }

    public void setDesc_familia(String desc_familia) {
        this.desc_familia = desc_familia;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }
    
    
}
