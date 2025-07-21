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
                Alumno alumno = Alumno.fromResultSet(rs);
                listaAlumnos.add(alumno);
                
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
                AlumnoPostgrado aPostgrado = AlumnoPostgrado.fromResultSet(rs);
                listaAlumnos.add(aPostgrado);
                
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
                Docente docente = Docente.fromResultSet(rs);
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
