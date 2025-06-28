/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dispositivoselectronicos;

/**
 *
 * @author Usuario
 */
public class Laptop extends DispositivosElectronicos {
    private int horasBateria;

    public Laptop(String codigo, String marca, String modelo, String estado, boolean disponible, int horasBateria) {
        super(codigo, marca, modelo, estado, disponible);
        this.horasBateria = horasBateria;
    }

    public int getHorasBateria() {
        return horasBateria;
    }

    public void setHorasBateria(int horasBateria) {
        this.horasBateria = horasBateria;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Horas de batería: " + horasBateria);
    }
}
    

