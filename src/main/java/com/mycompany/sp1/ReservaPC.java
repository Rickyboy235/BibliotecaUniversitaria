/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservaPC extends Reserva {
    private final String codPC;
    private static final String DB_URL = "jdbc:sqlite:BibliotecaUtp.db";

    public ReservaPC(String codPC, String fecha, String horaInicio, String horaFin) {
        super(fecha, horaInicio, horaFin);
        this.codPC = codPC;
    }

    public void registrar() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Crear conexión
            conn = DriverManager.getConnection(DB_URL);
            
            // Aplicar timeout para evitar bloqueo
            conn.createStatement().execute("PRAGMA busy_timeout = 5000;");

            // Desactivar auto-commit para transacción segura
            conn.setAutoCommit(false);

            String sql = "INSERT INTO Reserva (codReserva, fecha, horaInicio, horaFin, codSala, codPC) " +
                         "VALUES (?, ?, ?, ?, NULL, ?)";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codReserva);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaInicio);
            pstmt.setString(4, horaFin);
            pstmt.setString(5, codPC);

            pstmt.executeUpdate();
            conn.commit();

            System.out.println("✅ Reserva de computadora registrada con éxito. Código: " + codReserva);

        } catch (SQLException e) {
            System.out.println("❌ Error al registrar reserva de PC: " + e.getMessage());

            // Revertir si hay error
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("❌ Error al hacer rollback: " + rollbackEx.getMessage());
            }

        } finally {
            // Cierre seguro
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public static void cancelar(String codReserva) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL);
            conn.createStatement().execute("PRAGMA busy_timeout = 5000;");
            conn.setAutoCommit(false);

            String sql = "DELETE FROM Reserva WHERE codReserva = ? AND codPC IS NOT NULL";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codReserva);

            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                conn.commit();
                System.out.println("✅ Reserva de computadora cancelada.");
            } else {
                System.out.println("⚠️ No se encontró una reserva de PC con ese código.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al cancelar reserva de PC: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("❌ Error al hacer rollback: " + rollbackEx.getMessage());
            }

        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("❌ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}