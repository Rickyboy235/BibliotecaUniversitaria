/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Categoria {
    private String nombre;
    private String idCategoria;
    private String descripcion;
    public Categoria(String nombre, String idCategoria, String descripcion) {
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void mostrarInfo() {
        System.out.println("IdCategoria: " + idCategoria);
        System.out.println("Descripcion: " + descripcion);
    }
}

