/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dispositivoselectronicos;

/**
 *
 * @author Usuario
 */
public class Tablet extends DispositivosElectronicos {
    private boolean tieneSimCard;

    public Tablet(String codigo, String marca, String modelo, String estado, boolean disponible, boolean tieneSimCard) {
        super(codigo, marca, modelo, estado, disponible);
        this.tieneSimCard = tieneSimCard;
    }

    public boolean isTieneSimCard() {
        return tieneSimCard;
    }

    public void setTieneSimCard(boolean tieneSimCard) {
        this.tieneSimCard = tieneSimCard;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tiene SIM Card: " + tieneSimCard);
    }
}
    

