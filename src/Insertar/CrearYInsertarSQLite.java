/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Insertar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ASUS
 */
public class CrearYInsertarSQLite {
    public static void main(String[] args) {
         String url = "jdbc:sqlite:reserva.db"; // Esta será la nueva base de datos

        // Sentencia SQL para crear la tabla Sala
        String crearTablaSala = "CREATE TABLE IF NOT EXISTS Sala ("
                              + " CodSala TEXT PRIMARY KEY NOT NULL,"
                              + " Nombre TEXT NOT NULL,"
                              + " Campus TEXT NOT NULL,"
                              + " Aforo INTEGER NOT NULL"
                              + ");";

        // Sentencia SQL para crear la tabla PC
        String crearTablaPC = "CREATE TABLE IF NOT EXISTS PC ("
                            + " CodPC TEXT PRIMARY KEY NOT NULL,"
                            + " Marca TEXT NOT NULL,"
                            + " Modelo TEXT NOT NULL,"
                            + " Ram TEXT NOT NULL,"
                            + " SO TEXT NOT NULL,"
                            + " Ubicacion TEXT NOT NULL"
                            + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Ejecutar creación de tablas
            stmt.execute(crearTablaSala);
            stmt.execute(crearTablaPC);

            System.out.println("Base de datos 'reserva.db' y tablas 'Sala' y 'PC' creadas correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al crear la base o tablas: " + e.getMessage());
        }       
    }    
}
