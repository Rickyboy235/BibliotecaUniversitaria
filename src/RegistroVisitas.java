/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class RegistroVisitas {
    private int numeroVisita;
    private String fecha;
    private List<String> observaciones;
    private List<String> actividadesRealizadas;
    
    public RegistroVisitas(int numeroVisita, String fecha) {
        this.numeroVisita = numeroVisita;
        this.fecha = fecha;
        this.observaciones = new ArrayList<>();
        this.actividadesRealizadas = new ArrayList<>();
    }
    public int getNumeroVisita() {
        return numeroVisita;
    }
    public void setnumeroVisita(int numeroVisita) {
        this.numeroVisita = numeroVisita;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void agregarObservacion(String obs) {
        observaciones.add(obs);
    }
    public void agregarActividad(String act) {
        actividadesRealizadas.add(act);
    }
    public List<String> getObservacion() {
        return observaciones;
    }
    public List<String> getActividadesRealizadas() {
        return actividadesRealizadas;
    }
}
