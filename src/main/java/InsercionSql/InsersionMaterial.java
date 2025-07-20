/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InsercionSql;

import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
/*
public class InsersionMaterial {
    
    private final CConexion conexion;
    private final Connection conn;
    Scanner teclado = new Scanner(System.in);
    public InsersionMaterial() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
    }
    
    public String generarCodSolicitud() {
    String nuevoCodigo = "SOL001"; // Valor inicial si no hay registros
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT codMaterial FROM Material ORDER BY codMaterial DESC LIMIT 1");
        if (rs.next()) {
            String ultimoCodigo = rs.getString("codMaterial"); // Ej: SOL007
            int numero = Integer.parseInt(ultimoCodigo.substring(3)); // Extrae 007 y lo convierte en 7
            numero++; // Incrementa
            // Formatea el nuevo código con ceros a la izquierda
            nuevoCodigo = String.format("SOL%03d", numero); // Ej: SOL008
        }        
    } catch (Exception e) {
        System.out.println("Error al generar código: " + e.getMessage());
    } finally {
        conexion.cerrarConexion();
    }
    return nuevoCodigo;
    }
    
    public void insertarMaterial() {
        System.out.println("ingrese el tipo de material");
        String tipoMat = teclado.next();
    
        try {
            String sql = "INSERT INTO Material(codMaterial, tipoMaterial) VALUES (?, ?)";
            PreparedStatement psSolicitud = conn.prepareStatement(sql);        
            // Asignamos los valores
            psSolicitud.setString(1, generarCodSolicitud());   
            psSolicitud.setString(2, tipoMat);                   
                int filas = psSolicitud.executeUpdate();
                    if (filas > 0) {
                    System.out.println("Solicitud registrada correctamente.");
                    } else {
                    System.out.println("No se pudo registrar la solicitud.");
                    }
            }           catch (Exception e) {
                            System.out.println(" Error al insertar la solicitud: " + e.getMessage());
                        }   finally {
                            conexion.cerrarConexion();
                            }
    }
}*/public class InsersionMaterial {

    private final Connection conn;
    Scanner teclado = new Scanner(System.in);

    public InsersionMaterial(Connection conn) {        
        this.conn = conn;
    }

    public String generarCodSolicitud() {
        String nuevoCodigo = "SOL001"; // Valor inicial si no hay registros
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT codMaterial FROM Material ORDER BY codMaterial DESC LIMIT 1");
            if (rs.next()) {
                String ultimoCodigo = rs.getString("codMaterial"); // Ej: SOL007
                int numero = Integer.parseInt(ultimoCodigo.substring(3)); // Extrae 007 y lo convierte en 7
                numero++; // Incrementa
                // Formatea el nuevo código con ceros a la izquierda
                nuevoCodigo = String.format("SOL%03d", numero); // Ej: SOL008
            }
        } catch (Exception e) {
            System.out.println("Error al generar código: " + e.getMessage());
        }
        // ❌ NO cierres aquí la conexión
        // finally {
        //     conexion.cerrarConexion();
        // }
        return nuevoCodigo;
    }

    public void insertarMaterial() {
        System.out.println("Ingrese el tipo de material");
        String tipoMat = teclado.next();

        try {
            String sql = "INSERT INTO Material(codMaterial, tipoMaterial) VALUES (?, ?)";
            PreparedStatement psSolicitud = conn.prepareStatement(sql);
            // Asignamos los valores
            psSolicitud.setString(1, generarCodSolicitud());
            psSolicitud.setString(2, tipoMat);
            int filas = psSolicitud.executeUpdate();
            if (filas > 0) {
                System.out.println("Solicitud registrada correctamente.");
            } else {
                System.out.println("No se pudo registrar la solicitud.");
            }
        } catch (Exception e) {
            System.out.println("Error al insertar la solicitud: " + e.getMessage());
        } 
    }
}