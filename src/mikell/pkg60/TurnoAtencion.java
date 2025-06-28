package main.pkg60;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @Mikell
 */
public class TurnoAtencion {
    private String idTurnoAtencion;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private int capacidadMaxima;
    private List<Usuario> turnosAsignados;
    private String estado;

    public TurnoAtencion(String idTurnoAtencion, String fecha, String horaInicio, String horaFin, int capacidadMaxima) {
        this.idTurnoAtencion = idTurnoAtencion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.capacidadMaxima = capacidadMaxima;
        this.turnosAsignados = new ArrayList<>();
        this.estado = "Programado";
    }

    public String getIdTurnoAtencion() {
        return idTurnoAtencion;
    }

    public void setIdTurnoAtencion(String idTurnoAtencion) {
        this.idTurnoAtencion = idTurnoAtencion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void agregarAlumno(Usuario usuario) {
        if (estado.equals("Programado") && turnosAsignados.size() < capacidadMaxima) {
            if (!turnosAsignados.contains(usuario)) {
                this.turnosAsignados.add(usuario);
                System.out.println("Usuario " + usuario.getNombre() + " asignado exitosamente al turno " + idTurnoAtencion + ".");
            } else {
                System.out.println("El usuario " + usuario.getNombre() + " ya esta registrado en este turno.");
            }
        } else if (turnosAsignados.size() >= capacidadMaxima) {
            System.out.println("No hay cupos disponibles para el turno " + idTurnoAtencion + ".");
        } else {
            System.out.println("El turno " + idTurnoAtencion + " no esta en estado 'Programado'. Estado actual: " + estado + ".");
        }
    }

    public void eliminarAlumno(Usuario usuario) {
        if (turnosAsignados.remove(usuario)) {
            System.out.println("Usuario " + usuario.getNombre() + " eliminado del turno " + idTurnoAtencion + ".");
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " no se encontro en el turno " + idTurnoAtencion + ".");
        }
    }

    public List<Usuario> listarTurnos() {
        System.out.println("\n--- Usuarios asignados al Turno " + idTurnoAtencion + " (" + fecha + " " + horaInicio + "-" + horaFin + ") ---");
        System.out.println("Estado: " + estado + " | Cupos: " + turnosAsignados.size() + "/" + capacidadMaxima);

        if (turnosAsignados.isEmpty()) {
            System.out.println("No hay usuarios asignados a este turno.");
        } else {
            turnosAsignados.sort(Comparator.comparing(Usuario::getNombre));
            for (int i = 0; i < turnosAsignados.size(); i++) {
                Usuario usuario = turnosAsignados.get(i);
                System.out.println((i + 1) + ". " + usuario.getNombre() + " (ID: " + usuario.getId() + ")");
            }
        }
        return new ArrayList<>(this.turnosAsignados);
    }

    public void actualizarEstado(String nuevoEstado) {
        List<String> estadosValidos = List.of("Programado", "En Curso", "Finalizado", "Cancelado");
        if (estadosValidos.contains(nuevoEstado)) {
            this.estado = nuevoEstado;
            System.out.println("Estado del turno " + idTurnoAtencion + " actualizado a: " + nuevoEstado + ".");
        } else {
            System.out.println("Estado invalido: " + nuevoEstado + ". Los estados validos son: " + estadosValidos);
        }
    }
}