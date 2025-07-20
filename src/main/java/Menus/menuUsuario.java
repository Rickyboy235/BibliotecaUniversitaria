/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Credenciales.LoginUsuario;
import InsercionSql.InsercionSolicitud;
import VisualizacionSql.VisualizarMaterial;
import VisualizacionSql.VisualizarUsuario;
import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
import com.mycompany.sp1.Solicitud;
import com.mycompany.sp1.Tesis;
import com.mycompany.sp1.Video;
import java.sql.Connection;
import java.util.Scanner;


public class menuUsuario {
    
    private LoginUsuario usuario;
    private int eleccion;
    private int elecMaterial;
    private Connection conn;
    
    
    public menuUsuario(Connection conn, LoginUsuario usuario) {
        this.conn = conn;
        this.usuario = usuario;
    }
    Scanner teclado = new Scanner(System.in);

    public menuUsuario() {
    }

    public menuUsuario(int eleccion, int elecMaterial) {
        this.eleccion = eleccion;
        this.elecMaterial = elecMaterial;
    }
    
    
    public void menuUser(){
        boolean banderaPrincipal = true;
        while(banderaPrincipal){
        do {
            System.out.println("-".repeat(72));
            System.out.println("""
                           Menu principal.
                           Ingrese la opcion que desee realizar.
                           1. visualizar catalogo.
                           2. realizar solicitud.
                           3. ver historial.                           
                           0. cerrar sesion.""");
            //4. configuracion Cuenta
            eleccion = teclado.nextInt();
        } while (eleccion != 1 && eleccion != 2 && eleccion != 3 &&
                eleccion != 0);
        switch(eleccion){
            case 1->{
                boolean banderaCatalogo = true;
                while (banderaCatalogo) {
                    verCatalogo(); 
                    System.out.print("Seleccione el tipo de material (0 para volver): ");
                elecMaterial = teclado.nextInt();
                switch(elecMaterial){
                    case 1 ->{                        
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Libro lib = new Libro();                        
                        lib.mostrarRegistros(vmat.listLibros());
                        banderaCatalogo = false;
                    }
                    case 2 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Revista rev = new Revista();
                        rev.mostrarRegistros(vmat.listRevistas());
                        banderaCatalogo = false;
                    }
                    case 3 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Tesis tes = new Tesis();
                        tes.mostrarRegistros(vmat.listTesis());
                        banderaCatalogo = false;
                    }
                    case 4 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Video vid = new Video();
                        vid.mostrarRegistros(vmat.listVideos());
                        banderaCatalogo = false;
                    }
                    case 5 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        AudioLibro aLib = new AudioLibro();
                        aLib.mostrarRegistros(vmat.listALibro());
                        banderaCatalogo = false;
                    }
                    case 6 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        DispositivoElectronico dispElect = new DispositivoElectronico();
                        dispElect.mostrarRegistros(vmat.listDElec());
                        banderaCatalogo = false;
                    }
                    case 0 ->{
                        System.out.println("Regresando a Menu Principal");
                        banderaCatalogo = false;
                    }
                    default ->{
                        System.out.println("ingrese una opcion correcta");
                        banderaCatalogo = false;
                    }
                }
                }
            }
            case 2->{
                int eleccionSolicitud;
                realizarSolicitud();
                eleccionSolicitud = teclado.nextInt();                                
                InsercionSolicitud isol = new InsercionSolicitud(conn);                                
                        isol.insertarSolicitud(usuario);
                /*switch (eleccionSolicitud){
                    case 1 ->{
                        System.out.println("""
                                           ingrese el tipo de material que desee prestarse
                                           1. Libro
                                           2. Revista
                                           3. Tesis
                                           4. Video
                                           5. AudioLibro
                                           """);
                        int eleccionMaterial = teclado.nextInt();
                        
                    }
                }*/
            }
            case 3->{
                //SE MOSTRARAN SU HISTORIAL DE SOLICITUDES EN LA BIBLIOTECA EN RELACION
                //A SU CODIGO
                //TAMBIEN DEBERIAMOS ALMACENAR SU CODIGO AL MOMENTO DE INICIAR SESION
            }
            case 4 ->{
                /*int eleccionOpcion ;
                VisualizarUsuario vusu = new VisualizarUsuario();
                Usuario usuario = new Usuario();
                dispElect.mostrarRegistros(vmat.listDElec());*/
                
            }
            case 0->{
                System.out.println("cerrando sesion...");
                banderaPrincipal = false;
            }
            default->{
                System.out.println("error en switch eleccion");
            }
        }
        }
    }
    public void verCatalogo(){
        System.out.println("-".repeat(72));
        System.out.println("""
                           Catalogo:
                           seleccione que material desea visualizar.
                           1. Libros.
                           2. Revistas.
                           3. Tesis.
                           4. Videos.
                           5. Audiolibros.
                           6. Dispositivos Electronicos.
                           0. Atras.""");
    }
    public void realizarSolicitud(){
        System.out.println("""
                           Crear Solicitud
                           seleccione que tipo de solicitud desea realizar:
                           1. prestamo.
                           2. reserva.
                           0. Atras""");
    }
    public void crearPrestamo(){
        System.out.println("-".repeat(72));
        System.out.println("""
                           Realizar Prestamo.
                           Ingrese el nombre del material""");
        String nombre = teclado.nextLine();
    }     
    
}
