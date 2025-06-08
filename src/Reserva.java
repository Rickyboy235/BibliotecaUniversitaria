/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Reserva {
    private String codigoReserva;
    private String fecha;
    private String hora;
    public Reserva(String codigoReserva, String fecha, String hora) {
        this.codigoReserva = codigoReserva;
        this.fecha = fecha;
        this.hora = hora;       
    }
    public String getCodigoReserva() {
        return codigoReserva;
    }
    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
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
    public void mostrarInfo() {
        System.out.println("CodigoReserva: " + codigoReserva);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }   
}
