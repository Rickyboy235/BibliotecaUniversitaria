/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
// Subclase Multimedia
 class Multimedia extends MaterialBibliografico {
    private String formato;
    public Multimedia(String titulo, String autor, String formato) {
        super(titulo, autor);
        this.formato = formato;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Formato: " + formato);
    }
}
