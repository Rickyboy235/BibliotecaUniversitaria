/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avance.pkg30;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @Mikell
 */
public class Audiolibro extends Multimedia {
    private String narrador;
    private int duracionTotalMinutos; 
    private List<CapituloAudiolibro> capitulos; 

    public Audiolibro(String titulo, String autor, String formato, String narrador, int duracionTotalMinutos) {
        super(titulo, autor, formato); 
        this.narrador = narrador;
        this.duracionTotalMinutos = duracionTotalMinutos;
        this.capitulos = new ArrayList<>();
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public int getDuracionTotalMinutos() {
        return duracionTotalMinutos;
    }

    public void setDuracionTotalMinutos(int duracionTotalMinutos) {
        this.duracionTotalMinutos = duracionTotalMinutos;
    }

    public List<CapituloAudiolibro> getCapitulos() {
        return capitulos;
    }

    // Metodo para anadir un capitulo
    public void agregarCapitulo(String tituloCapitulo, int duracionCapituloMinutos) {
        capitulos.add(new CapituloAudiolibro(tituloCapitulo, duracionCapituloMinutos));
    }

    public String getDuracionTotalFormateada() {
        int horas = duracionTotalMinutos / 60;
        int minutosRestantes = duracionTotalMinutos % 60;
        return String.format("%02d:%02d:00", horas, minutosRestantes);
    }

    public void listarCapitulos() {
        if (capitulos.isEmpty()) {
            System.out.println("No hay capitulos definidos para este audiolibro.");
            return;
        }
        System.out.println("Capitulos de '" + titulo + "':");
        for (int i = 0; i < capitulos.size(); i++) {
            CapituloAudiolibro cap = capitulos.get(i);
            System.out.println("  " + (i + 1) + ". " + cap.getTitulo() + " (" + cap.getDuracionMinutos() + " min)");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Audiolibro");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor Original: " + autor);
        System.out.println("Formato: " + formato);
        System.out.println("Narrador: " + narrador);
        System.out.println("Duracion Total: " + getDuracionTotalFormateada());
        listarCapitulos();
    }

    private class CapituloAudiolibro {
        private String titulo;
        private int duracionMinutos;

        public CapituloAudiolibro(String titulo, int duracionMinutos) {
            this.titulo = titulo;
            this.duracionMinutos = duracionMinutos;
        }

        public String getTitulo() {
            return titulo;
        }

        public int getDuracionMinutos() {
            return duracionMinutos;
        }
    }
}
