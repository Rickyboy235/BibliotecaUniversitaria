/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Sala extends Servicio{
    private String CodSala;
    private String Nombre;
    private String Campus;
    private int Aforo;

    public Sala(String codServicio,String tipoServicio,String CodSala, String Nombre, String Campus, int Aforo, String Estado) {
        super(codServicio, tipoServicio);
        this.CodSala = CodSala;
        this.Nombre = Nombre;
        this.Campus = Campus;
        this.Aforo = Aforo;
    }
    
}
