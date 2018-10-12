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
    
    String rut;
    String nombre_apellido;
    Date fecha_nacimiento;
    int edad;
    int telefono_movil;
    int telefono_fijo;
    String email;
    String vigencia;
    int id_comuna;
    int id_usuario;

    public Alumno(String rut, String nombre_apellido, Date fecha_nacimiento, int edad, int telefono_movil, int telefono_fijo, String email, String vigencia, int id_comuna, int id_usuario) {
        this.rut = rut;
        this.nombre_apellido = nombre_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.telefono_movil = telefono_movil;
        this.telefono_fijo = telefono_fijo;
        this.email = email;
        this.vigencia = vigencia;
        this.id_comuna = id_comuna;
        this.id_usuario = id_usuario;
    }
    
    
    
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(int telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public int getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(int telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
