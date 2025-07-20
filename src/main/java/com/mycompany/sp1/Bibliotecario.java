/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

/**
 *
 * @author USER
 */
public class Bibliotecario {
    private String codigo;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private String telefono;

    public Bibliotecario() {
    }

    
    public Bibliotecario(String codigo, String nombre, String apellido, String dni, String correo, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     

    public void gestionarPedido() {
        System.out.println("lista de pedido pendientes");
        
    }

    public String mostrarInfo() {
        return "\nCodigo: " + codigo + "\nNombre: " + nombre + "\nApellido: " + apellido + 
                "\nDNI: " + correo + "\nTelefono: " + telefono;
    }

    public boolean rechazarPedido() {
        return false;
    }
}
