/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public Libro(String ISBN,String titulo, String autor, int volumen, String editorial, String idioma, int añoPub) {
        super(titulo, autor, idioma, añoPub);
        this.ISBN = ISBN;
        this.volumen = volumen;
        this.editorial = editorial;
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
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s |\n",
                    "Indice","ISBN","TITULO","AUTOR","VOLUMEN","EDITORIAL",
                    "IDIOMA","AÑO PUBLICACION");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Libro libro : listaLibros) {
            System.out.printf("| %-5d ", contador++);
            libro.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
}

