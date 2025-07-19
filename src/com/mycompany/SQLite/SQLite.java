/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.SQLite;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class SQLite {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        Connection conn = conexion.establecerConexion();

        // Verificar si se conectó
        if (conn != null) {
            System.out.println("Bienvenido a la biblioteca virtual.");
        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return; // terminar programa si no hay conexión
        }

        Scanner teclado = new Scanner(System.in);

        // Aquí puedes agregar tus menús u operaciones SQL
        System.out.println("""
                ¿Qué desea hacer?
                1. Mostrar mensaje de prueba
                2. Salir
                """);
        int opcion = teclado.nextInt();

        switch (opcion) {
            case 1 -> System.out.println("¡Funciona correctamente la conexión SQLite!");
            case 2 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida.");
        }

        // Cerrar conexión al final del programa
        try {
            if (!conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }

        teclado.close();
    }   
}
