/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Penalidad {
    private String razon;
    private String idPenalidad;
    private String fecha;
    private double monto;
    private String estado;

    public Penalidad(String razon, String idPenalidad, String fecha, double monto, String estado) {
        this.razon = razon;
        this.idPenalidad = idPenalidad;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    } 
    public String getIdPenalidad() {
        return idPenalidad;
    }
    public void setIdPenalidad(String idPenalidad) {
        this.idPenalidad = idPenalidad;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto= monto;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void calcularMontoTotal() {
        if (razon.equalsIgnoreCase("perdida")) {
            monto += 50;
        } 
        else 
            if (razon.equalsIgnoreCase("retraso")) {
            monto += 25;
        } 
            else 
            {
            monto += 30; // Para otros motivos
        }
    }
    public void marcarComoPagado() {
    if (estado.equalsIgnoreCase("Pagado")) {
        System.out.println("Pago realizado exitosamente.");
        }
    else
        System.out.println("El pago sigue pendiente");
    }
    public void anularPenalidad() {
        if(estado.equalsIgnoreCase("Pagado")) {
            System.out.println("Penalidad Absuelta");
        }
        else
            System.out.println("Penalidad vigente");
    }
    public void mostrarInfo() {
        System.out.println("IdPenalidad: " + idPenalidad);
        System.out.println("Fecha: " + fecha);
        System.out.println("Monto: " + monto);
        System.out.println("Estado: " + estado);
    }
}
