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
public class Computadora {
    private String codComp;
    private String marca;
    private String modelo;
    private int RAM;
    private String sisOperativo;
    private String ubicacion;

    public Computadora() {
    }

    
    public Computadora(String codComp, String marca, String modelo, int RAM, String sisOperativo, String ubicacion) {
        this.codComp = codComp;
        this.marca = marca;
        this.modelo = modelo;
        this.RAM = RAM;
        this.sisOperativo = sisOperativo;
        this.ubicacion = ubicacion;
    }

    public String getCodComp() {
        return codComp;
    }

    public void setCodComp(String codComp) {
        this.codComp = codComp;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
    public void mostrarDatos(){
        System.out.printf("| %-17s | %-15s | %-10s | %-25s | %-18s |\n",
                     marca, modelo, RAM, sisOperativo, ubicacion);
    }
    public void mostrarRegistro(ArrayList<Computadora> listaComputadoras){
        System.out.println("-".repeat(166));
        System.out.printf("| %-10s | %-17s | %-15s | %-10s | %-25s | %-18s |\n",
                    "INDICE","MARCA","MODELO","RAM","SIS. OPERATIVO","UBICACION");
        System.out.println("-".repeat(166));
        int contador = 1;
        for (Computadora computadora : listaComputadoras){
            System.out.printf("| %-10d " , contador++);
            computadora.mostrarDatos();
        }
        System.out.println("-".repeat(166));
    }
    public static Computadora fromResulSet(ResultSet rs) throws SQLException{
        return new Computadora(
                rs.getString("codPC"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getInt("RAM"),
                rs.getString("sistOperativo"),
                rs.getString("ubicacion")                
        );
    }
}
