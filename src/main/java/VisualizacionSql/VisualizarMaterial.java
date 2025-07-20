/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
import com.mycompany.sp1.Tesis;
import com.mycompany.sp1.Video;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ATKZ
 */
public class VisualizarMaterial {
    /**
     * PARECE QUE ACABE CON ESTA CLASE
     */
    private final Connection conn;
    private final CConexion conexion;

    public VisualizarMaterial() {        
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
    }
    
    
    public ArrayList<Libro> listLibros(){
        ArrayList<Libro> listaLibros = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("SELECT a.ISBN, b.titulo, b.autor, a.volumen, a.editorial, "
                    + " b.idioma, b.añoPubli FROM Bibliografico b INNER JOIN Libro a "
                    + "ON a.codMaterial = b.codMaterial");
            while (rs.next()){
               String ISBN = rs.getString("ISBN");
               String titulo = rs.getString("titulo");
               String autor = rs.getString("autor");
               int volumen = rs.getInt("volumen");
               String editorial = rs.getString("editorial");
               String idioma = rs.getString("idioma");
               int añoPub = rs.getInt("añoPubli");
               
                
               Libro libro = new Libro(ISBN, titulo, autor, volumen, editorial, idioma, añoPub);
               listaLibros.add(libro);
                
            }   
        } catch (Exception e) {
            System.out.println("error al obtener libros: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
      return listaLibros;
    }

    public ArrayList<Revista> listRevistas(){
        ArrayList<Revista> listaRevistas = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.titulo, b.autor, a.volumen, b.idioma, a.editorial, b.añoPubli"
                    + " FROM Bibliografico b INNER JOIN Revista a ON a.codMaterial = b.codMaterial");
            while (rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                int volumen = rs.getInt("volumen");
                String idioma = rs.getString("idioma");
                String editorial = rs.getString("editorial");
                int añoPub = rs.getInt("añoPubli");
                
                Revista revista = new Revista(titulo, autor, volumen, idioma, editorial, añoPub);
                listaRevistas.add(revista);
            }
        } catch (Exception e) {
            System.out.println("error al obtener revistas: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaRevistas;
    }
    public ArrayList<Tesis> listTesis(){
        ArrayList<Tesis> listaTesis = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.titulo, b.autor, a.carrera, a.universidad, a.grado, b.idioma, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Tesis a ON a.codMaterial = b.codMaterial");
            while (rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String carrera = rs.getString("carrera");
                String universidad = rs.getString("universidad");
                String grado = rs.getString("grado");
                String idioma = rs.getString("idioma");
                int añoPub = rs.getInt("añoPubli");
                
                Tesis tesis = new Tesis(titulo, autor, carrera, universidad, grado, idioma, añoPub);
                listaTesis.add(tesis);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaTesis;
    }
    public ArrayList<Video> listVideos(){
        ArrayList<Video> listaVideos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.titulo, b.autor, a.duracion, b.idioma, a.resolucion, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Video a ON a.codMaterial = b.codMaterial");
            while(rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String duracion = rs.getString("duracion");
                String idioma = rs.getString("idioma");
                String resolucion = rs.getString("resolucion");
                int añoPub = rs.getInt("añoPubli");
                
                Video video = new Video(titulo, autor, duracion, idioma, resolucion, añoPub);
                listaVideos.add(video);
            }
            
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaVideos;
    }
    public ArrayList<AudioLibro> listALibro(){
        ArrayList<AudioLibro> listaALibro = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.titulo, b.autor, a.duracion, b.idioma, a.duracion, a.formato, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Audiolibro a ON a.codMaterial = b.codMaterial");
            while(rs.next()){
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                String duracion = rs.getString("duracion");
                String idioma = rs.getString("idioma");
                String formato = rs.getString("formato");
                int añoPub = rs.getInt("añoPubli");
                
                AudioLibro audioLibro = new AudioLibro(titulo, autor, duracion, idioma, formato, añoPub);
                listaALibro.add(audioLibro);
            }           
            
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaALibro;
    }
    public ArrayList<DispositivoElectronico> listDElec(){
    ArrayList<DispositivoElectronico> listaDElectronico = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT e.tipoDisp, e.marca,e.modelo, e.tarjGrafica, e.RAM,"
                    + " e.sistOperativo FROM Electronico e");
            while (rs.next()){
                String tipoDisp = rs.getString("tipoDisp");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String tarjGrafica = rs.getString("tarjGrafica");
                int RAM = rs.getInt("RAM");
                String sisOperativo = rs.getString("sistOperativo");
                DispositivoElectronico dispElec = new DispositivoElectronico(tipoDisp, marca, modelo, 
                        tarjGrafica, RAM,sisOperativo);
                listaDElectronico.add(dispElec);
            }
        } catch (Exception e) {
            System.out.println("error al obtener Dispositivo electronico: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaDElectronico;
    }
}    


/*    public void mostrarRevista(ArrayList<Revista> listaRevista){
        
    }
}
/*    public void mostrarLibros(ArrayList<Libro> listaLibros){
        System.out.println("-".repeat(151));
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s |\n",
                    "ISBN","TITULO","AUTOR","VOLUMEN","EDITORIAL",
                    "IDIOMA","AÑO PUBLICACION");
            System.out.println("-".repeat(151));
            for (Libro libro : listaLibros) {
            libro.mostrarDatos();
        }
            System.out.println("-".repeat(151));
    }
*/  
