/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class HistorialAcceso {
    private String idHistorial;
    private String fechaAcceso;
    private String horaAcceso;
    private String tipoAcceso;
    public HistorialAcceso(String idHistorial, String fechaAcceso, String horaAcceso, String tipoAcceso) {
        this.idHistorial = idHistorial;
        this.fechaAcceso = fechaAcceso;
        this.horaAcceso = horaAcceso;
        this.tipoAcceso = tipoAcceso;
    }
    public String getIdHistorial() {
        return idHistorial;
    }
    public void setIdHistorial(String idHistorial) {
        this.idHistorial = idHistorial;
    }
    public String getFechaAcceso() {
        return fechaAcceso;
    }
    public void setFechaAcceso(String fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }
    public String getHoraAcceso() {
        return horaAcceso;
    }
    public void setHoraAcceso(String horaAcceso) {
        this.horaAcceso = horaAcceso;
    }
    public String geTipoAcceso() {
        return tipoAcceso;
    }
    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }
    public void registrarAcceso(Usuario u) {
        if(tipoAcceso.equalsIgnoreCase("Valido")) {
            System.out.println(u.getNombre() + " con el ID " + u.getId() + " Se ha registrado con exito ");
        }
        else
        {
            System.out.println("No se ha podido acceder al Historial de " + u.getNombre() + " con el ID " + u.getId());
        }
    }
    public void filtrarFecha() {
        if(tipoAcceso.equalsIgnoreCase("Valido")) {
           System.out.println("Ha accedido el dia " + fechaAcceso + " A las " + horaAcceso);
        }
        else
        {
         System.out.println("NULL");
        }
        
    }
    public void mostrarHistorialUsuario() {
        if(tipoAcceso.equalsIgnoreCase("Valido")) {
            System.out.println("Busquedas relizadas:");
        }
        else
        {
          System.out.println("NULL");  
        }   
}
}
