/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Computadora extends Servicio{
    private String codPC;
    private String marca;
    private String modelo;
    private String ram;
    private String SO;
    private String ubicacion;

    public Computadora(String codServicio, String tipoServicio,String codPC, String marca, String modelo, String ram,String SO, String ubicacion) {
        super(codServicio, tipoServicio);
        this.codPC = codPC;
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.SO = SO;
        this.ubicacion = ubicacion;
    }
}
