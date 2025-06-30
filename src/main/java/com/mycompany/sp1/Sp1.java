/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sp1;

import Credenciales.Login;
import Credenciales.LoginAdmin;
import Credenciales.LoginPersonal;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class Sp1 {

    public static void main(String[] args) {
        CConexion conexion = new CConexion();
            Connection conn = conexion.establecerConexion();
        /**CConexion objetoConexion = new CConexion();
        Connection conn = objetoConexion.establecerConexion();
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Personal");
            
            System.out.printf("%-12s | %-15s |%-15s |%-15s |%-15s |%-25s |%-15s\n ",
                    "CODIGO","NOMBRE","APE. PATERNO",
                        "APE.MATERNO","AREA","CORREO","TELEFONO");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            
            while (rs.next()){
                String cod = rs.getString("codPers");
                String nom = rs.getString("nomPers");
                String app = rs.getString("apePatPers");
                String apm = rs.getString("apeMatPers");
                String area = rs.getString("areaPers");
                String mail = rs.getString("corrPers");
                String telef = rs.getString("telPers");
                
                System.out.printf("%-12s | %-15s |%-15s |%-15s |%-15s |%-25s |%-15s\n",cod,nom,app,apm,
                        area,mail,telef);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error : " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    }**/
        Scanner teclado = new Scanner(System.in);
        
        
        System.out.println("bienvenido a la biblioteca...");
        System.out.println("""
                           Ingrese el tipo de usuario
                           1-Alumno
                           2-Docente
                           3-Personal""");
        int eleccion = teclado.nextInt();
        teclado.nextLine();
                System.out.print("USUARIO: ");
                String usuario = teclado.nextLine();
                System.out.print("CONTRASEÑA: ");
                String contraseña = teclado.nextLine();
        switch(eleccion){
            case 1 -> {                
                Login IS1 = new Login();
                boolean acceso = IS1.verificarCredencialesAlumno(usuario, contraseña);        
                if (acceso) {
                    IS1.mostrarNombreAlSes(usuario, contraseña);
                }   else {
                    System.out.println("acceso denegado");
                    }
            }
            case 2 -> {
                Login IS1 = new Login();
                boolean acceso = IS1.verificarCredencalesDocente(usuario, contraseña);        
                if (acceso) {
                    IS1.mostrarNombreDocSes(usuario, contraseña);
                }   else {
                    System.out.println("acceso denegado");
                    }
            }
            case 3-> {
                LoginPersonal LP1 = new LoginPersonal();
                boolean acceso = LP1.verificarCredencialesPersonal(usuario, contraseña);
                if (acceso) {
                    LP1.mostrarNombrePersonal(usuario, contraseña);
                } else {
                    System.out.println("acceso denegado");
                }
            }
            case 10666 ->{
                LoginAdmin LA1 = new LoginAdmin();
                boolean acceso = LA1.verificarAdmin(usuario, contraseña);
                if (acceso) {
                    LA1.mostrarNombreAdmin(usuario, contraseña);
                } else {
                    System.out.println("acceso denegado");
                }
            }
            default ->{
                System.out.println("error eleccion tipo");
            }
            

        }

    }    
}
