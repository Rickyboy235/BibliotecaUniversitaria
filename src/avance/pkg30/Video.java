/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avance.pkg30;

/**
 *
 * @Mikell
 */
public class Video extends Multimedia {
    private int duracionMinutos;
    private String director;

    public Video(String titulo, String autor, String formato, int duracionMinutos, String director) {
        super(titulo, autor, formato);
        this.duracionMinutos = duracionMinutos;
        this.director = director;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Video");
        System.out.println("Titulo: " + titulo);
        System.out.println("Productor/Compania: " + autor);
        System.out.println("Formato: " + formato);
        System.out.println("Director: " + director);
        System.out.println("Duracion: " + duracionMinutos + " minutos");
    }

    public String getDuracionFormateada() {
        int horas = duracionMinutos / 60;
        int minutosRestantes = duracionMinutos % 60;
        return String.format("%02d:%02d:00", horas, minutosRestantes);
    }
}
