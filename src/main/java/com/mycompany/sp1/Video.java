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
public class Video extends Material{
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     */
    private String duracion;
    private String resolucion;

    public Video() {
    }

    public Video(String codMaterial, String titulo, String autor,String duracion, String idioma, String resolucion, int añoPub) {
        super(codMaterial, titulo, autor, idioma, añoPub);
        this.duracion = duracion;
        this.resolucion = resolucion;
    }
    
    public Video(String duracion, String resolucion) {
        this.duracion = duracion;
        this.resolucion = resolucion;
    }

    public Video(String titulo, String autor, String duracion, String idioma, String resolucion, int añoPub) {
        super(titulo, autor, idioma, añoPub);
        this.duracion = duracion;
        this.resolucion = resolucion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    
    
    @Override
    public void mostrarDatos() {
        System.out.printf("| %-25s | %-32s | %-10s | %-18s | %-12s | %-15s |\n",
                    titulo, autor, duracion, idioma, resolucion, añoPub);
    }
    public void mostrarRegistros(ArrayList<Video> listaVideos){
        System.out.println("-".repeat(131));
        System.out.printf("| %-10s | %-25s | %-32s | %-10s | %-18s | %-12s | %-15s |\n",
                    "INDICE","TITULO","AUTOR","DURACION","IDIOMA",
                    "RESOLUCION","AÑO PUBLICACION");
            System.out.println("-".repeat(131));
            int contador = 1;
            for (Video video : listaVideos) {
            System.out.printf("| %-10d ", contador++);
            video.mostrarDatos();
        }
            System.out.println("-".repeat(131));
    }
    
    public static Video fromResultSet(ResultSet rs) throws SQLException {
          return new Video(
                  rs.getString("codMaterial"),
                  rs.getString("titulo"),
                  rs.getString("autor"),
                  rs.getString("duracion"),
                  rs.getString("idioma"),
                  rs.getString("resolucion"),
                  rs.getInt("añoPubli")
          );
        }
}
