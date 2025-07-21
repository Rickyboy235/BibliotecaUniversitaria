/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsercionSql;

import Credenciales.LoginUsuario;
import VisualizacionSql.VisualizarMaterial;
import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.Computadora;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
import com.mycompany.sp1.Sala;
import com.mycompany.sp1.Tesis;
import com.mycompany.sp1.Video;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ATKZ
 */
public class InsercionSolicitud {
    private String codSoli;
    private final Connection conn;
    
    public InsercionSolicitud(Connection conn) {
        this.conn = conn;
    }

    
    public String obtenerFecha(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = ahora.format(formato);
        return fechaHoraFormateada;
    }
    
    public String fechaCalculada(){
        LocalDateTime ahora = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaCal = ahora.format(formato);
        return fechaCal;
    }
    
    public String obtenerHora(){
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaHoraFormateada = ahora.format(formato);
        return fechaHoraFormateada;
    }
    
    public String horaCalculada(){
        LocalDateTime ahora = LocalDateTime.now().plusHours(4);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaCal = ahora.format(formato);
        return fechaCal;        
    }
    
    public void insertarDatosRegistro(int eleccionMaterial, Scanner teclado /*bandera catalogo??*/){
        switch(eleccionMaterial){
            case 1 ->{
                //visualizar el material
                VisualizarMaterial vmat = new VisualizarMaterial();
                        Libro lib = new Libro();                        
                        lib.mostrarRegistros(vmat.listLibros());
                //banderaCatalogo = false;
                System.out.println("ingrese el numero de indice del material que"
                        + " desee prestar");
                int eleccionIndice = teclado.nextInt();
                //insercion de nuevo prestamo
                
                
            }
        }
        
        
    }

    public String generarCodPrestamo() {
        
                    String nuevoCodigo = "PTM001"; // Valor inicial si no hay registros
                     try {
                         Statement stmt = conn.createStatement();
                         ResultSet rs = stmt.executeQuery("SELECT codSolicitud FROM Solicitud "
                                 + "WHERE codSolicitud LIKE 'PTM%' ORDER BY codSolicitud DESC LIMIT 1");

                         if (rs.next()) {
                             String ultimoCodigo = rs.getString("codSolicitud"); // Ej: SOL007
                             int numero = Integer.parseInt(ultimoCodigo.substring(3)); // Extrae 007 y lo convierte en 7
                             numero++; // Incrementa

                             // Formatea el nuevo código con ceros a la izquierda
                             nuevoCodigo = String.format("PTM%03d", numero); // Ej: SOL008
                         }
                     } catch (Exception e) {
                         System.out.println("Error al generar código: " + e.getMessage());
                     } 
                     obtenerCodSoli(nuevoCodigo);
                     return nuevoCodigo;                                       
        
    }
    
