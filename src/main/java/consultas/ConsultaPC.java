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
public class ConsultaPC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:BibliotecaUtp.db"; // Ruta de tu base de datos

        String consultaSQL = "SELECT * FROM PC";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            System.out.println("Datos en la tabla PC:");
            while (rs.next()) {
                String CodPC = rs.getString("CodPC");
                String Marca = rs.getString("Marca");
                String Modelo = rs.getString("Modelo");
                String Ram = rs.getString("Ram");
                String SO = rs.getString("SO");
                String Ubicacion = rs.getString("Ubicacion");

                System.out.println("CodPC: " + CodPC + ", Marca: " + Marca +
                                   ", Modelo: " + Modelo + ", Ram: " + Ram + 
                                   ", SO: " + SO + ", Ubicacion: " + Ubicacion
                                   );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar: " + e.getMessage());
        }
    }    
}
