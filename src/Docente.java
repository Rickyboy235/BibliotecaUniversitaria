/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Docente extends Usuario {
    private String especialidad;
    public Docente(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Especialidad: " + especialidad);
    }
}
