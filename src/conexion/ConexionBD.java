/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class ConexionBD {
    private Connection conectar = null;

    // Ruta del archivo SQLite (ajustado al directorio actual del proyecto)
    private final String db = "BibliotecaUtp.db";    
    private final String cadena = "jdbc:sqlite:" + System.getProperty("user.dir") + "/" + db;

    // Método para establecer la conexión
    public Connection establecerConexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection(cadena);
            JOptionPane.showMessageDialog(null, "Conexión a la base de datos exitosa.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.toString());
        }
        return conectar;
    }

    // Método para cerrar conexión
    public void cerrarConexion() {
        try {
            if (conectar != null) {
                conectar.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada correctamente.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.toString());
        }
    }
}
