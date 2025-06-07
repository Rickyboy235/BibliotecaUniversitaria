/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class EventoBiblioteca {
    private String titulo;
    private String idEvento;
    private String descripcion;
    private String fecha;
    private String hora;
    private String lugar;
    private int capacidad;
    private ArrayList<Usuario> inscritos;
    
    public EventoBiblioteca(String titulo, String idEvento, String descripcion, String fecha, String hora, String lugar, int capacidad) {
        this.titulo = titulo;
        this.idEvento = idEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.capacidad = capacidad;
        this.inscritos = new ArrayList();
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setIdEvento(int capacidad) {
        this.capacidad = capacidad;
    }
   public void inscribirUsuario(Usuario u) {
        if (inscritos.size() < capacidad) {
            inscritos.add(u);
            System.out.println(u.getNombre() + " ha sido inscrito exitosamente al evento.");
        } else {
            System.out.println("No hay cupos disponibles para este evento.");
        }
   }
    public void cancelarEvento() {
        if(idEvento.equalsIgnoreCase("NULL")) {
            System.out.println("El evento ha sido cancelado");
        }
        else
        {
         System.out.println("El evento comienza el" + getFecha());   
        }
            
    }
     public void verListaInscritos() {
        System.out.println("Lista de usuarios inscritos:");
        for (Usuario u : inscritos) {
            System.out.println("- " + u.getNombre() + " (ID: " + u.getId() + ")");
        }
    }
}

