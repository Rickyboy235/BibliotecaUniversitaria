/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import VisualizacionSql.VisualizarMaterial;
import VisualizacionSql.VisualizarSolicitud;
import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
import com.mycompany.sp1.Solicitud;
import com.mycompany.sp1.Tesis;
import com.mycompany.sp1.Video;
import java.util.Scanner;

/**
 *
 * @author ATKZ
 */
public class menuPersonal {
    
    Scanner teclado = new Scanner(System.in);
        private int eleccion;
        private int elecOpc;
    public void menuPersonal(){
        boolean banderaPrincipal = true;
        while (banderaPrincipal){
            do {                
                System.out.println("-".repeat(72));
                System.out.println("""
                           Menu principal.
                           Ingrese la opcion que desee realizar.
                           1. visualizar catalogo.
                           2. visualizar solicitudes.
                           3. aceptar/rechazar solicitudes.
                           4. ingresar Devolucion.
                           0. cerrar sesion.""");
            eleccion = teclado.nextInt();
            } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 0);
           switch(eleccion){
               case 1-> {
                   boolean banderaCatalogo = true;
                while (banderaCatalogo) {
                    verCatalogo(); 
                    System.out.print("Seleccione el tipo de material (0 para volver): ");
                    elecOpc = teclado.nextInt();
                switch(elecOpc){
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
                   boolean banderaSolicitud = true;
                   while (banderaSolicitud) {
                   VisualizarSolicitud vsol = new VisualizarSolicitud();
                   Solicitud solicitud = new Solicitud();
                   solicitud.mostrarSolicitudes(vsol.listSolicitud());
                   banderaSolicitud = false;
                   }
               }
               case 3 ->{                  
                   boolean bandSolicitud = true;
                   while(bandSolicitud) {
                    VisualizarSolicitud vsol = new VisualizarSolicitud();
                   Solicitud solicitud = new Solicitud();
                   solicitud.mostrarSolicitudes(vsol.listEspera());                       
                    bandSolicitud = false;
                   }
               }
               case 4 ->{
                   boolean bandSolicitud = true;
                   while(bandSolicitud) {
                       menuDevolucion();
                       elecOpc = teclado.nextInt();
                       switchDevolucion(elecOpc);
                       
                   }
               }
               case 0 ->{
                   System.out.println("cerrando sesion...");
                   banderaPrincipal = false;
               }
            }
        }
    }

    public void agQuiMaterial(){
        System.out.println("""
                           seleccione la opcion que desea realizar
                           1. Agregar Material.
                           2. Quitar Material.
                           0. Atras.""");
    }
    public void menuDevolucion(){
        System.out.println("""
                           ingrese el tipo de devolucion
                           1. Prestamo
                           2. Rserva""");
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
    public void verSolicitudes(){
        VisualizarSolicitud vsol = new VisualizarSolicitud();
        Solicitud solicitud = new Solicitud();
        solicitud.mostrarSolicitudes(vsol.listSolicitud());
    }
    public void verSoliEspera(){
        VisualizarSolicitud vsol = new VisualizarSolicitud();
        Solicitud solicitud = new Solicitud();
        solicitud.mostrarSolicitudes(vsol.listEspera());
    }
    public void switchDevolucion(int elecOpc){
        switch(elecOpc){
            case 1 ->{
                int tipDevolucion;
                int codSoli;
                VisualizarSolicitud vsol = new VisualizarSolicitud();
                Solicitud solicitud = new Solicitud();
                solicitud.mostrarSolicitudes(vsol.listPrestamos());
                System.out.println("""
                                   ingrese el codigo de solicitud""");
                codSoli = teclado.nextInt();
                System.out.println("""
                                   seleccione el tipo de devolucion
                                   1. devolucion sin penalidad
                                   2. devolucion con penalidad""");
                tipDevolucion = teclado.nextInt();
                switch (tipDevolucion){
                    case 1 ->{
                        System.out.println("""
                                           ingrese el codigo del libro""");
                        String cod = teclado.nextLine();
                    }
                    case 2 ->{
                        System.out.println("""
                                           ingrese el codigo de prestamo""");
                        String codPrest = teclado.nextLine();
                        System.out.println("buscando prestamo...");
                        //aca va el registro del prestamo
                        System.out.println("""
                                           ingrese el tipo de la penalidad
                                           1. tiempo
                                           2. estado del material""");
                        // aca se modificca el registro para la penalidad
                        //y tambien al usuario se le pone un strike
                        //si este llega a 3 strikes se le inhabilita de realizar prestamos 
                        
                    }
                }
            }
            case 2 ->{
                VisualizarSolicitud vsol = new VisualizarSolicitud();
                Solicitud solicitud = new Solicitud();
                solicitud.mostrarSolicitudes(vsol.listReservas());
            }
        }
    }
    public void tipoDevolucion(int tipDevolucion, int codSoli){
        switch (tipDevolucion){
            case 1 ->{
                System.out.println("mostrara el registro que segin el indice ingreso(solo 1)");
                
            }
        }
    }
}
