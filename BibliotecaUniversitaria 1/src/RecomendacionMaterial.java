/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class RecomendacionMaterial {
    private String idRecomendacion;
    private String recomendacion;
    private String razon;
    
    
    public RecomendacionMaterial(String idRecomendacion, String recomendacion, String razon) {
        this.idRecomendacion = idRecomendacion;
        this.recomendacion = recomendacion;
        this.razon = razon;
    }
    public String getIdRecomendacion() {
        return idRecomendacion;
    }
    public void setIdRecomendacion(String idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }
    public String getRecomendacion() {
        return recomendacion;
    }
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }
    public void verRecomendacionUsuario(Usuario u) {
        System.out.println(u.getNombre() + " con el ID " + u.getId() + " recomendo el material " + recomendacion);
    }
    public void marcarComoVisto() {
        if(razon.equalsIgnoreCase("NULL")) {
            System.out.println("No sido visto");
        }
        else
        {
            System.out.println("Esto ha sido visto");
        }
    }
}

