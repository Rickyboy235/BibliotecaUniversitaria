/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author Usuario
 */
public class RelacionUsuarioMaterial <U, M>{
      private U usuario;
    private M material;

    public RelacionUsuarioMaterial(U usuario, M material) {
        this.usuario = usuario;
        this.material = material;
    }

    public U getUsuario() {
        return usuario;
    }

    public M getMaterial() {
        return material;
    }
}
