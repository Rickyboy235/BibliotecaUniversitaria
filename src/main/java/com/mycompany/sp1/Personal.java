/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class Personal {
    private String codPers;
    private String dniPers;
    private String tipoPers;
    private String nombPers;
    private String apePatPers;
    private String apeMatPers;
    private String areaPers;
    private String corrPers;
    private String telPers;

    public Personal() {
    }
    
    
    public Personal(String codPers, String dniPers, String tipoPers, String nombPers, String apePatPers, String apeMatPers, String areaPers, String corrPers, String telPers) {
        this.codPers = codPers;
        this.dniPers = dniPers;
        this.tipoPers = tipoPers;
        this.nombPers = nombPers;
        this.apePatPers = apePatPers;
        this.apeMatPers = apeMatPers;
        this.areaPers = areaPers;
        this.corrPers = corrPers;
        this.telPers = telPers;
    }

    public String getCodPers() {
        return codPers;
    }

    public void setCodPers(String codPers) {
        this.codPers = codPers;
    }

    public String getDniPers() {
        return dniPers;
    }

    public void setDniPers(String dniPers) {
        this.dniPers = dniPers;
    }

    public String getTipoPers() {
        return tipoPers;
    }

    public void setTipoPers(String tipoPers) {
        this.tipoPers = tipoPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public String getApePatPers() {
        return apePatPers;
    }

    public void setApePatPers(String apePatPers) {
        this.apePatPers = apePatPers;
    }

    public String getApeMatPers() {
        return apeMatPers;
    }

    public void setApeMatPers(String apeMatPers) {
        this.apeMatPers = apeMatPers;
    }

    public String getAreaPers() {
        return areaPers;
    }

    public void setAreaPers(String areaPers) {
        this.areaPers = areaPers;
    }

    public String getCorrPers() {
        return corrPers;
    }

    public void setCorrPers(String corrPers) {
        this.corrPers = corrPers;
    }

    public String getTelPers() {
        return telPers;
    }

    public void setTelPers(String telPers) {
        this.telPers = telPers;
    }
    
    
    public void mostrarDatos() {
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-15s | %-15s | %-15s |\n",
                    codPers, dniPers, tipoPers, nombPers, apePatPers, apeMatPers, areaPers, corrPers,telPers);
    }
    
    
    public void mostrarRelacion(ArrayList<Alumno> relacionAlumnos) {
        System.out.println("-".repeat(151));
        System.out.printf("| %-7s | %-17s | %-33s | %-28s | %-10s | %-10s | %-18s | %-15s | %-15s |\n",
                    "Indice","CODIGO","DNI","TIPO PERSONAL","NOMBRE","APELLIDO PATERNO",
                    "APELLIDO AREA", "CORREO", "TELEFONO");
            System.out.println("-".repeat(151));
            int contador = 1;
            for (Alumno aluPre : relacionAlumnos) {
            System.out.printf("| %-5d ", contador++);
            aluPre.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
}
