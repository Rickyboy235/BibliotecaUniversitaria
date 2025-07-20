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
    private final CConexion conexion;
    private final Connection conn;
    private final Scanner teclado;

    public MenuPrincipal() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
        this.teclado = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        boolean banderaInicial = true;
        int eleccion;

        while (banderaInicial) {
            do {
                System.out.println("-".repeat(72));
                System.out.println("""
                    INICIO SESION
                    ELIJA EL TIPO DE USUARIO
                    1. Alumno
                    2. Docente
                    3. Personal
                    0. Cerrar Aplicacion.""");
                eleccion = teclado.nextInt();
            } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 0 && eleccion != 10666);

            switch (eleccion) {
                case 1 -> {
                    LoginUsuario IS1 = new LoginUsuario(conn); // ✅ pasa la conexión
                    IS1.ingresarCodigo();
                    IS1.ingresarContraseña();
                    boolean acceso = IS1.verificarCredenciales();

                    if (acceso) {
                        IS1.mostrarNombreAlSes();
                        menuUsuario musu = new menuUsuario(conn, IS1); // ✅ pasa la conexión
                        musu.menuUser();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                }

                case 2 -> {
                    LoginUsuario IS1 = new LoginUsuario(conn); // ✅ pasa la conexión
                    IS1.ingresarCodigo();
                    IS1.ingresarContraseña();
                    boolean acceso = IS1.verificarCredenciales();

                    if (acceso) {
                        IS1.mostrarNombreDocSes();
                        menuUsuario musu = new menuUsuario(conn, IS1); // ✅ pasa la conexión
                        musu.menuUser();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                }

                case 3 -> {
                    LoginPersonal LP1 = new LoginPersonal(); // ✅ pasa la conexión
                    LP1.ingresarCodigo();
                    LP1.ingresarContraseña();
                    boolean acceso = LP1.verificarCredenciales();

                    if (acceso) {
                        LP1.mostrarDatosLogin();
                        menuPersonal mper = new menuPersonal(); // ✅ pasa la conexión
                        mper.menuPersonal();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                }

                case 0 -> {
                    System.out.println("Cerrando aplicacion...");
                   conexion.cerrarConexion();
                    banderaInicial = false;
                }

                case 10666 -> {
                    LoginAdmin LA1 = new LoginAdmin(conn); // ✅ pasa la conexión
                    LA1.ingresarCodigo();
                    LA1.ingresarContraseña();
                    boolean acceso = LA1.verificarCredenciales();

                    if (acceso) {
                        LA1.mostrarDatosLogin();
                        menuAdmin madm = new menuAdmin(conn,LA1); // ✅ pasa la conexión
                        madm.mostrarMenuPrincipal();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                }

                default -> {
                    System.out.println("Error en la elección");
                }
            }
        }
    }
}