/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

/**
 *
 * @author USER
 */
public class Docente extends Usuario {
    
    private String curso;
    private String especialidad;

    public Docente(String codigo, String nombre, String apellido, String Ntelefono, String correo, String dni) {
        super(codigo, nombre, apellido, Ntelefono, correo, dni);
    }

    
    public Docente( String codigo, String nombre, String apellido, String curso, String especialidad, String Ntelefono, String correo, String dni) {
        super(codigo, nombre, apellido, Ntelefono, correo, dni);
        this.curso = curso;
        this.especialidad = especialidad;
    }

    

    

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    @Override
    public String mostrarDatosUsuario() {
        
        return "\nCodigo: " + super.getCodigo() + "\nNombre: " + super.getNombre() 
                + "\nApellido: " + super.getApellido() + "\nCurso: " + curso + "\nEspecialidad: " + especialidad + "\n";
    }
}
