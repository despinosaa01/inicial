/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecas;

import items.Item;
import items.Libro;
import items.Revista;
import items.Tematica;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ProfDiurno
 */
public class Biblioteca {

    private int secciones, plazas;
//    private int numItems;
    private String nombre, direccion;
    private TreeMap<String, Item> fondo;

    public Biblioteca(int secciones, int plazas, String nombre, String direccion) {
        this.secciones = secciones;
        this.plazas = plazas;
        this.nombre = nombre;
        this.direccion = direccion;
//        numItems = 0;
        this.fondo = new TreeMap<>();
    }

    public int numeroItems() {
        return this.fondo.size();
    }
//    public int numeroItems() {
//        return this.numItems;
//    }

    public int getSecciones() {
        return secciones;
    }

    public void setSecciones(int secciones) {
        this.secciones = secciones;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean altaItem(Item i) {
        if (fondo.containsKey(i.getCodigo())) {
            return false;
        }
        fondo.put(i.getCodigo(), i);
//        numItems++;
        return true;
    }

    public boolean bajaItem(Item i) {
        if (!fondo.containsKey(i.getCodigo())) {
            return false;
        }
        fondo.remove(i.getCodigo(), i);
//        fondo.remove(i.getCodigo());
//        numItems--;
        return true;
    }

//    public void errorItem(Item i) {
//        if (fondo.containsKey(i.getCodigo())) {
//            throw new IllegalArgumentException("Ya teníamos ese ejemplar");
//        }
//        fondo.put(i.getCodigo(), i);
//    }
    public String listaLibros() {
        String libros = "LIBROS DISPONIBLES\n"
                + "ISBN\t\tNombre\t\t\tTema\n";
        for (Map.Entry<String, Item> entry : fondo.entrySet()) {
            Item item = entry.getValue();
            if (item instanceof Libro) {
                if (!item.isEstaPrestado()) {
                    libros += item.toString() + "\n";
                }
            }
        }
        return libros;
    }

    public String listaRevistas() {
        String revistas = "REVISTAS DISPONIBLES\n"
                + "Ejeplar\t\t\tNombre\t\t\tTema\n";
        for (Map.Entry<String, Item> entry : fondo.entrySet()) {
            Object val = entry.getValue();
            if (val instanceof Revista) {
                if (!((Revista) val).isEstaPrestado()) {
                    revistas += val + "\n";
                }
            }
        }
        return revistas;
    }

    public String listadoFondo() {
        return listaLibros()
                + "\n\n" + listaRevistas();
    }

    public String listadoPorTema(Tematica t) {
        String libros = "LIBROS de temática " + t + "\n"
                + "ISBN\t\tNombre\t\t\tTema\n";
        for (Map.Entry<String, Item> entry : fondo.entrySet()) {
            Item item = entry.getValue();
            if (item instanceof Libro) {
                if (item.getTematica().equals(t)) {
                    libros += item.toString() + "\n";
                }
            }
        }
        return libros;
    }

    public Item getItem(String clave) {
        return this.fondo.get(clave); //devuelve null o el Item buscado
    }

}
