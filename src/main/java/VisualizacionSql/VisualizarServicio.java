/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import com.mycompany.sp1.Computadora;
import com.mycompany.sp1.Sala;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class VisualizarServicio {
    private final Connection conn;
    private final CConexion conexion;
    Scanner teclado = new Scanner(System.in);

    public VisualizarServicio() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();        
    }
    public ArrayList<Computadora> listComputadoras(){
        ArrayList<Computadora> listaComp = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Computadora");
            while (rs.next()){
                Computadora computadora = Computadora.fromResulSet(rs);
                listaComp.add(computadora);
            }
        } catch (Exception e) {
            System.out.println("error al obtener computadoras: " + e.getMessage());
        }
        return listaComp;
    }
    public ArrayList<Sala> listSalas(){
        ArrayList<Sala> listaSalas = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SalaGrupal");
            while (rs.next()){
                Sala sala = Sala.fromResulSet(rs);
                listaSalas.add(sala);
            }
            
        } catch (Exception e) {
            System.out.println("error al obtener salas: " + e.getMessage());
        }
        return listaSalas;
    }
    public Computadora matSelecComputadora(ArrayList<Computadora> listaComp){
        try {
            System.out.println("Ingrese el indice que desee seleccionar");
            int indiceServ = teclado.nextInt();
            
            if (indiceServ < 1 || indiceServ > listaComp.size()) {
                System.out.println("Indice ingresado es incorrecto: ");
                return null;
            }
            Computadora compSelecc = listaComp.get(indiceServ -1);
            System.out.println("\n Registro seleccionado");
            System.out.println("-".repeat(166));
            System.out.printf("| %-17s | %-15s | %-10s | %-25s | %-18s |\n",
                    "MARCA","MODELO", "RAM","SIS. OPERATIVO","UBICACION");
            System.out.println("-".repeat(166));
            compSelecc.mostrarDatos();
            System.out.println("-".repeat(166));            
            return compSelecc;
    } catch (Exception e) {
            System.out.println("error al ejecutar servicio seleccionado: " + e.getMessage());
            return null;
        }
        finally{
            conexion.cerrarConexion();
        }
        
    }
    
    public Sala matSelecSala(ArrayList<Sala> listaSalas){        
        try {
            System.out.println("Ingrese el indice que desee seleccionar");
            int indiceServ = teclado.nextInt();
            
            if (indiceServ < 1 || indiceServ > listaSalas.size()) {
                System.out.println("Indice ingresado es incorrecto: ");
                return null;
            }
            Sala salaSelecc = listaSalas.get(indiceServ -1);
            System.out.println("\n Registro seleccionado");
            System.out.println("-".repeat(166));
            System.out.printf("| %-33s | %-28s | %-10s |\n",
                    "NOMBRE","CAMPUS", "AFORO");
            System.out.println("-".repeat(166));
            salaSelecc.mostrarDatos();
            System.out.println("-".repeat(166));            
            return salaSelecc;
    } catch (Exception e) {
            System.out.println("error al ejecutar servicio seleccionado: " + e.getMessage());
            return null;
        }
        finally{
            conexion.cerrarConexion();
        }
    }
    public void cerrarConexion(){
        try {
            
        } finally {
            conexion.cerrarConexion();
        }
    }
}