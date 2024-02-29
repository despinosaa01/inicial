/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author ProfDiurno
 */
public abstract class Item implements Comparable<Item> {

    private final String codigo;
    private int numPaginas;
    private boolean estaPrestado;
    private String titulo, editorial;
    private Tematica tematica;

    public Item(String codigo, int numPaginas, boolean estaPrestado, String titulo, String editorial, Tematica tematica) {
        this.codigo = codigo;
        this.numPaginas = numPaginas;
        this.estaPrestado = estaPrestado;
        this.titulo = titulo;
        this.editorial = editorial;
        this.tematica = tematica;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public boolean isEstaPrestado() {
        return estaPrestado;
    }

    public void setEstaPrestado(boolean estaPrestado) {
        this.estaPrestado = estaPrestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    @Override
    public int compareTo(Item o) {
       return ((Integer) this.numPaginas).compareTo(o.numPaginas);
    }

}
