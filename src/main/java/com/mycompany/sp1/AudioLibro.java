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
public class AudioLibro extends Material{
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     */
    private String duracion;
    private String formato;

    public AudioLibro() {
    }

    public AudioLibro(String duracion, String formato) {
        this.duracion = duracion;
        this.formato = formato;
    }

    public AudioLibro(String titulo, String autor, String duracion, String idioma, String formato, int añoPub) {
        super(titulo, autor, idioma, añoPub);
        this.duracion = duracion;
        this.formato = formato;
    }
    
    
    @Override
    public void mostrarDatos() {
        System.out.printf("| %-25s | %-34s | %-10s | %-18s | %-12s | %-15s |\n",
                    titulo, autor, duracion, idioma, formato, añoPub);
    }
    public void mostrarRegistros(ArrayList<AudioLibro> listaAudioL){
        System.out.println("-".repeat(133));
        System.out.printf("| %-25s | %-34s | %-10s | %-18s | %-12s | %-15s |\n",
                    "TITULO","AUTOR","DURACION","IDIOMA",
                    "FORMATO","AÑO PUBLICACION");
            System.out.println("-".repeat(133));
            for (AudioLibro Alibro : listaAudioL) {
            Alibro.mostrarDatos();
        }
            System.out.println("-".repeat(133));
    }
    
}
