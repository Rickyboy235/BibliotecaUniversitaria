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
 * @author ATKZ
 */
public class Tesis extends Material {
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     */
    private String universidad;
    private String grado;
    private String carrera;

    public Tesis() {
    }

    public Tesis(String universidad, String grado, String carrera) {
        this.universidad = universidad;
        this.grado = grado;
        this.carrera = carrera;
    }

    public Tesis(String titulo, String autor,String carrera, String universidad,String grado,String idioma, int añoPub) {
        super(titulo, autor, idioma, añoPub);
        this.universidad = universidad;
        this.grado = grado;
        this.carrera = carrera;
    }

    public Tesis(String codMaterial, String titulo, String autor, String carrera, String universidad, String grado, String idioma, int añoPub) {
        super(codMaterial, titulo, autor, idioma, añoPub);
        this.universidad = universidad;
        this.grado = grado;
        this.carrera = carrera;
    }
    
    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    
    @Override
    public void mostrarDatos() {
        System.out.printf("| %-40s | %-19s | %-28s | %-46s | %-24s | %-10s | %-15s |\n",
                    titulo, autor, carrera, universidad, grado, idioma, añoPub);
    }
    public void mostrarRegistros(ArrayList<Tesis> listaTesis){
        System.out.println("-".repeat(204));
        System.out.printf("| %-10s | %-40s | %-19s | %-28s | %-46s | %-24s | %-10s | %-15s |\n",
                    "INDICE","TITULO","AUTOR","CARRERA","UNIVERSIDAD",
                    "GRADO","IDIOMA","AÑO PUBLICACION");
            System.out.println("-".repeat(204));
            int contador = 1;
            for (Tesis tesis : listaTesis) {
            System.out.printf("| %-10d ", contador++);
            tesis.mostrarDatos();
        }
            System.out.println("-".repeat(204));
    }
    public static Tesis fromResultSet(ResultSet rs) throws SQLException {
          return new Tesis(
                  rs.getString("codMaterial"),
                  rs.getString("titulo"),
                  rs.getString("autor"),
                  rs.getString("carrera"),
                  rs.getString("universidad"),
                  rs.getString("grado"),
                  rs.getString("idioma"),
                  rs.getInt("añoPubli")
          );
        }
}