    public String generrarCodReserva(){
        String nuevoCodigo = "RSV001"; // Valor inicial si no hay registros
                try {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT codSolicitud FROM "
                            + "Solicitud WHERE codSolicitud LIKE 'RSV%'ORDER BY codSolicitud DESC LIMIT 1");

                    if (rs.next()) {
                        String ultimoCodigo = rs.getString("codSolicitud"); // Ej: SOL007
                        int numero = Integer.parseInt(ultimoCodigo.substring(3)); // Extrae 007 y lo convierte en 7
                        numero++; // Incrementa
                        // Formatea el nuevo código con ceros a la izquierda
                        nuevoCodigo = String.format("RSV%03d", numero); // Ej: SOL008
                    }
                } catch (Exception e) {
                    System.out.println("Error al generar código: " + e.getMessage());
                } 
                obtenerCodSoli(nuevoCodigo);
                return nuevoCodigo;
    }
    
    public void obtenerCodSoli(String nuevoCodigo){
        codSoli = nuevoCodigo;        
    }
    
    public void insertarSolicitud(LoginUsuario logUsu) {
        
        try {
            String sql = "INSERT INTO Solicitud (codSolicitud, codUsuario, codPers, tipoSolicitud, fechaSolicitud, "
                    + "estadoSolicitud) VALUES (?, ?, 'por confirmar','prestamo', CURRENT_TIMESTAMP , ?)";

            PreparedStatement psSolicitud = conn.prepareStatement(sql);
            // Asignamos los valores
                psSolicitud.setString(1, generarCodPrestamo());
                psSolicitud.setString(2, logUsu.getCodigo());
                psSolicitud.setString(3, "en espera");
                int filas = psSolicitud.executeUpdate();
                    if (filas > 0) {
                        System.out.println("Solicitud registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la solicitud.");
                    }
        } catch (Exception e) {
            System.out.println(" Error al insertar la solicitud: " + e.getMessage());
        } 
    }
    
    public void insertarSolResev(LoginUsuario logUsu){
        try {
            String sql = "INSERT INTO Solicitud (codSolicitud, codUsuario, codPers, tipoSolicitud, fechaSolicitud, "
                    + "estadoSolicitud) VALUES (?, ?, 'por confirmar','reserva', CURRENT_TIMESTAMP , ?)";

            PreparedStatement psSolicitud = conn.prepareStatement(sql);
            // Asignamos los valores
                psSolicitud.setString(1, generrarCodReserva());
                psSolicitud.setString(2, logUsu.getCodigo());
                psSolicitud.setString(3, "en espera");
                int filas = psSolicitud.executeUpdate();
                    if (filas > 0) {
                        System.out.println("Solicitud registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la solicitud.");
                    }
        } catch (Exception e) {
            System.out.println(" Error al insertar la solicitud: " + e.getMessage());
        } 
    }
    
    public void prestamoLibro(int opcionEleg, Libro lib){
         try {
             String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psPrestLibro = conn.prepareStatement(sql);
             
                psPrestLibro.setString(1, codSoli);
                psPrestLibro.setString(2, lib.getCodMaterial());
                psPrestLibro.setString(3, obtenerFecha());
                psPrestLibro.setString(4, fechaCalculada());
            int filas = psPrestLibro.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar la Prestamo: " + e.getMessage());
        } 
     }
     
    public void prestamoRevista(int opcionEleg, Revista rev){
         try {
             String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psRev = conn.prepareStatement(sql);
             
                psRev.setString(1, codSoli);
                psRev.setString(2, rev.getCodMaterial());
                psRev.setString(3, obtenerFecha());
                psRev.setString(4, fechaCalculada());
            int filas = psRev.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar la Prestamo: " + e.getMessage());
        } 
     }
    
    public void prestamoTesis(int opcionEleg, Tesis tes){
         try {
             String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psTesis = conn.prepareStatement(sql);
             
                psTesis.setString(1, codSoli);
                psTesis.setString(2, tes.getCodMaterial());
                psTesis.setString(3, obtenerFecha());
                psTesis.setString(4, fechaCalculada());
            int filas = psTesis.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar la Prestamo: " + e.getMessage());
        } 
     }
    
    public void prestamoVideo(int opcionEleg, Video vid){
         try {
             String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psVid = conn.prepareStatement(sql);
             
                psVid.setString(1, codSoli);
                psVid.setString(2, vid.getCodMaterial());
                psVid.setString(3, obtenerFecha());
                psVid.setString(4, fechaCalculada());
            int filas = psVid.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar la Prestamo: " + e.getMessage());
        } 
     }
    
    public void prestamoALibro(int opcionEleg, AudioLibro alib){
         try {
             String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psALib = conn.prepareStatement(sql);
             
                psALib.setString(1, codSoli);
                psALib.setString(2, alib.getCodMaterial());
                psALib.setString(3, obtenerFecha());
                psALib.setString(4, fechaCalculada());
            int filas = psALib.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar la Prestamo: " + e.getMessage());
        } 
     }
    
    public void prestamoDispElectronico(int opcionEleg, DispositivoElectronico disElec){
        try {
            String sql = "INSERT INTO Prestamo (idPrestamo, codMaterial, "
                     + "fecPrestamo, catDias, fecDevolucion, fecEntrega, "
                     + "estadoPrestamo, observaciones) VALUES(?,?,?,7,?,null,'en prestamo',null)";
             PreparedStatement psDisElec = conn.prepareStatement(sql);
             
                psDisElec.setString(1, codSoli);
                psDisElec.setString(2, disElec.getCodMaterial());
                psDisElec.setString(3, obtenerFecha());
                psDisElec.setString(4, fechaCalculada());
            int filas = psDisElec.executeUpdate(); 
            if (filas > 0) {
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el préstamo.");
        }
         } catch (Exception e) {
            System.out.println("Error al insertar Prestamo: " + e.getMessage());
        } 
    }
    
    public void reservaSala(Sala sala){
        try {
            String sql = "INSERT INTO Reservas (idReserva, "
                    + "codServicio, codServicio, horaInicio, horaFin, cantHoras, estadoReserva)"
                    + "VALUES(?,?,?,?,?,4,'en reserva')";
            PreparedStatement psSala = conn.prepareStatement(sql);
            psSala.setString(1, codSoli);
            psSala.setString(2, sala.getCodSala());
            psSala.setString(3, obtenerFecha());
            psSala.setString(4, obtenerHora());
            psSala.setString(5, horaCalculada());
            int filas = psSala.executeUpdate();
            if (filas > 0) {
                System.out.println("reserva registrada correctamente");
            }else{
                System.out.println("no se pudo registrar la reserva");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar Reserva: " +e.getMessage());
        }
    }
    
    public void reservaComputadora(Computadora computadora){
        try {
            String sql = "INSERT INTO Reservas (idReserva, "
                    + "codServicio, codServicio, horaInicio, horaFin, cantHoras, estadoReserva)"
                    + "VALUES(?,?,?,?,?,4,'en reserva')";
            PreparedStatement psCompu = conn.prepareStatement(sql);
                psCompu.setString(1, codSoli);
                psCompu.setString(2, computadora.getCodComp());
                psCompu.setString(3, obtenerFecha());
                psCompu.setString(4, obtenerHora());
                psCompu.setString(5, horaCalculada());                
        int filas = psCompu.executeUpdate();
            if (filas > 0) {
                System.out.println("reserva registrada correctamente");
            }else{
                System.out.println("no se pudo registrar la reserva");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar Reserva: " +e.getMessage());
        }
    }
}