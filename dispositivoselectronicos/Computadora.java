/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dispositivoselectronicos;

/**
 *
 * @author Usuario
 */
public class Computadora extends DispositivosElectronicos{
    private boolean tieneTecladoExterno;

    public Computadora(String codigo, String marca, String modelo, String estado, boolean disponible, boolean tieneTecladoExterno) {
        super(codigo, marca, modelo, estado, disponible);
        this.tieneTecladoExterno = tieneTecladoExterno;
    }

    public boolean isTieneTecladoExterno() {
        return tieneTecladoExterno;
    }

    public void setTieneTecladoExterno(boolean tieneTecladoExterno) {
        this.tieneTecladoExterno = tieneTecladoExterno;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tiene teclado externo: " + tieneTecladoExterno);
    }
}
    
    
    

