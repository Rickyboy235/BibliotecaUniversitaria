/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Credenciales;

import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ATKZ
 */
public class LoginPersonal {
            CConexion conexion = new CConexion();
            Connection conn = conexion.establecerConexion();
            
    public boolean verificarCredencialesPersonal(String usuario,String contraseña){
        
        try {
            String sql = "SELECT * FROM CuentaPersonal WHERE codPers = ? AND contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Inicio de sesion: " + rs.getString("tipoPers"));
                return true;
            }else{
                System.out.println("Codigo o contraseña incorrecta.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("error login: " + e.getMessage());
            return false;
        } finally{
            conexion.cerrarConexion();
        }
    }
    public void mostrarNombrePersonal(String usuario, String contraseña){
        try {            
            String sql = "SELECT p.nomPers FROM CuentaPersonal c LEFT JOIN Personal p ON"
                + " p.codPers = c.codPers WHERE c.codPers = ? AND c.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                String nombre = rs.getString("nomPers");
                System.out.println("bienvenido: " + nombre);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }
    }
}
