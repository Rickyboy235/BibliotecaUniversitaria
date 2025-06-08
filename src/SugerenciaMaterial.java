/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class SugerenciaMaterial {
    private String descripcion;
    private String idSugerencia;
    private String tituloPropuesto;
    private String tipoMaterial;
    private String estado;

    public SugerenciaMaterial(String descripcion, String idSugerencia, String tituloPropuesto, String tipoMaterial, String estado) {
        this.descripcion = descripcion;
        this.idSugerencia = idSugerencia;
        this.tituloPropuesto = tituloPropuesto;
        this.tipoMaterial = tipoMaterial;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getIdSugerencia() {
        return idSugerencia;
    }
    public void setIdSugerencia(String idSugerencia) {
        this.idSugerencia = idSugerencia;
    }
    public String getTituloPropuesto() {
        return tituloPropuesto;
    }
    public void setTituloPropuesto(String tituloPropuesto) {
        this.tituloPropuesto = tituloPropuesto;
    }
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void aprobarSugerencia() {
         if (estado.equalsIgnoreCase("Aceptable")) {
            System.out.println("La sugerencia ha sido aceptada.");
        } else if (estado.equalsIgnoreCase("Rechazada")) {
            System.out.println("La sugerencia ha sido rechazada.");
        } else {
            System.out.println("La sugerencia sigue en revisión.");
        }
    }
    public void mostrarInfo() {
        System.out.println("Id de Sugerencia: " + idSugerencia );
        System.out.println("Titulo: " + tituloPropuesto);
        System.out.println("Tipo de Material: " + tipoMaterial);
    }
}
