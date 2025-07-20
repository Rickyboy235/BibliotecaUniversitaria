/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import com.mycompany.sp1.Alumno;
import com.mycompany.sp1.AlumnoPostgrado;
import com.mycompany.sp1.Docente;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ATKZ
 */
public class VisualizarUsuario {
    private final CConexion conexion;
    private final Connection conn;
    

    public VisualizarUsuario() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
        
    }
    
    public ArrayList<Alumno> listAlumPregrado(){
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.codAlPre, a.dniAlPre, u.tipoUsuario, "
                    + "a.nomAlPre, a.apePatAlPre, a.apeMatAlPre, a.carrera, "
                    + "a.corrAlPre, a.telAlPre FROM Usuario u "
                    + "INNER JOIN AlumnoPregrado a ON a.codAlPre = u.codUsuario "
                    + "WHERE u.tipoUsuario = 'Alumno Pregrado'");
            while (rs.next()){
                String codAlu = rs.getString("codAlPre");
                String dniAlu = rs.getString("dniAlPre");
                String tipoAlu = rs.getString("tipoUsuario");
                String nomAlu = rs.getString("nomAlPre");
                String apPatAlu = rs.getString("apePatAlPre");
                String apMatAlu = rs.getString("apeMatAlPre");
                String carAlu = rs.getString("carrera");
                String corrAlu = rs.getString("corrAlPre");
                String telefAlu = rs.getString("telAlPre");
                
                Alumno alPre = new Alumno(codAlu, dniAlu, tipoAlu, nomAlu, apPatAlu, apMatAlu, carAlu, corrAlu, telefAlu);
                listaAlumnos.add(alPre);
                
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos del alumnoPregrado: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaAlumnos;
    }
    public ArrayList<AlumnoPostgrado> listAlumPostgrado(){
        ArrayList<AlumnoPostgrado> listaAlumnos = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.codAlPos, a.dniAlPos, u.tipoUsuario, "
                    + "a.nomAlPos, a.apePatAlPos, a.apeMatAlPos, a.maestria, a.corrAlPos, a.telAlPos "
                    + "FROM Usuario u INNER JOIN AlumnoPostgrado a ON a.codAlPos = u.codUsuario "
                    + "WHERE u.tipoUsuario = 'Alumno Postgrado'");
            while (rs.next()){
                String codAlu = rs.getString("codAlPos");
                String dniAlu = rs.getString("dniAlPos");
                String tipoAlu = rs.getString("tipoUsuario");
                String nomAlu = rs.getString("nomAlPos");
                String apPatAlu = rs.getString("apePatAlPos");
                String apMatAlu = rs.getString("apeMatAlPos");                
                String maesAlu = rs.getString("maestria");
                String corrAlu = rs.getString("corrAlPos");
                String telefAlu = rs.getString("telAlPos");
                
                AlumnoPostgrado alPre = new AlumnoPostgrado(codAlu, dniAlu, tipoAlu,
                        nomAlu, apPatAlu, apMatAlu, maesAlu, corrAlu, telefAlu);
                listaAlumnos.add(alPre);
                
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos del alumno postgrado: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaAlumnos;
    }
    
    public ArrayList<Docente> mostrarRelDocentes(){
        ArrayList<Docente> listaDocentes = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.codDoc, d.dniDoc, u.tipoUsuario, "
                    + "d.nomDoc, d.apePatDoc, d.apeMatDoc, d.curso, d.corrDoc, d.telDoc "
                    + "FROM Usuario u INNER JOIN Docente d ON d.codDoc = u.codUsuario "
                    + "WHERE u.tipoUsuario = 'Docente'");
            while (rs.next()){
                String codDoc = rs.getString("codDoc");
                String dniDoc = rs.getString("dniDoc");
                String nomDoc = rs.getString("nomDoc");
                String apPatDoc = rs.getString("apePatDoc");
                String apMatDoc = rs.getString("apeMatDoc");
                String cursoDoc = rs.getString("curso");
                String correoDoc = rs.getString("corrDoc");
                String telDoc = rs.getString("telDoc");
                
                Docente docente = new Docente(codDoc, dniDoc, nomDoc,
                apPatDoc, apMatDoc, cursoDoc, correoDoc, telDoc);
                listaDocentes.add(docente);
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos del docente: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaDocentes;
    }
    
    
}
