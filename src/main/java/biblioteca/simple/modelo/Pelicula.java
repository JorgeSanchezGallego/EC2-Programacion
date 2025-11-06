package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Representa una Película, un tipo específico de {@link Producto}.
 * Implementa la interfaz {@link Prestable}, por lo que puede ser prestada
 * y devuelta, llevando un registro de su estado.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see Producto
 * @see Prestable
 */
public class Pelicula extends Producto implements Prestable {

    private String director;
    private int minutosDuracion;
    private boolean prestado;
    private Usuario prestadoA;

    /**
     * Constructor para crear una Película con un ID existente (p.ej., al cargarla desde la BBDD).
     *
     * @param id El identificador numérico único de la película.
     * @param titulo El título de la película.
     * @param anio El año de estreno.
     * @param formato El formato (FISICO o DIGITAL).
     * @param director El director de la película.
     * @param duracion La duración en minutos de la película.
     */
    public Pelicula(int id, String titulo, String anio, Formato formato, String director, int duracion) {
        super(id, titulo, anio, formato);
        this.director = director;
        this.minutosDuracion = duracion;
    }

    /**
     * Constructor para crear una nueva Película (p.ej., antes de guardarla en la BBDD).
     * Se asume que el ID será asignado posteriormente.
     *
     * @param titulo El título de la película.
     * @param anio El año de estreno.
     * @param formato El formato (FISICO o DIGITAL).
     * @param director El director de la película.
     * @param duracion La duración en minutos de la película.
     */
    public Pelicula(String titulo, String anio, Formato formato, String director, int duracion) {
        super(titulo, anio, formato);
        this.director = director;
        this.minutosDuracion = duracion;
    }

    /**
     * Obtiene el director de la película.
     *
     * @return El nombre del director como String.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Obtiene la duración de la película en minutos.
     *
     * @return La duración total en minutos.
     */
    public int getMinutosDuracion() {
        return minutosDuracion;
    }


    /**
     * {@inheritDoc}
     * Marca la película como prestada al usuario {@code u}.
     *
     * @param u El usuario que toma la película prestada.
     * @throws IllegalStateException si la película ya se encuentra prestada.
     */
    @Override public void prestar(Usuario u){
        if (prestado)throw new IllegalStateException("Ya prestado");
        this.prestado = true;
        this.prestadoA = u;
    }

    /**
     * {@inheritDoc}
     * Marca la película como devuelta, actualizando su estado interno
     * y eliminando la referencia al usuario que la tenía.
     */
    @Override public void devolver(){
        this.prestado = false;
        this.prestadoA = null;
    }

    /**
     * {@inheritDoc}
     * @return {@code true} si la película está actualmente prestada,
     * {@code false} en caso contrario.
     */
    @Override public boolean estaPrestado(){return this.prestado;}


    /**
     * Genera una representación en String de la Película con un formato de ficha detallada.
     * Incluye información del producto base y los atributos específicos de la película.
     *
     * @return Un String formateado con los datos de la película.
     */
    @Override
    public String toString() {
        return  ("===================================\n") +
                ("   🎥PELICULA ID: "+id+ "🎬\n") +
                ("-----------------------------------\n")+


                ("\tTítulo:     ") + titulo + "\n" +
                ("\tDuración:   ") + minutosDuracion + "Minutos \n" +
                ("\tDirector:   ") +director +"\n" +
                ("\tAño:        ") +anio +"\n" +
                ("\tFormato:    ") +formato +"\n" +
                ("\tPrestado:   ") +prestado +"\n" +



                ("\t-----------------\n")+


                ("===================================");

    }
}
