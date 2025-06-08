/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

/**
 *
 * @author USER
 */
public class Alumno extends Usuario {
    private String carrera;
    
    
    //constructor
    
    public Alumno(String codigo, String nombre, String apellido,String carrera, String Ntelefono, String correo, String dni) {
        super(codigo, nombre, apellido, Ntelefono, correo, dni);
        this.carrera = carrera;
    }
    
    
    //getters u setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

    //metodos heredados
    @Override
    public String mostrarDatosUsuario(){
        return "\nCodigo: " + super.getNombre() + "\nApellido: " + super.getApellido() + "\nCarrera: " + this.carrera + "\nTelefono: " + super.getNtelefono()
              + "\nCorreo: " + super.getCorreo() + "\nDNI : " + super.getDni() ;
    }
    
}
