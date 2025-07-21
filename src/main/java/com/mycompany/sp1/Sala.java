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
public class Sala {
    private String codSala;
    private String nomSala;
    private String campus;
    private int aforo;

    public Sala() {
    }
    
    public Sala(String codSala, String nomSala, String campus, int aforo) {
        this.codSala = codSala;
        this.nomSala = nomSala;
        this.campus = campus;
        this.aforo = aforo;
    }

    public String getCodSala() {
        return codSala;
    }

    public void setCodSala(String codSala) {
        this.codSala = codSala;
    }

    public String getNomSala() {
        return nomSala;
    }

    public void setNomSala(String nomSala) {
        this.nomSala = nomSala;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
    
    public void mostrarDatos(){
        System.out.printf("| %-33s | %-28s | %-10s |\n",
                     nomSala, campus, aforo);
    }
    public void mostrarRegistro(ArrayList<Sala> listaSalas){
        System.out.println("-".repeat(100));
        System.out.printf("| %-10s | %-33s | %-28s | %-10s |\n",
                    "INDICE","NOMBRE","CAMPUS","AFORO");
        System.out.println("-".repeat(100));
        int contador = 1;
        for (Sala sala : listaSalas){
            System.out.printf("| %-10d " , contador++);
            sala.mostrarDatos();
        }
        System.out.println("-".repeat(100));
    }
    public static Sala fromResulSet(ResultSet rs) throws SQLException{
        return new Sala(
                rs.getString("codSala"),
                rs.getString("nombSala"),
                rs.getString("campus"),
                rs.getInt("aforo")
        );
    }
}
