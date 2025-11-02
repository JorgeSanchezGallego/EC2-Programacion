package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Catalogo catalogo = new Catalogo();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    private static void cargarDatos(){
        catalogo.alta(new Libro(1, "El Quijote", "1608", Formato.FISICO,"22342455", "Cervantes"));
        catalogo.alta(new Libro(2, "El nombre del viento", "2007", Formato.FISICO,"223245234", "Patrick Rothfuss"));
        catalogo.alta(new Pelicula(3, "El Padrino", "1972", Formato.FISICO,"Francis Ford", 175));
        catalogo.alta(new Pelicula(4, "Parasitos", "2019", Formato.FISICO,"Bong Joon-ho", 132));
        catalogo.alta(new Videojuego(5, "Call Of Duty", "2022", Formato.DIGITAL, "18", Genero.SHOOTER, Plataforma.PC));
        catalogo.alta(new Videojuego(7, "Mario Kart 8 Deluxe", "2017", Formato.FISICO, "3", Genero.DEPORTES, Plataforma.SWITCH));
        catalogo.alta(new Videojuego(8, "StarCraft II", "2010", Formato.DIGITAL, "16", Genero.ESTRATEGIA, Plataforma.PC));
        catalogo.alta(new Merchandising(9, "Funko Pop: Darth Vader", "2021", Formato.FISICO, "Figura", 15.99));
        catalogo.alta(new Merchandising(10, "Camiseta Logo Zelda", "2023", Formato.FISICO, "Ropa", 22.50));
        catalogo.alta(new Merchandising(11, "Taza Casa Stark (GoT)", "2019", Formato.FISICO, "Taza", 12.95));
        catalogo.alta(new Merchandising(12, "Póster The Last of Us", "2022", Formato.FISICO, "Póster", 9.99));

        usuarios.add(new Usuario(1,"Jorge"));
        usuarios.add(new Usuario(2,"Maria"));
    }

    private static void menu(){
        int opcion;

        do {
            System.out.println("\n ### Menú de la biblioteca ###");
            System.out.println(" ### 1- Listar ###");
            System.out.println(" ### 2- Buscar por titulo###");
            System.out.println(" ### 3- Buscar por año ###");
            System.out.println(" ### 4- Prestar producto ###");
            System.out.println(" ### 5- Devolver producto ###");
            System.out.println(" ### 0- Salir ###");
            while (!teclado.hasNextInt()) teclado.next();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1 -> listar();
                case 2 -> buscarPorTitulo();
                case 3-> buscarPorAnio();
                case 4-> prestar();
                //case 5 -> devolver();
                case 0 -> System.out.println("Adios!");
                default -> System.out.println("Opción no valida");
            }


        } while (opcion !=0);
    }

    private static void listar(){
        List<Producto> lista = catalogo.listar();
        if (lista.isEmpty()){
            System.out.println("Catalogo vacio");
            return;
        }
        System.out.println("Lista de productos");
        for (Producto p : lista) System.out.println("-" + p);
    }

    private static void buscarPorTitulo(){
        System.out.println("Titulo");
        String t = teclado.nextLine();
        catalogo.buscar(t).forEach(p -> System.out.println("- " + p));

    }

    private static void buscarPorAnio(){
        System.out.println("Titulo");
        int a = teclado.nextInt();
        teclado.nextLine();
        catalogo.buscar(a).forEach(p -> System.out.println("- " + p));

    }

    private static void prestar(){
        List<Producto> disponible = catalogo.listar().stream().filter(p -> p instanceof Prestable pN && !pN.estaPrestado()).collect(Collectors.toList());
    }


}
