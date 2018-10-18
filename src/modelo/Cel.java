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
public class Cel {
    private int cel;
    private String nombre_cel;
    private String direccion;
    private int telefono;
    private String email_contacto;
    private int pais;

    public Cel(int cel, String nombre_cel, String direccion, int telefono, String email_contacto, int pais) {
        this.cel = cel;
        this.nombre_cel = nombre_cel;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email_contacto = email_contacto;
        this.pais = pais;
    }

    
    
    
    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
    
    public int getCel() {
        return cel;
    }

    public void setCel(int cel) {
        this.cel = cel;
    }

    public String getNombre_cel() {
        return nombre_cel;
    }

    public void setNombre_cel(String nombre_cel) {
        this.nombre_cel = nombre_cel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }


    
    
    
}
