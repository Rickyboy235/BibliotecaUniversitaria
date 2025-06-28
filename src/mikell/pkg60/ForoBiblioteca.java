package main.pkg60;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @Mikell
 */
public class ForoBiblioteca {
    private String tema;
    private String idForo;
    private List<MensajeForo> mensajes;
    private boolean activo;

    public ForoBiblioteca(String idForo, String tema) {
        this.idForo = idForo;
        this.tema = tema;
        this.mensajes = new ArrayList<>();
        this.activo = true;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getIdForo() {
        return idForo;
    }

    public void setIdForo(String idForo) {
        this.idForo = idForo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void agregarMensaje(String contenido, Usuario autor) {
        if (activo) {
            MensajeForo nuevoMensaje = new MensajeForo(contenido, autor);
            this.mensajes.add(nuevoMensaje);
            System.out.println("Mensaje agregado al foro '" + this.tema + "' por " + autor.getNombre() + ".");
        } else {
            System.out.println("El foro '" + this.tema + "' no esta activo y no se pueden agregar mensajes.");
        }
    }

    public List<MensajeForo> obtenerMensajes() {
        System.out.println("\n--- Mensajes del Foro: " + this.tema + " ---");
        if (mensajes.isEmpty()) {
            System.out.println("No hay mensajes en este foro.");
        } else {
            for (MensajeForo msg : mensajes) {
                System.out.println("Fecha: " + msg.getFechaHora() + " | Autor: " + msg.getAutor().getNombre() + " | Mensaje: " + msg.getContenido());
            }
        }
        return new ArrayList<>(this.mensajes);
    }

    public List<MensajeForo> buscarMensajes(String palabraClave) {
        List<MensajeForo> resultados = new ArrayList<>();
        System.out.println("\n--- Buscando mensajes con '" + palabraClave + "' en el foro '" + this.tema + "' ---");
        for (MensajeForo msg : mensajes) {
            if (msg.getContenido().toLowerCase().contains(palabraClave.toLowerCase())) {
                resultados.add(msg);
            }
        }
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron mensajes con la palabra clave.");
        } else {
            System.out.println("Mensajes encontrados:");
            for (MensajeForo msg : resultados) {
                System.out.println("Fecha: " + msg.getFechaHora() + " | Autor: " + msg.getAutor().getNombre() + " | Mensaje: " + msg.getContenido());
            }
        }
        return resultados;
    }

    private class MensajeForo {
        private String contenido;
        private Usuario autor;
        private String fechaHora;

        public MensajeForo(String contenido, Usuario autor) {
            this.contenido = contenido;
            this.autor = autor;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            this.fechaHora = sdf.format(new Date());
        }

        public String getContenido() {
            return contenido;
        }

        public Usuario getAutor() {
            return autor;
        }

        public String getFechaHora() {
            return fechaHora;
        }
    }
}