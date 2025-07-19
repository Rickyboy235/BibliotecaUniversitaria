/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.material;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Electronico {
    private String marca;
    private String modelo;
    private String tipoDispositivo;
    private int ramGB;
    private String sistemaOperativo;

    public Electronico(String id, String titulo, String marca, String modelo, String tipoDispositivo, int ramGB, String sistemaOperativo) {
  
        this.marca = marca;
        this.modelo = modelo;
        this.tipoDispositivo = tipoDispositivo;
        this.ramGB = ramGB;
        this.sistemaOperativo = sistemaOperativo;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public int getRamGB() {
        return ramGB;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void mostrarInfo() {       
        System.out.println("Tipo dispositivo: " + tipoDispositivo + ", RAM: " + ramGB + " GB, Sistema operativo: " + sistemaOperativo);
    }
}

// Repositorio en memoria para Electronicos usando ArrayList
class ElectronicoRepository {
    private List<Electronico> electronicos = new ArrayList<>();

    // Guardar un electronico
    public void guardarElectronico(Electronico e) {
        electronicos.add(e);
    }

    // Obtener electronico por id
    // Mostrar todos
    public void mostrarTodos() {
        for (Electronico e : electronicos) {
            e.mostrarInfo();
            System.out.println("---");
        }
    }
}