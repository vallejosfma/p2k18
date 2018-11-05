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
public class Usuario {


    private int id_usuario;
    private String usuario;
    private String password;
    private String persona_rut;
    private int id_rol;
    private int vigencia;
    
    public Usuario(int id_usuario, String usuario, String password, String persona_rut, int id_rol, int vigencia) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
        this.persona_rut = persona_rut;
        this.id_rol = id_rol;
        this.vigencia = vigencia;
    }
    
     public Usuario(String usuario, String password, String persona_rut, int id_rol) {
        this.usuario = usuario;
        this.password = password;
        this.persona_rut = persona_rut;
        this.id_rol = id_rol;       
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", usuario=" + usuario + ", password=" + password + ", persona_rut=" + persona_rut + ", id_rol=" + id_rol + ", vigencia=" + vigencia + '}';
    }

    public String getPersona_rut() {
        return persona_rut;
    }

    public void setPersona_rut(String persona_rut) {
        this.persona_rut = persona_rut;
    }


    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }


    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return password;
    }

    public void setContrasena(String contrasena) {
        this.password = contrasena;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    
    
}
