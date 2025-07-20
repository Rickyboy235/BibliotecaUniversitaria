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
 * @author ATKZ
 */
/*
public class CConexion {
    Connection conectar = null;
    
    String db = "BibliotecaUtp.db";    
    String cadena = "jdbc:sqlite:" + System.getProperty("user.dir")+"/"+db;
    
    public Connection establecerConexion(){
        Connection conectar = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection(cadena);
            JOptionPane.showMessageDialog(null, "se conecto correctamnte");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"no se conecto correctamente, error"+ e.toString());
        }
        return conectar;
    }
    
    public void cerrarConexion(){
        try {
            if (conectar != null) {
                conectar.close();
                JOptionPane.showMessageDialog(null,"se cerro correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO se cerro correctamente, error: " + e.toString());
        }
    }
}
*/public class CConexion {
    private Connection conectar = null;

    private final String db = "BibliotecaUtp.db";
    private final String cadena = "jdbc:sqlite:" + System.getProperty("user.dir") + "/" + db;

    public Connection establecerConexion() {
        try {
            if (conectar == null || conectar.isClosed()) { // ✅ solo abre si está cerrada
                Class.forName("org.sqlite.JDBC");
                conectar = DriverManager.getConnection(cadena);
                System.out.println("✅ Conexión establecida.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conectar;
    }

    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("✅ Conexión cerrada.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al cerrar conexión: " + e.getMessage());
        }
    }
}
