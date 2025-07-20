/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ATKZ
 */
abstract class Material {
    /**
     * SUPERCLASE QUE SOLO SIRVE PARA CREAR JERARQUIA
     */
    protected String titulo;
    protected String autor;
    protected String idioma;
    protected int añoPub;    

    public Material() {
    }

    public Material(String titulo, String autor, String idioma, int añoPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.añoPub = añoPub;
    }
    public abstract void mostrarDatos();

    
    /*CConexion conexion = new CConexion();
    Connection conn = conexion.establecerConexion();
    public ArrayList<Material> visualizarLibros(){
        
        ArrayList<Material> listaLibros = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.ISBN, b.titulo, b.autor, b.idioma, "
                    + "b.añoPubli, a.volumen, a.editorial FROM Bibliografico b INNER JOIN Libro a "
                    + "ON a.codMaterial = b.codMaterial");
            System.out.printf("%-17s | %-33s | %-28s | %-10s | %-15s | %-8s | %-15s\n",
                    "ISBN","TITULO","AUTOR","IDIOMA","AÑO PUBLICACION",
                    "VOLUMEN","EDITORIAL");
            System.out.println("___________________________________________________");
            while (rs.next()){
                ISBN = rs.getString("ISBN");
                titulo = rs.getString("titulo");
                autor = rs.getString("autor");
                idioma = rs.getString("idioma");
                añoPub = rs.getString("añoPubli");
                volumen = rs.getString("volumen");
                editorial = rs.getString("editorial");
                
                Material material = new Material(ISBN, titulo, autor, añoPub, volumen, editorial);
                System.out.printf("%-17s | %-33s | %-28s | %-10s | %-15s | %-8s | %-15s\n",
                    ISBN, titulo, autor, idioma, añoPub, volumen, editorial);
            }                        
            
        } catch (Exception e) {
            System.out.println("error al mostrar: " + e.getMessage());
        } finally{
            conexion.cerrarConexion();
        }
        
    }

    
    public void visualizarRevistas(){
        
    }
    public void visualizarTesis(){
        
    }
    public void visualizarVideos(){
        
    }
    public void visualizarAudiolibros(){
        
    }*/
}
