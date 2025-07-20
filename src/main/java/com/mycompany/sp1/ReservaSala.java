/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaSala extends Reserva {
    private final String codSala;
    private static final String DB_URL = "jdbc:sqlite:BibliotecaUtp.db";

    public ReservaSala(String codSala, String fecha, String horaInicio, String horaFin) {
        super(fecha, horaInicio, horaFin);
        this.codSala = codSala;
    }

    public void registrar() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
            conn.setAutoCommit(false); // Evita el bloqueo prolongado
            pstmt = conn.prepareStatement(
                "INSERT INTO Reserva (codReserva, fecha, horaInicio, horaFin, codSala, codPC) " +
                "VALUES (?, ?, ?, ?, ?, NULL)"
            );
            pstmt.setString(1, codReserva);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaInicio);
            pstmt.setString(4, horaFin);
            pstmt.setString(5, codSala);

            pstmt.executeUpdate();
            conn.commit(); // Confirma cambios
            System.out.println("Reserva de sala registrada con éxito. Código: " + codReserva);
        } catch (SQLException e) {
            System.out.println("Error al registrar reserva de sala: " + e.getMessage());
            try {
                if (conn != null) conn.rollback(); // Revierte cambios si hubo error
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); // Asegura el cierre
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public static void cancelar(String codReserva) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(
                "DELETE FROM Reserva WHERE codReserva = ? AND codSala IS NOT NULL"
            );
            pstmt.setString(1, codReserva);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                conn.commit();
                System.out.println("Reserva de sala cancelada.");
            } else {
                System.out.println("No se encontró una reserva de sala con ese código.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cancelar reserva de sala: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); // Muy importante cerrar siempre
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}