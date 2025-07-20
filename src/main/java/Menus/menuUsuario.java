/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menus;

import Credenciales.LoginUsuario;
import InsercionSql.InsercionSolicitud;
import VisualizacionSql.VisualizarMaterial;
import com.mycompany.sp1.AudioLibro;
import com.mycompany.sp1.DispositivoElectronico;
import com.mycompany.sp1.Libro;
import com.mycompany.sp1.Revista;
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

    public void menuUser() {
        boolean banderaPrincipal = true;
        while (banderaPrincipal) {
            do {
                System.out.println("-".repeat(72));
                System.out.println("""
                        Menu principal.
                        Ingrese la opcion que desee realizar.
                        1. Visualizar catálogo.
                        2. Realizar solicitud.
                        3. Ver historial.
                        0. Cerrar sesión.""");
                eleccion = teclado.nextInt();
                teclado.nextLine(); // limpiar buffer
            } while (eleccion != 1 && eleccion != 2 && eleccion != 3 && eleccion != 0);

            switch (eleccion) {
                case 1 -> {
                    boolean banderaCatalogo = true;
                    while (banderaCatalogo) {
                        verCatalogo();
                        System.out.print("Seleccione el tipo de material (0 para volver): ");
                        elecMaterial = teclado.nextInt();
                        switch (elecMaterial) {
                            case 1 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                Libro lib = new Libro();
                                lib.mostrarRegistros(vmat.listLibros());
                            }
                            case 2 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                Revista rev = new Revista();
                                rev.mostrarRegistros(vmat.listRevistas());
                            }
                            case 3 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                Tesis tes = new Tesis();
                                tes.mostrarRegistros(vmat.listTesis());
                            }
                            case 4 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                Video vid = new Video();
                                vid.mostrarRegistros(vmat.listVideos());
                            }
                            case 5 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                AudioLibro aLib = new AudioLibro();
                                aLib.mostrarRegistros(vmat.listALibro());
                            }
                            case 6 -> {
                                VisualizarMaterial vmat = new VisualizarMaterial();
                                DispositivoElectronico disp = new DispositivoElectronico();
                                disp.mostrarRegistros(vmat.listDElec());
                            }
                            case 0 -> {
                                System.out.println("Regresando al menú principal...");
                                banderaCatalogo = false;
                            }
                            default -> System.out.println("Ingrese una opción válida.");
                        }
                    }
                }

                case 2 -> {
                    realizarSolicitud();
                    int eleccionSolicitud = teclado.nextInt();
                    teclado.nextLine(); // limpiar buffer

                    if (eleccionSolicitud == 1) {
                        // Préstamo normal
                        InsercionSolicitud isol = new InsercionSolicitud(conn);
                        isol.insertarSolicitud(usuario);
                    } else if (eleccionSolicitud == 2) {
                        // Reservas (salas o PCs)
                        MenuReserva menuReserva = new MenuReserva();
                        menuReserva.mostrarMenuReservas();
                    } else if (eleccionSolicitud == 0) {
                        System.out.println("Volviendo al menú principal...");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                }

                case 3 -> {
                    System.out.println("Función de historial en construcción.");
                    // Aquí puedes implementar la visualización del historial del usuario
                }

                case 0 -> {
                    System.out.println("Cerrando sesión...");
                    banderaPrincipal = false;
                }

                default -> System.out.println("Error en la elección.");
            }
        }
    }

    public void verCatalogo() {
        System.out.println("-".repeat(72));
        System.out.println("""
                Catálogo:
                Seleccione qué material desea visualizar.
                1. Libros.
                2. Revistas.
                3. Tesis.
                4. Videos.
                5. Audiolibros.
                6. Dispositivos Electrónicos.
                0. Atrás.""");
    }

    public void realizarSolicitud() {
        System.out.println("""
                Crear Solicitud
                Seleccione el tipo de solicitud:
                1. Préstamo.
                2. Reserva.
                0. Atrás.""");
    }
}
