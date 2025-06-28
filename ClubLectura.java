/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class ClubLectura {
    private String nombreClub;
    private List<AlumnoPostgrado> miembros;

    public ClubLectura(String nombreClub) {
        this.nombreClub = nombreClub;
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(AlumnoPostgrado alumno) {
        miembros.add(alumno);
    }

    public List<AlumnoPostgrado> listarMiembros() {
        return miembros;
    }

    public String getNombreClub() {
        return nombreClub;
    }
}