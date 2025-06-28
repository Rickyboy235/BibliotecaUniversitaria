/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class BoletinInformativo {
    private String titulo;
    private List<String> articulos;

    public BoletinInformativo(String titulo) {
        this.titulo = titulo;
        this.articulos = new ArrayList<>();
    }

    public void agregarArticulo(String articulo) {
        articulos.add(articulo);
    }

    public List<String> listarArticulos() {
        return articulos;
    }

    public String getTitulo() {
        return titulo;
    }
}

