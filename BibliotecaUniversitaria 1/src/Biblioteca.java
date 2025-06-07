/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
// Clase principal para probar el sistema
public class Biblioteca {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Alejandro", "U23764332", "Arquitectura");
        alumno.setNombre("Lucero");
        alumno.setId("U23257713");
        alumno.setCarrera("Economia");
        
        Docente docente = new Docente("Maria", "C83847", "Calculo");
        docente.setNombre("Marco");
        docente.setId("C74938");
        docente.setEspecialidad("Estadistica");
        
        Libro libro = new Libro("Base de datos", "MySQL", 600);
        libro.setTitulo("POO");
        libro.setAutor("Samara Craford");
        libro.setPaginas(800);
        
        Multimedia multimedia = new Multimedia("Claves", "PATE", "Video");
        multimedia.setTitulo("Foreing");
        multimedia.setAutor("Sahara");
        multimedia.setFormato("Imagenes");
        
        Prestamo prestamo1 = new Prestamo(alumno, libro);
        Prestamo prestamo2 = new Prestamo(docente, multimedia);
        
        System.out.println("--Prestamos--");
        System.out.println("\n--Alumno--");
        prestamo1.mostrarDetalle();
        
        System.out.println("\n--Docente--");
        prestamo2.mostrarDetalle();
        
        AdministradorSistema admin = new AdministradorSistema();

        Usuario usuario = new Usuario("Carlos", "U001");
        Penalidad penalidad = new Penalidad("perdida", "P987", "13/05/2025", 50, "Pendiente");
        Categoria categoria = new Categoria("Programacion", "U1234", "Todo tipo de lenguaje");
        EventoBiblioteca evento = new EventoBiblioteca("Charla sobre IA", "E512", "Uso de inteligencia artificial en bibliotecas", "20/06/2025", "10:00AM", "Auditorio Central", 3);
        SugerenciaMaterial sugerencia1 = new SugerenciaMaterial("Más libros de Java", "S001", "Java avanzado", "Libro", "Aceptable");
        SugerenciaMaterial sugerencia2 = new SugerenciaMaterial("Mas videos", "S002", "Calculo avanzado", "Video", "Rechazada");
        System.out.println("\n--------------------------------------------------------------");
        
        System.out.println("\n--Penalidad--");
        admin.asignarPenalidad(usuario, penalidad);
        penalidad.mostrarInfo();
        
        
         System.out.println("\nCalculando monto total a pagar...");
        penalidad.calcularMontoTotal(); // Descuento se aplica y se muestra

        System.out.println("\n--monto actualizado--");
        penalidad.mostrarInfo();
        
        System.out.println("\nCargando...");
        penalidad.marcarComoPagado();
        
        System.out.println("\nCargando...");
        penalidad.anularPenalidad();
        
        System.out.println("\n--------------------------------------------------------------");
        
        System.out.println("\nAgregando Categoria...");
        System.out.println("Espere porfavor...");
        admin.agregarCategoria(categoria);
        categoria.mostrarInfo();
        
        System.out.println("\n--------------------------------------------------------------");
        
        System.out.println("\nGenerando Evento...");
        System.out.println("Espere porfavor...");
        admin.crearEvento(evento);
        
        System.out.println("\n--------------------------------------------------------------");
        
        System.out.println("\nGenerando Lista de Inscritos...");
        Usuario u1 = new Usuario("Carlos", "U345");
        Usuario u2 = new Usuario("Lucia", "U346");
        Usuario u3 = new Usuario("Maria", "U347");     
        
        evento.inscribirUsuario(u1);
        evento.inscribirUsuario(u2);
        evento.inscribirUsuario(u3);
        
        System.out.println("\n--------------------------------------------------------------");
        
        evento.verListaInscritos();
        
      System.out.println("\n--------------------------------------------------------------");
        
        System.out.println("\nRevisando Sugerencia...");
        System.out.println("Espere porfavor...");
        admin.gestionarSugerencia(sugerencia1);
        sugerencia1.mostrarInfo();
        sugerencia1.aprobarSugerencia();
        
        System.out.println("\nRevisando Sugerencia...");
        System.out.println("Espere porfavor...");
        admin.gestionarSugerencia(sugerencia2);
        sugerencia2.mostrarInfo();
        sugerencia2.aprobarSugerencia();
        
        
        HistorialAcceso ha = new HistorialAcceso("HA001", "12/05/2025", "11:05 AM", "Valido");
        Usuario usuario1 = new Usuario("Mario", "U100");
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("\n--Historial--");
        ha.registrarAcceso(usuario1);
        ha.filtrarFecha();
        ha.mostrarHistorialUsuario();
        
        System.out.println("\n--------------------------------------------------------------");
        HistorialAcceso ha1 = new HistorialAcceso("HA001", "12/05/2025", "11:05 AM", "Invalido");
        Usuario usuario2 = new Usuario("Alonso", "U101");
        ha1.registrarAcceso(usuario2);
        ha1.filtrarFecha();
        ha1.mostrarHistorialUsuario();
        
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("--Materiales Recomendados");
        RecomendacionMaterial rm = new RecomendacionMaterial("R0002", "Cien Años De Soledad", "Aprendizaje");
        Usuario user = new Usuario("Enrique", "U0001");
        rm.verRecomendacionUsuario(user);
        rm.marcarComoVisto();
        
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("--Materiales Recomendados");
        RecomendacionMaterial rm1 = new RecomendacionMaterial("R0001", "Cien Años De Soledad", "NULL");
        Usuario user1 = new Usuario("Marco", "U0002");
        rm.verRecomendacionUsuario(user1);
        rm1.marcarComoVisto();
   }
}

