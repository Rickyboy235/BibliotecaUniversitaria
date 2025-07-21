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
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class VisualizarMaterial {

    private final Connection conn;
    private final CConexion conexion;
    Scanner teclado = new Scanner(System.in);
    public VisualizarMaterial() {        
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
    }
    
    
    public ArrayList<Libro> listLibros(){
        ArrayList<Libro> listaLibros = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();            
            ResultSet rs = stmt.executeQuery("SELECT b.codMaterial, a.ISBN, b.titulo, b.autor, a.volumen, a.editorial, "
                    + " b.idioma, b.añoPubli FROM Bibliografico b INNER JOIN Libro a "
                    + "ON a.codMaterial = b.codMaterial");
            while (rs.next()){
               Libro libro = Libro.fromResultSet(rs);
               listaLibros.add(libro);                
            }   
        } catch (Exception e) {
            System.out.println("error al obtener libros: " + e.getMessage());
        } 
      return listaLibros;
    }

    public ArrayList<Revista> listRevistas(){
        ArrayList<Revista> listaRevistas = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.codMaterial, b.titulo, b.autor, a.volumen, b.idioma, a.editorial, b.añoPubli"
                    + " FROM Bibliografico b INNER JOIN Revista a ON a.codMaterial = b.codMaterial");
            while (rs.next()){
                Revista revista = Revista.fromResultSet(rs);
                listaRevistas.add(revista);                
            }
        } catch (Exception e) {
            System.out.println("error al obtener revistas: " + e.getMessage());
        } 
        return listaRevistas;
    }
    public ArrayList<Tesis> listTesis(){
        ArrayList<Tesis> listaTesis = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.codMaterial, b.titulo, b.autor, a.carrera, a.universidad, a.grado, b.idioma, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Tesis a ON a.codMaterial = b.codMaterial");
            while (rs.next()){
                Tesis tesis = Tesis.fromResultSet(rs);
                listaTesis.add(tesis);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } 
        return listaTesis;
    }
    public ArrayList<Video> listVideos(){
        ArrayList<Video> listaVideos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.codMaterial, b.titulo, b.autor, a.duracion, b.idioma, a.resolucion, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Video a ON a.codMaterial = b.codMaterial");
            while(rs.next()){
                Video video = Video.fromResultSet(rs);
                listaVideos.add(video);
            }
            
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } 
        return listaVideos;
    }
    public ArrayList<AudioLibro> listALibro(){
        ArrayList<AudioLibro> listaALibro = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.codMaterial, b.titulo, b.autor, a.duracion, b.idioma, a.duracion, a.formato, b.añoPubli "
                    + "FROM Bibliografico b INNER JOIN Audiolibro a ON a.codMaterial = b.codMaterial");
            while(rs.next()){
                AudioLibro aLibro = AudioLibro.fromResultSet(rs);
                listaALibro.add(aLibro);
            }           
            
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } 
        return listaALibro;
    }
    public ArrayList<DispositivoElectronico> listDElec(){
    ArrayList<DispositivoElectronico> listaDElectronico = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT e.codMaterial, e.tipoDisp, e.marca, e.modelo, e.tarjGrafica, e.RAM,"
                    + " e.sistOperativo FROM Electronico e");
            while (rs.next()){
                DispositivoElectronico DElec = DispositivoElectronico.fromResultSet(rs);
                listaDElectronico.add(DElec);
            }
        } catch (Exception e) {
            System.out.println("error al obtener Dispositivo electronico: " + e.getMessage());
        } 
        return listaDElectronico;
    }
      public Libro matSelecLibro(ArrayList<Libro> listaLibros){               
        try {

        System.out.print("Ingrese el índice del libro que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaLibros.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        Libro libroSeleccionado = listaLibros.get(indiceSeleccionado - 1);
        System.out.println("\n Libro seleccionado:");
        System.out.println("-".repeat(160));
        System.out.printf("| %-17s | %-33s | %-28s | %-10s | %-18s | %-8s | %-15s |\n",
                "ISBN","TITULO","AUTOR","VOLUMEN","EDITORIAL",
                "IDIOMA","AÑO PUBLICACION");
        System.out.println("-".repeat(160));
        libroSeleccionado.mostrarDatos();
        System.out.println("-".repeat(160));
        return libroSeleccionado;
    } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }

    }
      
    public Revista matSelecRevista(ArrayList<Revista> listaRevista){
        try {

        System.out.print("Ingrese el índice de la revista que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaRevista.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        Revista revistaSeleccionado = listaRevista.get(indiceSeleccionado - 1);
        System.out.println("\n Revista seleccionada:");
        System.out.println("-".repeat(160));
        System.out.printf("| %-33s | %-28s | %-10s | %-18s | %-32s | %-15s |\n",
                    "TITULO","AUTOR","VOLUMEN","IDIOMA",
                    "EDITORIAL","AÑO PUBLICACION");
        System.out.println("-".repeat(160));
        revistaSeleccionado.mostrarDatos();
        System.out.println("-".repeat(160));
        return revistaSeleccionado;
        } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }
    }
    
    public Tesis matSelecTesis(ArrayList<Tesis> listaTesis){
        try {

        System.out.print("Ingrese el índice de la tesis que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaTesis.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        Tesis tesisSeleccionada = listaTesis.get(indiceSeleccionado - 1);
        System.out.println("\n Tesis seleccionada:");
        System.out.println("-".repeat(160));
        System.out.printf("| %-40s | %-19s | %-28s | %-46s | %-24s | %-10s | %-15s |\n",
                    "TITULO","AUTOR","CARRERA","UNIVERSIDAD",
                    "GRADO","IDIOMA","AÑO PUBLICACION");
        System.out.println("-".repeat(160));
        tesisSeleccionada.mostrarDatos();
        System.out.println("-".repeat(160));
        return tesisSeleccionada;
        } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }
    }
    
    public Video matSelecVideo(ArrayList<Video> listaVideo){
        try {

        System.out.print("Ingrese el índice del video que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaVideo.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        Video videoSeleccionado = listaVideo.get(indiceSeleccionado - 1);
        System.out.println("\n Video seleccionado:");
        System.out.println("-".repeat(160));
        System.out.printf("| %-25s | %-32s | %-10s | %-18s | %-12s | %-15s |\n",
                    "TITULO","AUTOR","DURACION","IDIOMA",
                    "RESOLUCION","AÑO PUBLICACION");
        System.out.println("-".repeat(160));
        videoSeleccionado.mostrarDatos();
        System.out.println("-".repeat(160));
        return videoSeleccionado;
        } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }
    }
    
    public AudioLibro matSelecALibro(ArrayList<AudioLibro> listaAudioLibro){
        try {

        System.out.print("Ingrese el índice del AudioLibro que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaAudioLibro.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        AudioLibro ALibroSeleccionado = listaAudioLibro.get(indiceSeleccionado - 1);
        System.out.println("\n AudioLibro seleccionado:");
        System.out.println("-".repeat(133));
        System.out.printf("| %-25s | %-34s | %-10s | %-18s | %-12s | %-15s |\n",
                    "TITULO","AUTOR","DURACION","IDIOMA",
                    "FORMATO","AÑO PUBLICACION");
            System.out.println("-".repeat(133));
        ALibroSeleccionado.mostrarDatos();
        System.out.println("-".repeat(160));
        return ALibroSeleccionado;
        } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }
    }
    
    public DispositivoElectronico matSelecDispElec(ArrayList<DispositivoElectronico> listaDispElect){
        try {

        System.out.print("Ingrese el índice del Dispositivo Electronico que desea seleccionar: ");
        int indiceSeleccionado = teclado.nextInt();

        // Validación
        if (indiceSeleccionado < 1 || indiceSeleccionado > listaDispElect.size()) {
            System.out.println("Índice ingresado es incorrecto.");
            return null;
        }
        DispositivoElectronico DElectronicoSeleccionado = listaDispElect.get(indiceSeleccionado - 1);
        System.out.println("\n Dispositivo seleccionado:");
        System.out.println("-".repeat(113));
        System.out.printf("| %-10s | %-10s | %-28s | %-16s | %-6s | %-24s |\n",
                    "TIPO DISP","MARCA","MODELO","TARJETA GRAFICA","RAM",
                    "SIST. OPERATIVO");
            System.out.println("-".repeat(113));
        DElectronicoSeleccionado.mostrarDatos();
        System.out.println("-".repeat(160));
        return DElectronicoSeleccionado;
        } catch (Exception e) {
            System.out.println("error al ejecutar material seleccionado: " + e.getMessage());
            return null;
        } 
        finally {
            conexion.cerrarConexion();
        }
    }
    
    
      public void cerrarConexion(){
        try {
            
        } finally {
            conexion.cerrarConexion();
        }
    }
      
}      
