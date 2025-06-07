/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Alumno extends Usuario {
    private String carrera;
    public Alumno(String nombre, String id, String carrera) {
        super(nombre, id);
        this.carrera = carrera;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
            System.out.println("Carrera: " + carrera);
    }  
}
