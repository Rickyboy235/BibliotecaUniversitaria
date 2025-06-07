/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class AdministradorSistema {
    public void asignarPenalidad(Usuario u, Penalidad p) {
        System.out.println("Asignando penalidad a: " + u.getNombre());
        System.out.println("Razón: " + p.getRazon());
    }

    public void agregarCategoria(Categoria c) {
        System.out.println("Categoría: " + c.getNombre());
    }

    public void crearEvento(EventoBiblioteca e) {
        System.out.println("Evento: " + e.getTitulo());
    }

    public void gestionarSugerencia(SugerenciaMaterial s) {
        System.out.println("Sugerencia: " + s.getDescripcion());
    }
}
