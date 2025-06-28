/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.pkg60;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @Mikell
 */
public class Contenedor<T> {
    private String nombreContenedor;
    private List<T> elementos;
    private int capacidad;

    public Contenedor(String nombreContenedor, int capacidad) {
        this.nombreContenedor = nombreContenedor;
        this.capacidad = capacidad;
        this.elementos = new ArrayList<>();
    }

    public String getNombreContenedor() {
        return nombreContenedor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean agregarElemento(T elemento) {
        if (elementos.size() < capacidad) {
            this.elementos.add(elemento);
            System.out.println("Elemento agregado al contenedor '" + nombreContenedor + "'. Elementos actuales: " + elementos.size() + "/" + capacidad);
            return true;
        } else {
            System.out.println("El contenedor '" + nombreContenedor + "' esta lleno. No se puede agregar mas elementos.");
            return false;
        }
    }

    public boolean eliminarElemento(T elemento) {
        if (this.elementos.remove(elemento)) {
            System.out.println("Elemento eliminado del contenedor '" + nombreContenedor + "'. Elementos actuales: " + elementos.size() + "/" + capacidad);
            return true;
        } else {
            System.out.println("El elemento no se encontro en el contenedor '" + nombreContenedor + "'.");
            return false;
        }
    }

    public List<T> obtenerTodos() {
        System.out.println("\n--- Elementos en el Contenedor: " + nombreContenedor + " ---");
        System.out.println("Capacidad: " + elementos.size() + "/" + capacidad);
        if (elementos.isEmpty()) {
            System.out.println("El contenedor esta vacio.");
        } else {
            for (int i = 0; i < elementos.size(); i++) {
                System.out.println((i + 1) + ". " + elementos.get(i).toString());
            }
        }
        return new ArrayList<>(this.elementos);
    }

    public Optional<T> buscarElemento(java.util.function.Predicate<T> predicado) {
        for (T elemento : elementos) {
            if (predicado.test(elemento)) {
                System.out.println("Elemento encontrado en el contenedor '" + nombreContenedor + "'.");
                return Optional.of(elemento);
            }
        }
        System.out.println("Elemento no encontrado en el contenedor '" + nombreContenedor + "'.");
        return Optional.empty();
    }

    public boolean estaLleno() {
        return elementos.size() >= capacidad;
    }

    public boolean estaVacio() {
        return elementos.isEmpty();
    }

    public int getTamanoActual() {
        return elementos.size();
    }
}