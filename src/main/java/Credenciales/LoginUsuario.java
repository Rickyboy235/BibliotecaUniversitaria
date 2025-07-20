/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Credenciales;

import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class LoginUsuario extends Login {
    private Connection conn;

    public LoginUsuario(Connection conn) {
        this.conn = conn;
    }
    
    
    public LoginUsuario() {
    }

    public LoginUsuario(String codigo, String contraseña, CConexion conexion, Connection conn, Scanner teclado) {
        super(codigo, contraseña, conexion, conn, teclado);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
          
    
    @Override
    public String ingresarCodigo(){        
        System.out.print("USUARIO: ");
        super.codigo = teclado.nextLine();
        setCodigo(codigo);
        return codigo;
    }
    @Override
    public String ingresarContraseña(){
        System.out.print("CONTRASEÑA: ");
        contraseña = teclado.nextLine();
        return contraseña;
    }
    @Override
    public boolean verificarCredenciales(){
        
        try {
            String sql = "SELECT * FROM Usuario WHERE codUsuario = ? AND contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
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
   
   
    public void mostrarNombreAlSes(){
        try {            
            String sql = "SELECT u.codUsuario, a.nomAlPre, a.apePatAlPre FROM Usuario u LEFT JOIN AlumnoPregrado a ON"
                + " u.codUsuario = a.codAlPre LEFT JOIN AlumnoPostgrado p ON u.codUsuario = "
                    + "p.codAlPos  WHERE u.codUsuario = ? AND u.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {                
                String nombre = rs.getString("nomAlPre");
                String apellido = rs.getString("apePatAlPre");
                System.out.println("Bienvenido: " + nombre + " " + apellido);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }   
    }
    public void mostrarNombreDocSes(){
        try {            
            String sql = "SELECT d.nomDoc, d.apePatDoc FROM Usuario u LEFT JOIN Docente d ON"
                + " u.codUsuario = d.codDoc WHERE u.codUsuario = ? AND u.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                //ESTAS VARIABLES PUEDE PASAR A SER VARIABLES GENERALES PRIVADAS ARRIBA                 
                String nombre = rs.getString("nomDoc");
                String apellido = rs.getString("apePatDoc");
                System.out.println("Bienvenido: " + nombre + " " + apellido);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }
    }

    @Override
    public void mostrarDatosLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
