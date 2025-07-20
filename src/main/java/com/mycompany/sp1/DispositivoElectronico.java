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
public class DispositivoElectronico {
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     */
    private String codMaterial;
    private String marca;
    private String modelo;
    private String tipoDisp;
    private String tarjGrafica;
    private int RAM;
    private String sisOperativo;

    public DispositivoElectronico(String tipoDisp, String marca, String modelo, String tarjGrafica, int RAM, String sisOperativo) {
        this.marca = marca;
        this.modelo = modelo;
        this.tarjGrafica = tarjGrafica;
        this.tipoDisp = tipoDisp;
        this.RAM = RAM;
        this.sisOperativo = sisOperativo;
    }

    public DispositivoElectronico(String codMaterial, String tipoDisp, String marca, String modelo, String tarjGrafica, int RAM, String sisOperativo) {
        this.codMaterial = codMaterial;
        this.marca = marca;
        this.modelo = modelo;
        this.tarjGrafica = tarjGrafica;
        this.tipoDisp = tipoDisp;
        this.RAM = RAM;
        this.sisOperativo = sisOperativo;
    }  
    
    public DispositivoElectronico() {
        
    }

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
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

    public String getTipoDisp() {
        return tipoDisp;
    }

    public void setTipoDisp(String tipoDisp) {
        this.tipoDisp = tipoDisp;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getSisOperativo() {
        return sisOperativo;
    }

    public void setSisOperativo(String sisOperativo) {
        this.sisOperativo = sisOperativo;
    }
    
    

    
    public void mostrarDatos() {
        System.out.printf("| %-10s | %-10s | %-28s | %-16s | %-6s | %-24s |\n",
                    tipoDisp, marca, modelo, tarjGrafica, RAM, sisOperativo);
    }
    public void mostrarRegistros(ArrayList<DispositivoElectronico> listaDispElec){
        System.out.println("-".repeat(113));
        System.out.printf("| %-10s | %-10s | %-28s | %-16s | %-6s | %-24s |\n",
                    "TIPO DISP","MARCA","MODELO","TARJETA GRAFICA","RAM",
                    "SIST. OPERATIVO");
            System.out.println("-".repeat(113));
            for (DispositivoElectronico dispElec : listaDispElec) {
            dispElec.mostrarDatos();
        }
            System.out.println("-".repeat(113));
    }
}
