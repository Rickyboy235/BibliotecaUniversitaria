/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import Credenciales.LoginUsuario;
import com.mycompany.sp1.Alumno;
import com.mycompany.sp1.Solicitud;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public ArrayList<Solicitud> listHistorial(LoginUsuario codUsu){
        ArrayList<Solicitud> listaHistorial = new ArrayList<>();
        try {
            
            String sql = "SELECT p.idPrestamo as custom1, b.titulo as custom2,m.tipoMaterial as custom3, "
                    + "p.fecPrestamo as custom4 "
                    + "FROM Prestamo p INNER JOIN Bibliografico b on b.codMaterial = p.codMaterial "
                    + "INNER JOIN Material m on m.codMaterial = b.codMaterial "
                    + "INNER JOIN Solicitud s on s.codSolicitud = p.idPrestamo "
                    + "WHERE s.codUsuario = ? "
                    + "UNION "
                    + "SELECT p.idPrestamo as custom1, e.modelo as custom2,tipoMaterial as custom3, "
                    + "p.fecPrestamo as custom4 FROM Prestamo p "
                    + "INNER JOIN Electronico e on e.codMaterial = p.codMaterial "
                    + "INNER JOIN Material m on m.codMaterial = e.codMaterial "
                    + "INNER JOIN Solicitud s on s.codSolicitud = p.idPrestamo "
                    + "WHERE s.codUsuario = ? "
                    + "ORDER by p.fecPrestamo DESC";
            PreparedStatement psHist = conn.prepareStatement(sql);
            psHist.setString(1, codUsu.getCodigo());
            psHist.setString(2, codUsu.getCodigo());
            ResultSet rs = psHist.executeQuery();
            while (rs.next()){
                String custom1 = rs.getString("custom1");
                String custom2 = rs.getString("custom2");
                String custom3 = rs.getString("custom3");
                String custom4 = rs.getString("custom4");
                
                //System.out.println("DEBUG: " + custom1 + " | " + custom2 + " | " + custom3 + " | " + custom4);
                
                Solicitud soli = new Solicitud(custom1, custom2, custom3, custom4);
                listaHistorial.add(soli);
            }
        } catch (Exception e) {
            System.out.println("error al obtener historial: " + e.getMessage());
        } finally{
            conexion.cerrarConexion();
        }
        return listaHistorial;
    }
}
