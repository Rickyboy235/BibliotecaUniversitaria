/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Alumno extends Usuario {
    protected String carrera;
    
    //FALTA IMPLEMENTAR ESTA CLASE SIN EMBARGO YA CONSGUIMOS APARECE 
    //EL NOMBRE DEL ALUMNO SIN NECESIDAD DE ESTA WTF
    
    //constructor
    
    public Alumno(String codigo, String dni, String tipoUsuario, String nombre, String apellPat,
            String apellMat,String carrera, String Ntelefono, String correo) {
        super(codigo,tipoUsuario, nombre, apellPat, apellMat, Ntelefono, correo, dni);
        this.carrera = carrera;
    }
    
    
    //getters u setters
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    


    @Override
    public void mostrarDatos() {
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s | %-15s | %-15s |\n",
                    codigo, dni, tipoUsuario, nombre, apellPat, apellMat, carrera,
                    Ntelefono, correo);
    }
    
    public void mostrarRelacion(ArrayList<Alumno> relacionAlumnos) {
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s | %-15s | %-15s |\n\n",
                    "Indice","CODIGO","DNI","TIPO ALUMNO","NOMBRE","APELLIDO PATERNO",
                    "APELLIDO MATERNO","CARRERA", "TELEFONO", "CORREO");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Alumno aluPre : relacionAlumnos) {
            System.out.printf("| %-5d ", contador++);
            aluPre.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
    public static Alumno fromResultSet(ResultSet rs) throws SQLException {
          return new Alumno(
                  rs.getString("codAlPre"),
                  rs.getString("dniAlPre"),
                  rs.getString("tipoUsuario"),
                  rs.getString("nomAlPre"),
                  rs.getString("apePatAlPre"),
                  rs.getString("apeMatAlPre"),
                  rs.getString("carrera"),
                  rs.getString("corrAlPre"),
                  rs.getString("telAlPre")
          );
        }
    }

