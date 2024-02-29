/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author ProfDiurno
 */
public class Libro extends Item {
    
    private String autor, ISBN;

    public Libro(String codigo, int numPaginas, boolean estaPrestado, String titulo, 
            String editorial, Tematica tematica, String autor, String ISBN) {
        super(codigo, numPaginas, estaPrestado, titulo, editorial, tematica);
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return ISBN + "\t" + super.getTitulo() + "\t" + 
                super.getTematica().toString().toLowerCase();
    }
    
  
    
}
