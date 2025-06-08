/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

/**
 *
 * @author USER
 */
public class Usuario {
    private String codigo;
    private String nombre;
    private String apellido;
    private String Ntelefono;
    private String correo;
    private String dni;

    public Usuario(String codigo, String nombre, String apellido, String Ntelefono, String correo, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Ntelefono = Ntelefono;
        this.correo = correo;
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNtelefono() {
        return Ntelefono;
    }

    public void setNtelefono(String Ntelefono) {
        this.Ntelefono = Ntelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public String mostrarDatosUsuario(){
        return codigo + nombre + apellido + dni 
                + Ntelefono; 
    }
    public String solicitarPrestamo(){
        return codigo + nombre + apellido;
    }
    
    public boolean cancelarPrestamo(){
        boolean estPrest = false;
        return estPrest;
    }
}
