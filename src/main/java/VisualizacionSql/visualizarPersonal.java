/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VisualizacionSql;

import com.mycompany.sp1.Personal;
import conexion.CConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ATKZ
 */
public class visualizarPersonal {
    
    private final CConexion conexion;
    private final Connection conn;

    public visualizarPersonal() {
        this.conexion = new CConexion();
        this.conn = conexion.establecerConexion();
    }
    
    public ArrayList<Personal> lisPersonal(){
        ArrayList<Personal> listaPersonal = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.codPers, p.dniPers, c.tipoPers, "
                    + "p.nomPers, p.apePatPers, p.apeMatPers, p.areaPers, p.corrPers, p.telPers "
                    + "FROM Personal p INNER JOIN CuentaPersonal c ON c.codPers = p.codPers "
                    + "WHERE c.tipoPers = 'Bibliotecario'");
            while (rs.next()){
                String codPers = rs.getString("codPers");
                String dniPers = rs.getString("dniPers");
                String tipoPers = rs.getString("tipoPers");
                String nomPers = rs.getString("nomPers");
                String apPatPers = rs.getString("apePatPers");
                String apMatPers = rs.getString("apeMatPers");
                String areaPers = rs.getString("areaPers");
                String corrPers = rs.getString("corrPers");
                String telefPers = rs.getString("telPers");
                
                Personal personal = new Personal(codPers, dniPers, tipoPers, nomPers,
                 apPatPers, apMatPers, areaPers, corrPers, telefPers);
                listaPersonal.add(personal);
            }
        } catch (Exception e) {
            System.out.println("error al obtener datos del personal: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return listaPersonal;
    }
}
