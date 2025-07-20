/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexion.CConexion;
import java.sql.Connection;
/**
 *
 * @author ATKZ
 */
public class validarIniSesion {
    
    /**
     * ESTO DUDANDO DE ESTA CLASE 
     * PARA EL FINAL DEL PROYECTO
     */
    CConexion conexion = new CConexion();
    Connection conn = conexion.establecerConexion();
    public boolean verificarCredencialesAlumno(String usuario,String contraseña){
        try {
            String sql = "SELECT * FROM Usuario WHERE codUsuario = ? AND contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Inicio de sesion: " + rs.getString("tipoUsuario"));
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
    public boolean verificarCredencalesDocente(String usuario, String contraseña){
        try {
            String sql = "SELECT * FROM Usuario WHERE codUsuario = ? AND contraseña = ? AND tipoUsuario = 'Docente'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Inicio de sesion: " + rs.getString("tipoUsuario"));
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
    public void mostrarNombreAlSes(String usuario, String contraseña){
        try {            
            String sql = "SELECT a.nomAlPre FROM Usuario u LEFT JOIN AlumnoPregrado a ON"
                + " u.codUsuario = a.codAlPre LEFT JOIN AlumnoPostgrado p ON u.codUsuario = "
                    + "p.codAlPos  WHERE u.codUsuario = ? AND u.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                String nombre = rs.getString("nomAlPre");
                System.out.println("bienvenido: " + nombre);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }   
    }
    public void mostrarNombreDocSes(String usuario, String contraseña){
        try {            
            String sql = "SELECT d.nomDoc FROM Usuario u LEFT JOIN Docente d ON"
                + " u.codUsuario = d.codDoc WHERE u.codUsuario = ? AND u.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                String nombre = rs.getString("nomDoc");
                System.out.println("bienvenido: " + nombre);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }
    }
}
