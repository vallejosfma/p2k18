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
public class Familia {
    private int id_familia;
    private int id_usuario;
    private String nombre_familia;
    private String direccion_familia;
    private String email_familia;
    private int telefono_fijo;
    private int telefono_movil;

    public Familia(int id_familia, int id_usuario, String nombre_familia, String direccion_familia, String email_familia, int telefono_fijo, int telefono_movil) {
        this.id_familia = id_familia;
        this.id_usuario = id_usuario;
        this.nombre_familia = nombre_familia;
        this.direccion_familia = direccion_familia;
        this.email_familia = email_familia;
        this.telefono_fijo = telefono_fijo;
        this.telefono_movil = telefono_movil;
    }

    public int getId_familia() {
        return id_familia;
    }

    public void setId_familia(int id_familia) {
        this.id_familia = id_familia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_familia() {
        return nombre_familia;
    }

    public void setNombre_familia(String nombre_familia) {
        this.nombre_familia = nombre_familia;
    }

    public String getDireccion_familia() {
        return direccion_familia;
    }

    public void setDireccion_familia(String direccion_familia) {
        this.direccion_familia = direccion_familia;
    }

    public String getEmail_familia() {
        return email_familia;
    }

    public void setEmail_familia(String email_familia) {
        this.email_familia = email_familia;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public int getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(int telefono_movil) {
        this.telefono_movil = telefono_movil;
    }
    
    
}
