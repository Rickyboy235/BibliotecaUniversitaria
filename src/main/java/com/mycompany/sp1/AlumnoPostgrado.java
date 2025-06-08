/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

/**
 *
 * @author ATKZ
 */
public class AlumnoPostgrado extends Alumno {
    private String especialidad;

    public AlumnoPostgrado(String especialidad, String codigo, String nombre, String apellido, String carrera, String Ntelefono, String correo, String dni) {
        super(codigo, nombre, apellido, carrera, Ntelefono, correo, dni);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public String mostrarDatosUsuario(){
        return super.mostrarDatosUsuario() + especialidad;
    }
    
}
