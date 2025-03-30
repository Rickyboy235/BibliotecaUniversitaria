/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
// Clase principal para probar el sistema
public class Biblioteca {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Juan Pérez", "A123", "Ingeniería");
        Docente docente1 = new Docente("María Gómez", "D456", "Matemáticas");

        Libro libro1 = new Libro("Estructuras de Datos", "Robert Lafore", 500);
        Multimedia multimedia1 = new Multimedia("Curso de Java", "Oracle", "Video");

        Prestamo prestamo1 = new Prestamo(alumno1, libro1);
        Prestamo prestamo2 = new Prestamo(docente1, multimedia1);

        prestamo1.mostrarDetalle();
        prestamo2.mostrarDetalle();
    }
}
