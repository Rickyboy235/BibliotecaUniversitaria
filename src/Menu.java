/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class Menu {
    private static final String DB_URL = "jdbc:sqlite:reserva.db";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==== MENÚ PRINCIPAL ====");
            System.out.println("1. Mostrar salas disponibles");
            System.out.println("2. Mostrar PCs disponibles");
            System.out.println("3. Reservar sala");
            System.out.println("4. Reservar PC");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> mostrarSalasDisponibles();
                case 2 -> mostrarPCDisponibles();
                case 3 -> reservarSala(sc);
                case 4 -> reservarPC(sc);
                case 5 -> cancelarReserva(sc);
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    // Mostrar salas que no están reservadas
    public static void mostrarSalasDisponibles() {
        String sql = "SELECT * FROM Sala WHERE CodSala NOT IN (SELECT codSala FROM Reserva WHERE codSala IS NOT NULL)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n-- SALAS DISPONIBLES --");
            while (rs.next()) {
                System.out.println("Código: " + rs.getString("CodSala") +
                        ", Nombre: " + rs.getString("Nombre") +
                        ", Campus: " + rs.getString("Campus") +
                        ", Aforo: " + rs.getInt("Aforo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar las salas: " + e.getMessage());
        }
    }

    // Mostrar PCs que no están reservadas
    public static void mostrarPCDisponibles() {
    String sql = "SELECT * FROM PC WHERE CodPC NOT IN (SELECT codPC FROM Reserva WHERE codPC IS NOT NULL)";
    try (Connection conn = DriverManager.getConnection(DB_URL);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n-- COMPUTADORAS DISPONIBLES --");
        while (rs.next()) {
            System.out.println("Código: " + rs.getString("CodPC") +
                    ", Marca: " + rs.getString("Marca") +
                    ", Modelo: " + rs.getString("Modelo") +
                    ", RAM: " + rs.getString("Ram") +
                    ", SO: " + rs.getString("SO") +
                    ", Ubicación: " + rs.getString("Ubicacion"));
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar las PCs: " + e.getMessage());
    }
}

    // Método para generar código R001, R002...
    private static String generarCodigoReserva() {
        String nuevoCodigo = "R001";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT codReserva FROM Reserva ORDER BY codReserva DESC LIMIT 1")) {

            if (rs.next()) {
                String ultimo = rs.getString("codReserva"); // R008
                int numero = Integer.parseInt(ultimo.substring(1)) + 1;
                nuevoCodigo = String.format("R%03d", numero);
            }
        } catch (SQLException e) {
            System.out.println("Error generando código de reserva: " + e.getMessage());
        }
        return nuevoCodigo;
    }

    public static void reservarSala(Scanner sc) {
        System.out.print("Código de sala: ");
        String codSala = sc.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();
        System.out.print("Hora inicio (HH:MM): ");
        String horaInicio = sc.nextLine();
        System.out.print("Hora fin (HH:MM): ");
        String horaFin = sc.nextLine();

        String codReserva = generarCodigoReserva();

        String sql = "INSERT INTO Reserva (codReserva, fecha, horaInicio, horaFin, codSala, codPC) VALUES (?, ?, ?, ?, ?, NULL)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codReserva);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaInicio);
            pstmt.setString(4, horaFin);
            pstmt.setString(5, codSala);
            pstmt.executeUpdate();
            System.out.println("Reserva de sala exitosa. Código: " + codReserva);

        } catch (SQLException e) {
            System.out.println("Error al reservar sala: " + e.getMessage());
        }
    }

    public static void reservarPC(Scanner sc) {
        System.out.print("Código de PC: ");
        String codPC = sc.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        String fecha = sc.nextLine();
        System.out.print("Hora inicio (HH:MM): ");
        String horaInicio = sc.nextLine();
        System.out.print("Hora fin (HH:MM): ");
        String horaFin = sc.nextLine();

        String codReserva = generarCodigoReserva();

        String sql = "INSERT INTO Reserva (codReserva, fecha, horaInicio, horaFin, codSala, codPC) VALUES (?, ?, ?, ?, NULL, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codReserva);
            pstmt.setString(2, fecha);
            pstmt.setString(3, horaInicio);
            pstmt.setString(4, horaFin);
            pstmt.setString(5, codPC);
            pstmt.executeUpdate();
            System.out.println("Reserva de PC exitosa. Código: " + codReserva);

        } catch (SQLException e) {
            System.out.println("Error al reservar PC: " + e.getMessage());
        }
    }

    public static void cancelarReserva(Scanner sc) {
        System.out.print("Ingrese código de reserva a cancelar: ");
        String codReserva = sc.nextLine();

        String sql = "DELETE FROM Reserva WHERE codReserva = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, codReserva);
            int affected = pstmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Reserva cancelada correctamente.");
            } else {
                System.out.println("Código de reserva no encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al cancelar reserva: " + e.getMessage());
        }
    }
}