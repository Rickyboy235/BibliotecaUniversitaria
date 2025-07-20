/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Credenciales.*;
import conexion.CConexion;
import java.sql.Connection;
import java.util.Scanner;
/**
 *
 * @author ATKZ
 */
public class MenuPrincipal {
    CConexion conexion = new CConexion();
    Connection conn = conexion.establecerConexion();
    private Scanner teclado;

    public MenuPrincipal() {
        this.teclado = new Scanner(System.in);
    }
    public void mostrarMenuPrincipal(){
        boolean banderaInicial = true;
        int eleccion;
        while(banderaInicial){
        do{
            System.out.println("-".repeat(72));
            System.out.println("""                               
                               INICIO SESION
                               ELIJA EL TIPO DE USUARIO
                               1. Alumno
                               2. Docente
                               3. personal
                               0. Cerrar Aplicacion.""");
            eleccion = teclado.nextInt();
        }while (eleccion != 3 && eleccion != 1 && eleccion != 2 && 
            eleccion != 0 && eleccion != 10666);
            switch(eleccion){
                case 1 -> {                
                    LoginUsuario IS1 = new LoginUsuario();
                    IS1.ingresarCodigo();
                    IS1.ingresarContraseña();
                    boolean acceso = IS1.verificarCredenciales();        
                    if (acceso) {
                        IS1.mostrarNombreAlSes();
                        menuUsuario musu = new menuUsuario();
                        musu.menuUser();
                    }   else {
                        System.out.println("acceso denegado");
                        }
                    
                }
                case 2 -> {
                    LoginUsuario IS1 = new LoginUsuario();
                    IS1.ingresarCodigo();
                    IS1.ingresarContraseña();
                    boolean acceso = IS1.verificarCredenciales();        
                    if (acceso) {
                        IS1.mostrarNombreDocSes();
                        menuUsuario musu = new menuUsuario();
                        musu.menuUser();
                    }   else {
                        System.out.println("acceso denegado");
                        }
                }
                case 3 -> {
                    LoginPersonal LP1 = new LoginPersonal();
                    LP1.ingresarCodigo();
                    LP1.ingresarContraseña();
                    boolean acceso = LP1.verificarCredenciales();
                    if (acceso) {
                        LP1.mostrarDatosLogin();
                        menuPersonal mper = new menuPersonal();
                        mper.menuPersonal();
                    } else {
                        System.out.println("acceso denegado");
                    }
                    
                }
                case 0 ->{
                    System.out.println("cerrando aplicacion....");
                    banderaInicial = false;
                }
                case 10666 ->{
                    LoginAdmin LA1 = new LoginAdmin();
                    LA1.ingresarCodigo();
                    LA1.ingresarContraseña();
                    boolean acceso = LA1.verificarCredenciales();
                    if (acceso) {
                        LA1.mostrarDatosLogin();
                        menuAdmin madm = new menuAdmin();
                        madm.mostrarMenuPrincipal();
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
}
