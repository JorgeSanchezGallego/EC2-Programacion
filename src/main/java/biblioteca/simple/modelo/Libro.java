package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Representa un Libro, un tipo específico de {@link Producto}.
 * Implementa la interfaz {@link Prestable}, por lo que puede ser prestado
 * y devuelto, llevando un registro de su estado.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see Producto
 * @see Prestable
 */
public class Libro extends Producto implements Prestable {

    private String ISBN;
    private String autor;
    private boolean prestado;
    private Usuario prestadoA;


    /**
     * Constructor para crear un Libro con un ID existente (p.ej., al cargarlo desde la BBDD).
     *
     * @param id El identificador numérico único del libro.
     * @param titulo El título del libro.
     * @param anio El año de publicación.
     * @param formato El formato (FISICO o DIGITAL).
     * @param ISBN El código ISBN del libro.
     * @param autor El autor del libro.
     */
    public Libro(int id, String titulo, String anio, Formato formato, String ISBN, String autor) {
        super(id, titulo, anio, formato);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    /**
     * Constructor para crear un nuevo Libro (p.ej., antes de guardarlo en la BBDD).
     * Se asume que el ID será asignado posteriormente.
     *
     * @param titulo El título del libro.
     * @param anio El año de publicación.
     * @param formato El formato (FISICO o DIGITAL).
     * @param autor El autor del libro.
     * @param ISBN El código ISBN del libro.
     */
    public Libro(String titulo, String anio, Formato formato, String autor, String ISBN) {
        super(titulo, anio, formato);
        this.autor = autor;
        this.ISBN = ISBN;
    }



    /**
     * Obtiene el código ISBN del libro.
     *
     * @return El ISBN como String.
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El nombre del autor como String.
     */
    public String getAutor() {
        return autor;
    }


    /**
     * {@inheritDoc}
     * Marca el libro como prestado al usuario {@code u}.
     *
     * @param u El usuario que toma el libro prestado.
     * @throws IllegalStateException si el libro ya se encuentra prestado.
     */
    @Override public void prestar(Usuario u){
        if (prestado)throw  new IllegalStateException("Ya prestado");
        this.prestado = true;
        this.prestadoA = u;
    }


    /**
     * {@inheritDoc}
     * Marca el libro como devuelto, actualizando su estado interno
     * y eliminando la referencia al usuario que lo tenía.
     */
    @Override public void devolver(){
        this.prestado = false;
        this.prestadoA = null;
    }

    /**
     * {@inheritDoc}
     * @return {@code true} si el libro está actualmente prestado,
     * {@code false} en caso contrario.
     */
    @Override public boolean estaPrestado(){return this.prestado;}

    /**
     * Genera una representación en String del Libro con un formato de ficha detallada.
     * Incluye información del producto base y los atributos específicos del libro.
     *
     * @return Un String formateado con los datos del libro.
     */
    @Override
    public String toString() {
        return  ("===================================\n") +
                ("   📖LIBRO ID: "+id+ "📚\n") +
                ("-----------------------------------\n")+


                ("\tTítulo:     ") + titulo + "\n" +
                ("\tISBN:       ") +ISBN + "\n" +
                ("\tAutor:      ") +autor +"\n" +
                ("\tAño:        ") +anio +"\n" +
                ("\tFormato:    ") +formato +"\n" +
                ("\tPrestado:   ") +prestado +"\n" +



                ("\t-----------------\n")+


                ("===================================");

    }
}
