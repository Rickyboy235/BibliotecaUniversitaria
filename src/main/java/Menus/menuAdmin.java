/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Credenciales.LoginAdmin;
import InsercionSql.InsersionMaterial;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class menuAdmin {
    private int eleccion;
    private int elecSM;
    private LoginAdmin logAd;
    private Connection conn;

    public menuAdmin(Connection conn, LoginAdmin logAd) {
        this.conn = conn;
        this.logAd = logAd;
    }
    Scanner teclado = new Scanner(System.in);

    public menuAdmin() {
    }

    public menuAdmin(int eleccion, int elecSM) {
        this.eleccion = eleccion;
        this.elecSM = elecSM;
    }
    
public void mostrarMenuPrincipal(){
    
    boolean banderaPrincipal = true;
    while(banderaPrincipal){
        do {
            System.out.println("-".repeat(72));
            System.out.println("""
                       MENU PRINCIPAL
                       1. gestionar materiales.
                       2. gestionar servicios.
                       3. gestionar reservas 
                       4. gestionar prestamos 
                       5. gestionar penalidades
                       0. cerrar sesion.""");
            eleccion = teclado.nextInt();
        } while (eleccion != 1 && eleccion != 0);
        switch (eleccion) {
            case 1 ->{
                InsersionMaterial inma = new InsersionMaterial(conn);
                boolean banderaCatalogo = true;
                while(banderaCatalogo) {
                    System.out.println("inserte material");
                    inma.insertarMaterial();
                }
            }
            case 2 ->{
                
            }
            case 3 ->{
                
            }
            case 4 ->{
                
            }
            case 5 ->{
                
            }
            case 0 ->{
                
            }
            default ->{
                
            }
        }
        
        
    }
}    
    public void mostrarCatalogo(){
        System.out.println("""
                           seleccion el codigo del material a gestionar
                           """);
        String codMaterial = teclado.nextLine();
        
    }
    public void buscarMaterialxCodigo(){
        System.out.println("buscando material por codigo....");
        //aca se busca el material por su codigo en la vase de datos 
        //ACA SE MUESTRA TAMBIEN EL MATERIAL A BUSCAR
    }
    public void buscarServicios(){
        System.out.println("buscando servicio por codigo...");
        //aca se busca el servicio por su codigo en la vase de datos 
        //ACA SE MUESTRA TAMBIEN EL MATERIAL A BUSCAR
    }
    public void visualizarPrestamos(){
        //el admin solo vera los prestamos reservas realizados ya que nadie debe 
        //manipular los registros         
    }
    
    public void modificarPenalidades(){
        //se agregara o eliminara la penalidad
        //NO ESTOY SEGURO SI ESTO ESTARA PARA EL FINAL TAMBIEN SU OPCION
        
    }
        public void gestionarCatalogo(){
            System.out.println("""
                               Gestion Materiales y Servicios
                               1. gestionar Materiales
                               2. gestionar Servicios
                               3. Atras""");
        }
                public void gestionMaterial(){
                    System.out.println("""
                                       Gestion Material
                                       1. Agregar Nuevo Material
                                       2. Modificar Material
                                       3. eliminar Material
                                       0. Atras""");
                }
                public void gestionarServicio(){
                    System.out.println("""
                                       Gestion Servicio
                                       1. Agregar Nuevo Servicio
                                       2. Modificar Servicio
                                       3. Eliminar Servicio
                                       0. Atras""");
                }       
}