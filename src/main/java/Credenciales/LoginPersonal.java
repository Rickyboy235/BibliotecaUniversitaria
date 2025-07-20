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
public class LoginPersonal extends Login {
    
    public LoginPersonal() {
    }

    public LoginPersonal(String codigo, String contraseña, CConexion conexion, Connection conn, Scanner teclado) {
        super(codigo, contraseña, conexion, conn, teclado);
    }
    
    
    @Override
    public String ingresarCodigo(){        
        System.out.print("USUARIO: ");
        codigo = teclado.nextLine();
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
        boolean estado;
        try {
            String sql = "SELECT * FROM CuentaPersonal WHERE codPers = ? AND contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                estado = true;
                System.out.println("Inicio de sesion: " + rs.getString("tipoPers"));estado = true;
                return estado;
            }else{
                estado = false;
                System.out.println("Codigo o contraseña incorrecta.");
                
                return estado;
            }
        } catch (Exception e) {
            estado = false;
            System.out.println("error login: " + e.getMessage());
            return estado;
        } finally{
            conexion.cerrarConexion();
        }
    }
    @Override
    public void mostrarDatosLogin(){
        try {            
            String sql = "SELECT p.nomPers, p.apePatPers FROM CuentaPersonal c LEFT JOIN Personal p ON"
                + " p.codPers = c.codPers WHERE c.codPers = ? AND c.contraseña = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {      
                //ESTAS VARIABLES PUEDE PASAR A SER VARIABLES GENERALES PRIVADAS ARRIBA 
                String nombre = rs.getString("nomPers");
                String apellido = rs.getString("apePatPers");
                System.out.println("Bienvenido: " + nombre + " " + apellido);
            }else{
                System.out.println("error mostrar nombre");
            }
        } catch (Exception e) {
            System.out.println("error mostrar: " + e.getMessage());
        }
    }
}
