/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package clase.biblioteca;

import com.github.javafaker.Faker;
import items.Item;
import items.Libro;
import items.Revista;
import items.Tematica;
import java.util.Locale;
import java.util.Random;
import usuarios.Usuario;

/**
 *
 * @author ProfDiurno
 */
public class Biblioteca {

    public static void main(String[] args) {
        Faker f = new Faker(new Locale("es"));
        Random r = new Random();

        bibliotecas.Biblioteca b = new bibliotecas.Biblioteca(r.nextInt(1, 5),
                r.nextInt(20, 200),
                f.artist().name(), f.address().fullAddress());

        for (int i = 1; i < 101; i++) {
            b.altaItem(new Libro(i + "",
                    r.nextInt(50, 100),
                    false, f.book().title(),
                    f.book().publisher(), Tematica.ROMANCE,
                    f.book().author(), f.code().isbn13() + ""));
            b.altaItem(new Revista(f.date().birthday().getYear(),
                    r.nextInt(1, 12), "Sin adjunto", ++i + "",
                    r.nextInt(50, 100),
                    false, f.book().title(),
                    f.book().publisher(), Tematica.ROMANCE));
        }
        
        System.out.println(b.listadoPorTema(Tematica.AVENTURAS));
        
        Usuario u = new Usuario("1", f.name().fullName(),
                null, f.phoneNumber().cellPhone());
        Usuario uDinamico = new Usuario("2", f.name().fullName(),
                null, f.phoneNumber().cellPhone());

        for (int i = 1; i < 5; i++) {
            if (u.tomarItem(b.getItem(i + ""))) {
                System.out.println("Prestamo correcto");
            } else {
                System.out.println("Error al realizar prestamo");
            }
            if (uDinamico.tomarItemD(b.getItem(i + 10 + ""))) {
                System.out.println("Prestamo correcto");
            } else {
                System.out.println("Error al realizar prestamo");
            }
        }
        
        System.out.println(u);
        System.out.println("--------------------");
        System.out.println(uDinamico.toStringD());
        
        for (int i = 1; i < 5; i++) {
            if (u.devolverItem(b.getItem(i + ""))) {
                System.out.println("Devolución correcta");
            } else {
                System.out.println("Error al realizar devolucion");
            }
        }

    }
}
