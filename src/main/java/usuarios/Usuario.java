/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import items.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author ProfDiurno
 */
public class Usuario {

    private final String num;
    private String nombre, dni, telefono;
    private boolean estaSancionado;
    private final Item[] prestamos; //Opción estática, el final es interesante ya que no queremos que cambie prestamos, siempre tendrá 5 items
//    private It<em[] prestamos;P
    private TreeSet<Item> prestamosD;

    public Usuario(String num, String nombre, String dni, String telefono) {
        this.num = num;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.estaSancionado = false;
        this.prestamos = new Item[5];
        this.prestamosD = new TreeSet<>();
    }

    public String getNum() {
        return num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstaSancionado() {
        return estaSancionado;
    }

    public void setEstaSancionado(boolean estaSancionado) {
        this.estaSancionado = estaSancionado;
    }

    public boolean tomarItem(Item i) {
        if (i == null) { //i.esta
            return false;
        }
        if (i.isEstaPrestado()) { //i.esta
            return false;
        }
        if (this.isEstaSancionado()) { //this.estaSancionado
            return false;
        }
        for (int j = 0; j < prestamos.length; j++) {
            if (prestamos[j] == null) {
                this.prestamos[j] = i;
                i.setEstaPrestado(true);
                return true;
            }
        }
        return false; //si no hay espacios a null
    }

    public boolean tomarItemD(Item i) {
        if (i == null) { //i.esta
            return false;
        }
        if (i.isEstaPrestado()) { //i.esta
            return false;
        }
        if (this.isEstaSancionado()) { //this.estaSancionado
            return false;
        }
        if (this.prestamosD.size() == 5) {
            return false;
        }
        if (this.prestamosD.add(i)) {
            i.setEstaPrestado(true);
            return true;
        }
        return false; //Si ya tenía ese item prestado
    }

    public boolean devolverItem(Item i) {
        if (i == null) { //i.esta
            return false;
        }
        if (!i.isEstaPrestado()) { //i.esta
            return false;
        }
        for (int j = 0; j < prestamos.length; j++) {
            if (prestamos[j] != null) {
                if (this.prestamos[j] == i) {
                    i.setEstaPrestado(false);
                    prestamos[j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean devolverItemD(Item i) {
        if (i == null) { //i no existe
            return false;
        }
        if (!i.isEstaPrestado()) { //i no esta prestado
            return false;
        }
        if (this.prestamosD.contains(i)) {
            i.setEstaPrestado(false);
            return this.prestamosD.remove(i);
        }
        return false; //Si el usuario no tiene el prestamo
    }

    @Override
    public String toString() {
        if (estaSancionado) {
            return nombre + " (" + telefono + ") - SANCIONADO - \n PRESTAMOS\n"
                    + listadoUsuario();
        }
        return nombre + " (" + telefono + ") \n PRESTAMOS\n"
                + listadoUsuario();
    }
    
      public String toStringD() {
        if (estaSancionado) {
            return nombre + " (" + telefono + ") - SANCIONADO - \n PRESTAMOS\n"
                    + listadoUsuarioD();
        }
        return nombre + " (" + telefono + ") \n PRESTAMOS\n"
                + listadoUsuarioD();
    }

    public String listadoUsuario() {
        String libros = "LIBROS\n"
                + "ISBN\t\tNombre\t\t\tTema\n";
        for (int i = 0; i < prestamos.length; i++) {
            Item item = prestamos[i];
            if (item != null) { //innecesario por instanceOf
                if (item instanceof Libro) {
                    libros += item.toString() + "\n";
                }
            }
        }
        libros += "REVISTAS\n"
                + "EJEMPLAR\t\tNombre\t\t\tTema\n";
        for (Item item : prestamos) {
            if (item instanceof Revista) {
                libros += item.toString() + "\n";
            }
        }
        return libros;
    }

    public String listadoUsuarioD() {
        String libros = "LIBROS\n"
                + "ISBN\t\tNombre\t\t\tTema\n";
        for (Iterator<Item> iterator = prestamosD.iterator();
                iterator.hasNext();) {
            Item next = iterator.next();
            if (next instanceof Libro) {
                libros += next.toString() + "\n";
            }
        }
        libros += "REVISTAS\n"
                + "EJEMPLAR\t\tNombre\t\t\tTema\n";
        for (Item item : prestamosD) {
            if (item instanceof Revista) {
                libros += item.toString() + "\n";
            }
        }
        return libros;
    }

}
