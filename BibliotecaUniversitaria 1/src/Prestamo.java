/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
// Clase Prestamo
public class Prestamo {
    private Usuario usuario;
    private MaterialBibliografico material;

    public Prestamo(Usuario usuario, MaterialBibliografico material) {
        this.usuario = usuario;
        this.material = material;
    }

    public void mostrarDetalle() {
        System.out.println("Detalles del préstamo:");
        usuario.mostrarInfo();
        material.mostrarInfo();
    }
}
