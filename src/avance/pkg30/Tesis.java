/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avance.pkg30;

/**
 *
 * @Mikell
 */
public class Tesis extends MaterialBibliografico {
    private String institucion;
    private String programaAcademico;
    private String tipoGrado; 
    private String anioDefensa;

    public Tesis(String titulo, String autor, String institucion, String programaAcademico, String tipoGrado, String anioDefensa) {
        super(titulo, autor); 
        this.institucion = institucion;
        this.programaAcademico = programaAcademico;
        this.tipoGrado = tipoGrado;
        this.anioDefensa = anioDefensa;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    public String getTipoGrado() {
        return tipoGrado;
    }

    public void setTipoGrado(String tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

    public String getAnioDefensa() {
        return anioDefensa;
    }

    public void setAnioDefensa(String anioDefensa) {
        this.anioDefensa = anioDefensa;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Tesis");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor (Tesista): " + autor);
        System.out.println("Institucion: " + institucion);
        System.out.println("Programa Academico: " + programaAcademico);
        System.out.println("Tipo de Grado: " + tipoGrado);
        System.out.println("Año de Defensa: " + anioDefensa);
    }

    public boolean esDePosgrado() {
        return tipoGrado.equalsIgnoreCase("Maestria") || tipoGrado.equalsIgnoreCase("Doctorado");
    }
}
