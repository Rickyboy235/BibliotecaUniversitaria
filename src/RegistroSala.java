/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class RegistroSala<E, U> {
    private E estudiante;
    private U usoDetalle;
    
    public RegistroSala(E estudiante, U usoDetalle) {
        this.estudiante = estudiante;
        this.usoDetalle = usoDetalle;
    }
    public E getEstudiante() {
        return estudiante;
    }
    public U getUsoDetalle() {
        return usoDetalle;
    }
}
