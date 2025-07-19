/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Servicio {
    private String codServicio;
    private String tipoServicio;
    
    public Servicio(String codServicio, String tipoServicio) {
        this.codServicio = codServicio;
        this.tipoServicio = tipoServicio;  
    }
    public String getCodServicio() {
        return codServicio;
    }
    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }
    public String getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public void mostrarInfo() {
        System.out.println("CodServicio: " + codServicio);
        System.out.println("Tipo de Servicio: " + tipoServicio);
    }
}
