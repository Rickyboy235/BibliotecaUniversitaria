/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Credenciales;

import conexion.CConexion;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
abstract class Login {
    protected String codigo;
    protected String contraseña;
    protected CConexion conexion;
    protected Connection conn;
    protected Scanner teclado;
    protected boolean estado;
    
    public Login() {
        this.teclado = new Scanner(System.in);
        this.conexion = new CConexion();
        this.conn  = conexion.establecerConexion();
    }

    public Login(String codigo, String contraseña, CConexion conexion, Connection conn, Scanner teclado) {
        this.codigo = codigo;
        this.contraseña = contraseña;
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
        this.teclado = teclado; 
        this.estado = false;
    }
    
    
       
    public abstract String ingresarCodigo();
    public abstract String ingresarContraseña();
    public abstract boolean verificarCredenciales();
    public abstract void mostrarDatosLogin();
    
}
