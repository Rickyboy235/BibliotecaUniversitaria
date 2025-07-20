/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author USER
 */
abstract class Usuario {
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     * POR EL MOMENTO
     */
    protected String codigo;
    protected String contraseña;
    protected String nombre;
    protected String apellPat;
    protected String apellMat;
    protected String Ntelefono;
    protected String correo;
    protected String dni;
    protected String tipoUsuario;

    public Usuario(String codigo, String tipoUsuario, String nombre, String apellPat, String apellMat, String Ntelefono, String correo, String dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellPat = apellPat;
        this.apellMat = apellMat;
        this.Ntelefono = Ntelefono;
        this.correo = correo;
        this.dni = dni;
        this.tipoUsuario = tipoUsuario;
    }
    //TALVES NO SE DEBA CREAR CUENTAS PERO SI SE PUEDE MODIFICAR CONTRASEAS

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellPat() {
        return apellPat;
    }

    public void setApellPat(String apellPat) {
        this.apellPat = apellPat;
    }

    public String getApellMat() {
        return apellMat;
    }

    public void setApellMat(String apellMat) {
        this.apellMat = apellMat;
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
    


    
    abstract void mostrarDatos();
    //abstract void mostrarRelacion();
}
