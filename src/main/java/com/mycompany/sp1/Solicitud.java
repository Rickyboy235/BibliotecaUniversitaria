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
public class Solicitud {
    /**
     * CLASE QUE SOLO SIRVE PARA MOSTRAR DATOS
     * POR EL MOMENTO
     */
        String codSol;
        String codUsu;
        String codPers;
        String tipSol;
        String fecSol;
        String estSol;
        
        String custom1;
        String custom2;
        String custom3;
        String custom4;

    public Solicitud(String custom1, String custom2, String custom3, String custom4) {
        this.custom1 = custom1;
        this.custom2 = custom2;
        this.custom3 = custom3;
        this.custom4 = custom4;
    }
    
    public Solicitud() {
    }

    public Solicitud(String codSol, String codUsu, String codPers, String tipSol, String fecSol, String estSol) {
        this.codSol = codSol;
        this.codUsu = codUsu;
        this.codPers = codPers;
        this.tipSol = tipSol;
        this.fecSol = fecSol;
        this.estSol = estSol;
    }

    public Solicitud(String codSol, String codUsu, String tipSol, String fecSol, String estSol) {
        this.codSol = codSol;
        this.codUsu = codUsu;
        this.tipSol = tipSol;
        this.fecSol = fecSol;
        this.estSol = estSol;
    }

    public String getCodSol() {
        return codSol;
    }

    public void setCodSol(String codSol) {
        this.codSol = codSol;
    }

    public String getCodUsu() {
        return codUsu;
    }

    public void setCodUsu(String codUsu) {
        this.codUsu = codUsu;
    }

    public String getCodPros() {
        return codPers;
    }

    public void setCodPros(String codPros) {
        this.codPers = codPros;
    }

    public String getTipSol() {
        return tipSol;
    }

    public void setTipSol(String tipSol) {
        this.tipSol = tipSol;
    }

    public String getFecSol() {
        return fecSol;
    }

    public void setFecSol(String fecSol) {
        this.fecSol = fecSol;
    }

    public String getEstSol() {
        return estSol;
    }

    public void setEstSol(String estSol) {
        this.estSol = estSol;
    }
    public void mostrarDatosHistorial(){
        System.out.printf("| %-17s | %-43s | %-28s | %-10s |\n",
                    custom1, custom2, custom3,custom4);
    }
    public void mostrarHistorial(ArrayList<Solicitud> listahisto){
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-43s | %-28s | %-10s|\n",
                   "Indice", "codigo","descripcion","tipo de material","fecha Solicitud");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Solicitud solicitud : listahisto) {
                System.out.printf("| %-7d ", contador++);
                solicitud.mostrarDatosHistorial();
        }
            System.out.println("-".repeat(151));
    }
    public void mostrarDatos(){
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s |\n",
                    codSol, codUsu, tipSol, fecSol, estSol);
    }
    public void mostrarSolicitudes(ArrayList<Solicitud> listaSolicitud){
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-18s |\n",
                   "Indice", "codigo","codigo Solicitante","tipo de Solicitud","fecha Solicitud","estado Solicitud");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Solicitud solicitud : listaSolicitud) {
                System.out.printf("| %-7d ", contador++);
                solicitud.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
    
     public static Solicitud fromResultSet(ResultSet rs) throws SQLException {
          return new Solicitud(
                  rs.getString("codSolicitud"),
                  rs.getString("codUsuario"),
                  rs.getString("tipoSolicitud"),
                  rs.getString("codMaterial"),
                  rs.getString("tipoMaterial"),
                  rs.getString("fechaSolicitud")
          );
        }   
}

