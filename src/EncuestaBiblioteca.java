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
public class EncuestaBiblioteca {
    private String titulo;
    private List<Integer> respuestas;
    
    public EncuestaBiblioteca(String titulo) {
        this.titulo = titulo;
        this.respuestas = new ArrayList<>();
    }
    public void agregarRespuesta(int r) {
        if(r >= 1 && r <= 5) {
            respuestas.add(r);
        } else {
            System.out.println("Respuesta inválida. debe ser entre 1 y 5.");
        }
    }
    public double promedioRespuestas() {
        if(respuestas.isEmpty()) return 0.0;
        int suma = 0;
        for(int r : respuestas) {
            suma += r;
        }
        return (double) suma / respuestas.size();
    }
    public int contarVotos(int valor) {
        int conteo = 0;
        for(int r : respuestas) {
            if(r == valor) conteo++;
        }
        return conteo;
    }
    public void mostrarResumen() {
        System.out.println("Resumen de la Encuesta: " + titulo);
        for(int i = 1; i <= 5; i++) {
            System.out.println("Votos con valor " + i + ": " + contarVotos(i));
        }
        System.out.println("Promedio de respuestas: " + promedioRespuestas());
    }
}
