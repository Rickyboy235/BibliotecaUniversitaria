/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Credenciales.LoginUsuario;
import InsercionSql.InsercionSolicitud;
import VisualizacionSql.VisualizarMaterial;
import VisualizacionSql.VisualizarServicio;
import VisualizacionSql.VisualizarSolicitud;
import VisualizacionSql.VisualizarUsuario;
import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.Computadora;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
import com.mycompany.sp1.Sala;
import com.mycompany.sp1.Solicitud;
import com.mycompany.sp1.Tesis;
import com.mycompany.sp1.Video;
import java.sql.Connection;
import java.util.Scanner;


public class menuUsuario {
    
    private LoginUsuario usuario;
    private int eleccion;
    private int elecMaterial;
    private int elecServicio;
    private Connection conn;
    
    
    public menuUsuario(Connection conn, LoginUsuario usuario) {
        this.conn = conn;
        this.usuario = usuario;
    }
    Scanner teclado = new Scanner(System.in);

    public menuUsuario() {
    }

    public menuUsuario(int eleccion, int elecMaterial,int elecServicio) {
        this.eleccion = eleccion;
        this.elecMaterial = elecMaterial;
        this.elecServicio = elecServicio;
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
                           2. visualizar servicios.
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
                        System.out.println("""
                                           desea visualizar un Libro en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            Libro libroseleccionado = vmat.matSelecLibro(vmat.listLibros());
                            
                            //visualizar el libro que ingreso el usuario..
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");
                            System.out.println("Código del material seleccionado: " + lib.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoLibro(eleccion, libroseleccionado);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
                    }
                    case 2 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Revista rev = new Revista();                        
                        rev.mostrarRegistros(vmat.listRevistas());
                        System.out.println("""
                                           desea visualizar una revista en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            Revista revistaSelec = vmat.matSelecRevista(vmat.listRevistas());                            
                            //visualizar el libro que ingreso el usuario..
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");               
                            System.out.println("Código del material seleccionado: " + rev.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoRevista(eleccion, revistaSelec);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
                    }
                    case 3 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Tesis tes = new Tesis();                                              
                        tes.mostrarRegistros(vmat.listTesis());
                        System.out.println("""
                                           desea visualizar una tesis en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            Tesis tesisSelec = vmat.matSelecTesis(vmat.listTesis());                            
                            //visualizar el libro que ingreso el usuario..
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");  
                            System.out.println("Código del material seleccionado: " + tes.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoTesis(eleccion, tesisSelec);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
                    }
                    case 4 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        Video vid = new Video();
                        vid.mostrarRegistros(vmat.listVideos());
                        System.out.println("""
                                           desea visualizar un video en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            Video videoSelec = vmat.matSelecVideo(vmat.listVideos());                            
                            //visualizar el libro que ingreso el usuario..
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");  
                            System.out.println("Código del material seleccionado: " + vid.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoVideo(eleccion, videoSelec);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
                    }
                    case 5 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        AudioLibro aLib = new AudioLibro();
                        aLib.mostrarRegistros(vmat.listALibro());
                        System.out.println("""
                                           desea visualizar un audiolibro en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            AudioLibro ALibroSelec = vmat.matSelecALibro(vmat.listALibro());                            
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");  
                            System.out.println("Código del material seleccionado: " + aLib.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoALibro(eleccion, ALibroSelec);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
                    }
                    case 6 ->{
                        VisualizarMaterial vmat = new VisualizarMaterial();
                        DispositivoElectronico dispElect = new DispositivoElectronico();
                        dispElect.mostrarRegistros(vmat.listDElec());                        
                        System.out.println("""
                                           desea visualizar un dispositivo electronico en especifico?
                                           1. si.
                                           2. no.""");
                        int elecVisual = teclado.nextInt();
                        if (elecVisual ==1) {
                            DispositivoElectronico DispElecSelec = vmat.matSelecDispElec(vmat.listDElec());                            
                            
                            System.out.println("""
                                                    desea realizar el prestamo de este material?
                                                    1. si
                                                    2. no""");  
                            System.out.println("Código del material seleccionado: " + dispElect.getCodMaterial());
                                 int elecPrest = teclado.nextInt();
                                 if (elecPrest == 1) {
                                 InsercionSolicitud isol = new InsercionSolicitud(conn);                                 
                                 isol.insertarSolicitud(usuario);
                                 isol.prestamoDispElectronico(eleccion, DispElecSelec);
                                 }else{
                                     vmat.cerrarConexion();
                                    banderaCatalogo = false;
                                 }
                        } else {    
                          vmat.cerrarConexion();
                        banderaCatalogo = false;
                        }
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
                boolean banderaSol = true;
                while(banderaSol){
                int eleccionServ;
                verServicios();
                eleccionServ = teclado.nextInt();
                switch(eleccionServ){
                    case 1 ->{
                        VisualizarServicio vser = new VisualizarServicio();
                        Sala sala = new Sala();
                        sala.mostrarRegistro(vser.listSalas());
                        System.out.println("""
                                           esta interesado en alguna sala?
                                           1. si.
                                           2. no""");
                        int elecVer = teclado.nextInt();
                        if (elecVer == 1) {
                            Sala salaSelecc = vser.matSelecSala(vser.listSalas());
                            System.out.println("""
                                               dese realizar la reserva de esta sala
                                               1. si
                                               2. no""");
                            int elecRev = teclado.nextInt();
                            if (elecRev == 1) {
                                InsercionSolicitud isol = new InsercionSolicitud(conn);
                                isol.insertarSolResev(usuario);
                                isol.reservaSala(salaSelecc);
                            }else{
                                vser.cerrarConexion();
                                banderaSol = false;
                            }
                        }else{
                            vser.cerrarConexion();
                                banderaSol = false;
                        }
                        
                    }
                    case 2 ->{
                        VisualizarServicio vser = new VisualizarServicio();
                        Computadora computadora = new Computadora();
                        computadora.mostrarRegistro(vser.listComputadoras());
                        System.out.println("""
                                           esta interesado en alguna computadora?
                                           1. si.
                                           2. no""");
                        int elecVer = teclado.nextInt();
                        if (elecVer == 1) {
                            Computadora compuSelecc = vser.matSelecComputadora(vser.listComputadoras());
                            System.out.println("""
                                               desea realizar la reserva de esta computadora?
                                               1. si
                                               2. no""");
                            int elecRev = teclado.nextInt();
                            if (elecRev == 1) {
                                InsercionSolicitud isol = new InsercionSolicitud(conn);
                                isol.insertarSolResev(usuario);
                                isol.reservaComputadora(compuSelecc);
                            }else{
                                vser.cerrarConexion();
                                banderaSol = false;
                            }
                        }else{
                            vser.cerrarConexion();
                                banderaSol = false;
                        }
                        
                    }
                    case 0 ->{
                        banderaSol = false;                                              
                    }
                    default ->{
                        System.out.println("error eleccion registro");
                    }
                }
                }
            }
            case 3->{
                VisualizarSolicitud vsol = new VisualizarSolicitud();
                   Solicitud solicitud = new Solicitud();
                   solicitud.mostrarHistorial(vsol.listHistorial(usuario));
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
    public void verServicios(){
        System.out.println("-".repeat(72));
        System.out.println("""
                           SERVICIOS
                           1. Reserva de Salas de estudio.
                           2. Rserva de Computadoras.
                           0. Atras""");
    }
    
}
