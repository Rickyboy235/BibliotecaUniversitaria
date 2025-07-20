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
public class Revista extends Material{
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     */
    private int volumen;
    private String editorial;

    public Revista() {
    }

    public Revista(int volumen, String editorial) {
        this.volumen = volumen;
        this.editorial = editorial;
    }

    public Revista(String titulo,String autor, int volumen, String idioma, String editorial, int añoPub) {
        super(titulo, autor, idioma, añoPub);
        this.volumen = volumen;
        this.editorial = editorial;
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
    public void mostrarDatos() {
        System.out.printf("| %-33s | %-28s | %-10s | %-18s | %-32s | %-15s |\n",
                    titulo, autor, volumen, idioma, editorial, añoPub);
    }
    public void mostrarRegistros(ArrayList<Revista> listaRevistas){
        System.out.println("-".repeat(155));
        System.out.printf("| %-33s | %-28s | %-10s | %-18s | %-32s | %-15s |\n",
                    "TITULO","AUTOR","VOLUMEN","IDIOMA",
                    "EDITORIAL","AÑO PUBLICACION");
            System.out.println("-".repeat(155));
            for (Revista revista : listaRevistas) {
            revista.mostrarDatos();
        }
            System.out.println("-".repeat(155));
    }
}
