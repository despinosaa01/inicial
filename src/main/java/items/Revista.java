/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author ProfDiurno
 */
public class Revista extends Item {

//    private String ejemplar;
    private int año, edicion;
    private String adjunto;

    public Revista(int año, int edicion, String adjunto, String codigo, int numPaginas, boolean estaPrestado, String titulo, String editorial, Tematica tematica) {
        super(codigo, numPaginas, estaPrestado, titulo, editorial, tematica);
        this.año = año;
        this.edicion = edicion;
        this.adjunto = adjunto;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(String adjunto) {
        this.adjunto = adjunto;
    }

    @Override
    public String toString() {
        return año + "-" + edicion + "\t" + this.getTitulo()
                + "\t" + this.getTematica();
    }

}
