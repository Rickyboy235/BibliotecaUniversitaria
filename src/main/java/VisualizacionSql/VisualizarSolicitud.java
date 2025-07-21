/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import com.mycompany.sp1.Solicitud;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ATKZ
 */
public class VisualizarSolicitud {
    /**
     * PARECE QUE ACABE CON ESTA CLASE
     */
    private final Connection conn;
    private final CConexion conexion;

    public VisualizarSolicitud() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
    }
    public ArrayList<Solicitud> listSolicitud(){
        ArrayList<Solicitud> listaSolicitudes = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.codSolicitud, s.codUsuario, s.tipoSolicitud, "
                    + "m.codMaterial, m.tipoMaterial, s.fechaSolicitud, s.estadoSolicitud "
                    + "FROM Solicitud s INNER JOIN Prestamo p ON p.idPrestamo = s.codSolicitud "
                    + "INNER JOIN Material m ON m.codMaterial = p.codMaterial");
            while (rs.next()){
                String codSol = rs.getString("codSolicitud");
                String codUsu = rs.getString("codUsuario");
                String tipSol = rs.getString("tipoSolicitud");
                String fecSol = rs.getString("fechaSolicitud");
                String estSol = rs.getString("estadoSolicitud");
                
                Solicitud soli = new Solicitud(codSol, codUsu, tipSol, fecSol, estSol);
                listaSolicitudes.add(soli);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaSolicitudes;
    }
    
    public ArrayList<Solicitud> listEspera(){
        ArrayList<Solicitud> listaSoliEspera = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.codSolicitud, s.codUsuario, "
                    + "s.tipoSolicitud, s.fechaSolicitud, s.estadoSolicitud FROM Solicitud as s");
            while (rs.next()){
                String codSol = rs.getString("codSolicitud");
                String codUsu = rs.getString("codUsuario");
                String tipSol = rs.getString("tipoSolicitud");
                String fecSol = rs.getString("fechaSolicitud");
                String estSol = rs.getString("estadoSolicitud");
                
                Solicitud soli = new Solicitud(codSol, codUsu, tipSol, fecSol, estSol);
                listaSoliEspera.add(soli);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaSoliEspera;
    }
    public ArrayList<Solicitud> listPrestamos(){
        ArrayList<Solicitud> listaPrestamo = new ArrayList<>();
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.codSolicitud, s.codUsuario, "
                    + "s.tipoSolicitud, s.fechaSolicitud, s.estadoSolicitud FROM Solicitud as s "
                    + "WHERE s.tipoSolicitud = 'prestamo'");
            while (rs.next()){
                String codSol = rs.getString("codSolicitud");
                String codUsu = rs.getString("codUsuario");
                String tipSol = rs.getString("tipoSolicitud");
                String fecSol = rs.getString("fechaSolicitud");
                String estSol = rs.getString("estadoSolicitud");
                
                Solicitud soli = new Solicitud(codSol, codUsu, tipSol, fecSol, estSol);
                listaPrestamo.add(soli);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaPrestamo;
    }
    public ArrayList<Solicitud> listReservas(){
        ArrayList<Solicitud> listaReserva = new ArrayList<>();
        try {
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT s.codSolicitud, s.codUsuario, "
                    + "s.tipoSolicitud, s.fechaSolicitud, s.estadoSolicitud FROM Solicitud as s "
                    + "WHERE s.tipoSolicitud = 'reserva'");
            while (rs.next()){
                String codSol = rs.getString("codSolicitud");
                String codUsu = rs.getString("codUsuario");
                String tipSol = rs.getString("tipoSolicitud");
                String fecSol = rs.getString("fechaSolicitud");
                String estSol = rs.getString("estadoSolicitud");
                
                Solicitud soli = new Solicitud(codSol, codUsu, tipSol, fecSol, estSol);
                listaReserva.add(soli);
            }
        } catch (Exception e) {
            System.out.println("error al obtener tesis: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaReserva;
    }
}
