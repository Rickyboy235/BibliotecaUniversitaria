/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.util.ArrayList;

/**
 *
 * @author ATKZ
 */
public class AlumnoPostgrado extends Alumno {
    /**
     * ESTA CLASE ES AUN PEOR YA QUE TAMBIEN SE LOGRO REALIZAR 
     * LA CONSULTA SIN LA NECESIDAD DE ESTA CLASE
     */
    private String maestria;

    public AlumnoPostgrado(String tipoUsuario, String codigo, String nombre,
            String apellPat, String apellMat, String maestria, String Ntelefono, String correo, String dni) {
        super(codigo, tipoUsuario, nombre, apellPat, apellMat, maestria, Ntelefono, correo, dni);
        this.maestria = maestria;
    }

    public String getEspecialidad() {
        return maestria;
    }

    public void setEspecialidad(String especialidad) {
        this.maestria = especialidad;
    }
    
    @Override
    public void mostrarDatos() {
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-15s | %-15s | %-15s |\n",
                    codigo, dni, tipoUsuario, nombre, apellPat, apellMat, maestria,
                    Ntelefono, correo);
    }
    

    public void mostrarRelacionPostgrado(ArrayList<AlumnoPostgrado> relacionAlumnos) {
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-10s | %-18s | %-15s | %-15s | %-15s |\n",
                    "Indice","CODIGO","DNI","TIPO ALUMNO","NOMBRE","APELLIDO PATERNO",
                    "APELLIDO MATERNO", "MAESTRIA", "TELEFONO", "CORREO");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (AlumnoPostgrado aluPos : relacionAlumnos) {
            System.out.printf("| %-5d ", contador++);
            aluPos.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
    
}
