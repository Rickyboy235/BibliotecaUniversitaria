/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Docente extends Usuario {
    /**
     * FALTA IMPLEMENTAR
     */
    
    private String curso;
    private String especialidad;

    public Docente(String codigo, String dni, String tipoUsuario, String nombre, String apellPat, String apellMat, String Ntelefono, String correo) {
        super(codigo,tipoUsuario, nombre, apellPat, apellMat, Ntelefono, correo, dni);
    }

    
    public Docente( String codigo, String dni, String tipoUsuario, String nombre, String apellPat, String apellMat, String curso, String especialidad, String Ntelefono, String correo) {
        super(codigo, nombre, tipoUsuario, apellPat, apellMat, Ntelefono, correo, dni);
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
    public void mostrarDatos() {
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s | %-15s | %-15s |\n",
                    codigo, dni, tipoUsuario, nombre, apellPat, apellMat, curso,
                    Ntelefono, correo);
    }
    
    public void mostrarRelacion(ArrayList<Docente> relacionDocentes) {
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s | %-15s | %-15s |\n\n",
                    "Indice","CODIGO","DNI","TIPO USUARIO","NOMBRE","APELLIDO PATERNO",
                    "APELLIDO MATERNO","CURSO", "TELEFONO", "CORREO");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Docente docente : relacionDocentes) {
            System.out.printf("| %-5d ", contador++);
            docente.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
}
