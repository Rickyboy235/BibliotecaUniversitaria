/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package consultas;
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class ConsultaSala {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:reserva.db"; // Ruta de tu base de datos

        String consultaSQL = "SELECT * FROM Sala";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            System.out.println("Datos en la tabla Sala:");
            while (rs.next()) {
                String codSala = rs.getString("CodSala");
                String nombre = rs.getString("Nombre");
                String campus = rs.getString("Campus");
                int aforo = rs.getInt("Aforo");

                System.out.println("CodSala: " + codSala + ", Nombre: " + nombre +
                                   ", Campus: " + campus + ", Aforo: " + aforo);
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }    
}
