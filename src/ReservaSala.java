/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class ReservaSala extends Reserva {
    private String codSala;

    public ReservaSala(String codSala, String fecha, String horaInicio, String horaFin) {
        super(fecha, horaInicio, horaFin);
        this.codSala = codSala;
    }

    public void registrar() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:reserva.db");
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Reserva (codReserva, fecha, horaInicio, horaFin, codSala, codPC) VALUES (?, ?, ?, ?, ?, NULL)")) {
            pstmt.setString(1, codReserva);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaInicio);
            pstmt.setString(4, horaFin);
            pstmt.setString(5, codSala);
            pstmt.executeUpdate();
            System.out.println("Reserva de sala registrada con éxito. Código: " + codReserva);
        } catch (SQLException e) {
            System.out.println("Error al registrar reserva de sala: " + e.getMessage());
        }
    }

    public static void cancelar(String codReserva) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:reserva.db");
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Reserva WHERE codReserva = ? AND codSala IS NOT NULL")) {
            pstmt.setString(1, codReserva);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Reserva de sala cancelada.");
            } else {
                System.out.println("No se encontró una reserva de sala con ese código.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cancelar reserva de sala: " + e.getMessage());
        }
    }
}