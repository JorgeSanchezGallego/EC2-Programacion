package biblioteca.simple.app;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.contratos.Vendible;
import biblioteca.simple.modelo.*;
import biblioteca.simple.servicios.Catalogo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;

import biblioteca.simple.servicios.PersistenciaUsuarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * Clase principal de la aplicación de biblioteca.
 * Gestiona el menú de usuario, la carga de datos inicial y
 * la interacción con el catálogo y la lista de usuarios.
 *
 * @author Jorge Sánchez
 * @version 1.0
 */
public class Main {
    private static final Catalogo catalogo = new Catalogo();
    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos();
        menu();
    }

    /**
     * Carga un conjunto de datos de prueba iniciales en el catálogo
     * y en la lista de usuarios para el funcionamiento de la aplicación.
     * PRIMERO intenta cargar usuarios desde JSON.
     */
    private static void cargarDatos(){
        importarUsuarios();
        if (usuarios.isEmpty()){
            System.out.println("No se encontraron usuarios, cargando datos de prueba");
            usuarios.add(new Usuario(1,"Jorge"));
            usuarios.add(new Usuario(2,"Ander"));
            usuarios.add(new Usuario(3,"Joa"));
            usuarios.add(new Usuario(4,"Daniel"));
            usuarios.add(new Usuario(5,"Kenneth"));
        }


        catalogo.alta(new Libro(1, "El Quijote", "1608", Formato.FISICO,"22342455", "Cervantes"));
        catalogo.alta(new Libro(2, "El nombre del viento", "2007", Formato.FISICO,"223245234", "Patrick Rothfuss"));
        catalogo.alta(new Pelicula(3, "El Padrino", "1972", Formato.FISICO,"Francis Ford", 175));
        catalogo.alta(new Pelicula(4, "Parasitos", "2019", Formato.FISICO,"Bong Joon-ho", 132));
        catalogo.alta(new Videojuego(5, "Call Of Duty", "2022", Formato.DIGITAL, "18", Genero.SHOOTER, Plataforma.PC));
        catalogo.alta(new Videojuego(6, "Mario Kart 8 Deluxe", "2017", Formato.FISICO, "3", Genero.DEPORTES, Plataforma.SWITCH));
        catalogo.alta(new Videojuego(7, "StarCraft II", "2010", Formato.DIGITAL, "16", Genero.ESTRATEGIA, Plataforma.PC));
        catalogo.alta(new Merchandising(8, "Funko Pop: Darth Vader", "2021", Formato.FISICO, "Figura", 15.99));
        catalogo.alta(new Merchandising(9, "Camiseta Logo Zelda", "2023", Formato.FISICO, "Ropa", 22.50));
        catalogo.alta(new Merchandising(10, "Taza Casa Stark (GoT)", "2019", Formato.FISICO, "Taza", 12.95));
        catalogo.alta(new Merchandising(11, "Póster The Last of Us", "2022", Formato.FISICO, "Póster", 9.99));


    }

    /**
     * Muestra el menú principal de opciones al usuario en un bucle.
     * Lee la selección del usuario y llama al método correspondiente
     * hasta que el usuario elige la opción de salir (0).
     */
    private static void menu(){
        int opcion;

        do {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║    📚 Menú de la Biblioteca 📚   ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1. Listar                        ║");
            System.out.println("║ 2. Buscar por título             ║");
            System.out.println("║ 3. Buscar por año                ║");
            System.out.println("║ 4. Prestar producto              ║");
            System.out.println("║ 5. Comprar producto              ║");
            System.out.println("║ 6. Devolver producto             ║");
            System.out.println("║ 7. Alta usuario                  ║");
            System.out.println("║ 8. Mostrar usuarios              ║");
            System.out.println("╟──────────────────────────────────╢");
            System.out.println("║ 0. Salir                         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("  -> Introduce tu opción: ");
            while (!teclado.hasNextInt()) teclado.next();
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1 -> listar();
                case 2 -> buscarPorTitulo();
                case 3-> buscarPorAnio();
                case 4-> prestar();
                case 5 -> comprar();
                case 6 -> devolver();
                case 7 -> altaUsuario();
                case 8 -> mostrarUsuarios();
                case 0 -> {
                    exportarUsuarios();
                    System.out.println("Adios!");
                }
                default -> System.out.println("Opción no valida");
            }


        } while (opcion !=0);
    }

    /**
     * Muestra por consola la lista completa de productos del catálogo.
     * Si el catálogo está vacío, muestra un mensaje informativo.
     */
    private static void listar(){
        List<Producto> lista = catalogo.listar();
        if (lista.isEmpty()){
            System.out.println("Catalogo vacio");
            return;
        }
        System.out.println("Lista de productos");
        for (Producto p : lista) System.out.println("-" + p);
    }

    /**
     * Pide al usuario un título por teclado y muestra todos los
     * productos del catálogo que coinciden con dicho título.
     */
    private static void buscarPorTitulo(){
        System.out.println("Titulo");
        String titulo = teclado.nextLine();
        catalogo.buscar(titulo).forEach(p -> System.out.println("- " + p));

    }

    /**
     * Pide al usuario un año por teclado y muestra todos los
     * productos del catálogo que coinciden con dicho año.
     */
    private static void buscarPorAnio(){
        try {
            System.out.println("Año");
            int a = teclado.nextInt();
            teclado.nextLine();
            catalogo.buscar(a).forEach(p -> System.out.println("- " + p));
        } catch (InputMismatchException e){
            System.out.println("Por favor, introduce un año valido");
        }


    }

    /**
     * Gestiona el proceso de prestar un producto.
     * Muestra los productos prestables disponibles, comprueba el usuario,
     * y si es válido, registra el préstamo del producto seleccionado.
     */
    private static void prestar(){
        List<Producto> disponible = catalogo.listar().stream().filter(p -> p instanceof Prestable pN && !pN.estaPrestado()).collect(Collectors.toList());
        if (disponible.isEmpty()){
            System.out.println("No hay articulos para alquilar");
            return;
        }
        System.out.println("Productos disponibles");
        disponible.forEach(System.out::println);
        Usuario usuarioParaPrestar = comprobarExistenciaUser();

        try {
            if (usuarioParaPrestar != null){
                System.out.println("Introduce el ID del producto a alquilar");
                int idElegido = teclado.nextInt();
                teclado.nextLine();
                for (Producto producto : disponible){
                    if (producto.getId() == idElegido){
                        Prestable pPrestable = (Prestable) producto;
                        pPrestable.prestar(usuarioParaPrestar);
                        System.out.println("Producto " + producto.getTitulo()+ " prestado a " + usuarioParaPrestar.getNombre());
                        return;
                    }
                }
                System.out.println("Producto no disponible");

            }
        } catch (InputMismatchException e){
            System.out.println("Por favor, introduce un ID, no una letra");
        }

    }

    /**
     * Gestiona el proceso de comprar un producto.
     * Muestra los productos vendibles disponibles, comprueba el usuario,
     * y si es válido, registra la venta del producto seleccionado.
     */
    private static void comprar(){
        List<Producto> disponible = catalogo.listar().stream().filter(p -> p instanceof Vendible pN && !pN.estaVendido()).collect(Collectors.toList());
        if (disponible.isEmpty()){
            System.out.println("No hay articulos para vender");
            return;
        }
        System.out.println("Productos disponibles");
        disponible.forEach(System.out::println);
        Usuario usuarioParaVender = comprobarExistenciaUser();
        try {
            if (usuarioParaVender != null) {
                System.out.println("Introduce el ID del producto a vender");
                int idElegido = teclado.nextInt();
                teclado.nextLine();
                for (Producto producto : disponible) {
                    if (producto.getId() == idElegido) {
                        Vendible pPrestable = (Vendible) producto;
                        pPrestable.vender(usuarioParaVender);
                        System.out.println("Producto " + producto.getTitulo() + " vendido a " + usuarioParaVender.getNombre());
                        return;
                    }
                }
                System.out.println("Producto no disponible");
            }
        } catch (InputMismatchException e ){
            System.out.println("Por favor introduce un ID, no una letra");
        }

    }

    /**
     * Gestiona el proceso de devolver un producto previamente prestado.
     * Muestra los productos que están actualmente prestados,
     * pide un ID y registra la devolución.
     */
    private static void devolver(){
        List<Producto> disponibleParaDevolver = catalogo.listar().stream().filter(p -> p instanceof Prestable pN && pN.estaPrestado()).collect(Collectors.toList());
        if (disponibleParaDevolver.isEmpty()){
            System.out.println("No hay articulos para devolver");
            return;
        }
        System.out.println("Productos disponibles para devolver");
        disponibleParaDevolver.forEach(System.out::println);


           try {
               System.out.println("Introduce el ID del producto a devolver");
               int idElegido = teclado.nextInt();
               teclado.nextLine();
               for (Producto producto : disponibleParaDevolver) {
                   if (producto.getId() == idElegido) {
                       Prestable pPrestable = (Prestable) producto;
                       pPrestable.devolver();
                       System.out.println("Producto " + producto.getTitulo() + " devuelto");
                       return;
                   }
                   System.out.println("Producto no disponible");
               }
           } catch (InputMismatchException e){
               System.out.println("Por favor introduce un ID, no una letra");
           }
    }

    /**
     * Busca un usuario en la lista global de usuarios por su nombre.
     * La búsqueda ignora mayúsculas y minúsculas.
     *
     * @param nombre El nombre del usuario a buscar.
     * @return El objeto Usuario si se encuentra, o 'null' si no existe.
     */
    private static Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Pide un nombre de usuario y comprueba si existe.
     * Si el usuario no existe, ofrece la posibilidad de darlo de alta
     * en el momento.
     *
     * @return El Usuario (ya sea encontrado o recién creado), o 'null' si la
     * operación es cancelada por el usuario.
     */
    private static Usuario comprobarExistenciaUser(){
        System.out.println("Nombre del usuario?");
        String nombre = teclado.nextLine();

        Usuario user = buscarUsuarioPorNombre(nombre);

        if (user == null){
            System.out.println("Usuario no encontrado");
            System.out.println("Desea crear el nuevo usuario? si/no");
            String respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("si")){
                user = altaUsuario();
            } else {
                System.out.println("Operación cancelada");
                return null;
            }
        }
        System.out.println("Usuario: " +user.getNombre() + " Encontrado");
        return user;
    }

    /**
     * Da de alta a un nuevo usuario en el sistema pidiendo los datos por teclado.
     * Comprueba si el usuario ya existe (ignorando mayúsculas/minúsculas)
     * antes de crearlo. Asigna un ID numérico automáticamente.
     *
     * @return El objeto Usuario creado, o 'null' si el usuario ya existía.
     */
    private static Usuario altaUsuario(){
        System.out.println("Nombre del usuario: ");
        String nombre = teclado.nextLine();
        int nuevoId;
        for (Usuario u: usuarios){
            if (u.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("El usuario '" + nombre + "' ya existe.");
                return null;
            }
        }
        if (usuarios.isEmpty()){
            nuevoId=1;
        }  else {
            Usuario ultimoUsuario = usuarios.get(usuarios.size()-1);
            nuevoId = ultimoUsuario.getId() + 1;
        }
        Usuario nuevoUsuario = new Usuario(nuevoId, nombre);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario '" + nuevoUsuario.getNombre() + "' añadido");
        return nuevoUsuario;

    }

    /**
     * Muestra por consola la lista completa de usuarios registrados
     * en el sistema, utilizando su método 'toString()'.
     */
    private static void mostrarUsuarios(){
        usuarios.forEach(System.out::println);
    }



    private static void exportarUsuarios(){
        try {
            PersistenciaUsuarios.exportar(usuarios);
            System.out.println("Usuarios exportados correctamente");
        } catch (Exception e) {
            System.out.println("Error al exportar usuarios " + e.getMessage());
        }
    }



    private static void importarUsuarios(){
        try {
            List<Usuario> cargados = PersistenciaUsuarios.importar();
            usuarios.clear();
            usuarios.addAll(cargados);
            System.out.println("Usuarios cargados con éxito");
        } catch (Exception e){
            System.out.println("Error al importar: " + e.getMessage());
        }
    }


}
