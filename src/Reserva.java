/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author ASUS
 */
public class Reserva {
    protected String codReserva;
    protected String fecha;
    protected String horaInicio;
    protected String horaFin;

    public Reserva(String fecha, String horaInicio, String horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.codReserva = generarCodigo(); // Ahora será como R001, R002...
    }

    private String generarCodigo() {
        String nuevoCodigo = "R001"; // valor por defecto
        String url = "jdbc:sqlite:reserva.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM Reserva")) {

            if (rs.next()) {
                int total = rs.getInt("total") + 1;
                nuevoCodigo = String.format("R%03d", total);
            }

        } catch (SQLException e) {
            System.err.println("Error al generar código: " + e.getMessage());
        }

        return nuevoCodigo;
    }

    public String getCodReserva() {
        return codReserva;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }
}