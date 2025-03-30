/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
// Clase base Usuario
class Usuario {
    private String nombre;
    private String id;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
    }
}

// Subclase Alumno
class Alumno extends Usuario {
    private String carrera;

    public Alumno(String nombre, String id, String carrera) {
        super(nombre, id);
        this.carrera = carrera;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Carrera: " + carrera);
    }
}

// Subclase Docente
class Docente extends Usuario {
    private String especialidad;

    public Docente(String nombre, String id, String especialidad) {
        super(nombre, id);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Especialidad: " + especialidad);
    }
}
