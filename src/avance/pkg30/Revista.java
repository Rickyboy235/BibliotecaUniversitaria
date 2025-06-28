/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avance.pkg30;

/**
 *
 * @Mikell
 */
public class Revista extends MaterialBibliografico {
    private int numeroEdicion;
    private String fechaPublicacion; 

    public Revista(String titulo, String autor, int numeroEdicion, String fechaPublicacion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Revista");
        System.out.println("Titulo: " + titulo);
        System.out.println("Editor/Autor: " + autor);
        System.out.println("Numero de Edicion: " + numeroEdicion);
        System.out.println("Fecha de Publicacion: " + fechaPublicacion);
    }
    
    public boolean esReciente(String anioActual) {
        if (fechaPublicacion != null && fechaPublicacion.length() >= 4) {
            String anioPublicacion = fechaPublicacion.substring(fechaPublicacion.length() - 4);
            try {
                return Integer.parseInt(anioPublicacion) >= (Integer.parseInt(anioActual) - 1);
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear el año de publicacion o actual: " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
