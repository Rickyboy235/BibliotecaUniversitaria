/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsercionSql;

import Credenciales.LoginUsuario;
import VisualizacionSql.VisualizarMaterial;
import com.mycompany.sp1.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class InsercionSolicitud {
    
    private final Connection conn;
    
    public InsercionSolicitud(Connection conn) {
        this.conn = conn;
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

    public String generarCodSolicitud() {
    String nuevoCodigo = "SOL001"; // Valor inicial si no hay registros
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT codSolicitud FROM Solicitud ORDER BY codSolicitud DESC LIMIT 1");

        if (rs.next()) {
            String ultimoCodigo = rs.getString("codSolicitud"); // Ej: SOL007
            int numero = Integer.parseInt(ultimoCodigo.substring(3)); // Extrae 007 y lo convierte en 7
            numero++; // Incrementa

            // Formatea el nuevo código con ceros a la izquierda
            nuevoCodigo = String.format("SOL%03d", numero); // Ej: SOL008
        }
    } catch (Exception e) {
        System.out.println("⚠ Error al generar código: " + e.getMessage());
    } 
    return nuevoCodigo;
    }
    
    
    public void insertarSolicitud(LoginUsuario logUsu) {
    try {
        String sql = "INSERT INTO Solicitud (codSolicitud, codUsuario, codPers, tipoSolicitud, fechaSolicitud, "
                + "estadoSolicitud) VALUES (?, ?, 'por confirmar','prestamo', CURRENT_TIMESTAMP , ?)";

        PreparedStatement psSolicitud = conn.prepareStatement(sql);
        
        // Asignamos los valores
        psSolicitud.setString(1, generarCodSolicitud());
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
     
}
            

