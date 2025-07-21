/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class Libro extends Material{
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS POR EL MOMENTO
     */
    private String ISBN;
    private int volumen;
    private String editorial;

    public Libro() {
    }



    public Libro( String codMaterial, String ISBN, String titulo, String autor, int volumen, String editorial, String idioma, int añoPub) {
        super(codMaterial, titulo, autor, idioma, añoPub);
        this.ISBN = ISBN;
        this.volumen = volumen;
        this.editorial = editorial;
    }

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getAñoPub() {
        return añoPub;
    }

    public void setAñoPub(int añoPub) {
        this.añoPub = añoPub;
    }
    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    @Override
    public void mostrarDatos(){
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s |\n",
                    ISBN, titulo, autor, volumen, editorial, idioma, añoPub);
    }
      public void mostrarRegistros(ArrayList<Libro> listaLibros){
        System.out.println("-".repeat(151));
        System.out.printf("| %-10s | %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s |\n",
                    "INDICE","ISBN","TITULO","AUTOR","VOLUMEN","EDITORIAL",
                    "IDIOMA","AÑO PUBLICACION");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Libro libro : listaLibros) {
            System.out.printf("| %-10d ", contador++);
            libro.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
     /* public Libro seleccionarLibro(ArrayList<Libro> listaLibros) {
          Scanner teclado = new Scanner(System.in);
          int indiceSelecc ;
          Libro libroSeleccionado = null;          
          do {
              System.out.println("ingrese el indice del libro que desea para prestamo");
              indiceSelecc = teclado.nextInt();
              if (indiceSelecc == 0) {
                  System.out.println("Seleccion cancelada");
                  return null;                  
              }
              if (indiceSelecc > 0 && indiceSelecc <= listaLibros.size()) {
                  libroSeleccionado = listaLibros.get(indiceSelecc - 1);
                  System.out.println("Libro seleccionado: " + libroSeleccionado.codMaterial);
              } else {
                  System.out.println("indice invalido, intente de nuevo.");
              }
          } while (libroSeleccionado == null);
          return libroSeleccionado;
      }*/
      
      public static Libro fromResultSet(ResultSet rs) throws SQLException {
          return new Libro(
                  rs.getString("codMaterial"),
                  rs.getString("ISBN"),
                  rs.getString("titulo"),
                  rs.getString("autor"),
                  rs.getInt("volumen"),
                  rs.getString("editorial"),
                  rs.getString("idioma"),
                  rs.getInt("añoPubli")
          );
        }
      
}