/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dispositivoselectronicos;

/**
 *
 * @author Usuario
 */
public class DispositivosElectronicos {
private String codigo;
    private String marca;
    private String modelo;
    private String estado;
    private boolean disponible;

    public DispositivosElectronicos(String codigo, String marca, String modelo, String estado, boolean disponible) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método general
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Estado: " + estado);
        System.out.println("Disponible: " + disponible);
    }
}

 
    

