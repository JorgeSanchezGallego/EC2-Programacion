package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

/**
 * Representa un Videojuego, un tipo específico de {@link Producto}.
 * Implementa la interfaz {@link Prestable}, por lo que puede ser prestado
 * y devuelto, llevando un registro de su estado.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see Producto
 * @see Prestable
 * @see Genero
 * @see Plataforma
 */
public class Videojuego extends Producto implements Prestable {

    private String PEGI;
    private Genero genero;
    private Plataforma plataforma;
    private boolean prestado;
    private Usuario prestadoA;

    /**
     * Constructor para crear un Videojuego con un ID existente (p.ej., al cargarlo desde la BBDD).
     *
     * @param id El identificador numérico único del videojuego.
     * @param titulo El título del videojuego.
     * @param anio El año de lanzamiento.
     * @param formato El formato (FISICO o DIGITAL).
     * @param PEGI La clasificación por edad PEGI.
     * @param genero El género del videojuego.
     * @param plataforma La plataforma del videojuego.
     */
    public Videojuego(int id, String titulo, String anio, Formato formato, String PEGI, Genero genero, Plataforma plataforma) {
        super(id, titulo, anio, formato);
        this.PEGI = PEGI;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    /**
     * Constructor para crear un nuevo Videojuego (p.ej., antes de guardarlo en la BBDD).
     * Se asume que el ID será asignado posteriormente.
     *
     * @param titulo El título del videojuego.
     * @param anio El año de lanzamiento.
     * @param formato El formato (FISICO o DIGITAL).
     * @param PEGI La clasificación por edad PEGI.
     * @param genero El género del videojuego.
     * @param plataforma La plataforma del videojuego.
     */
    public Videojuego(String titulo, String anio, Formato formato, String PEGI, Genero genero, Plataforma plataforma) {
        super(titulo, anio, formato);
        this.PEGI = PEGI;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    /**
     * Obtiene el género del videojuego.
     *
     * @return El {@link Genero} del videojuego.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * Obtiene la plataforma del videojuego.
     *
     * @return La {@link Plataforma} del videojuego.
     */
    public Plataforma getPlataforma() {
        return plataforma;
    }

    /**
     * Obtiene la clasificación por edad PEGI del videojuego.
     *
     * @return El PEGI como String.
     */
    public String getPEGI() {
        return PEGI;
    }

    /**
     * {@inheritDoc}
     * Marca el videojuego como prestado al usuario {@code u}.
     *
     * @param u El usuario que toma el videojuego prestado.
     * @throws IllegalStateException si el videojuego ya se encuentra prestado.
     */
    @Override public void prestar(Usuario u ){
        if (prestado) throw new IllegalStateException("Ya prestado");
        this.prestado = true;
        this.prestadoA = u;
    }

    /**
     * {@inheritDoc}
     * Marca el videojuego como devuelto, actualizando su estado interno
     * y eliminando la referencia al usuario que lo tenía.
     */
    @Override public void devolver(){
        this.prestado = false;
        this.prestadoA = null;
    }

    /**
     * {@inheritDoc}
     * @return {@code true} si el videojuego está actualmente prestado,
     * {@code false} en caso contrario.
     */
    @Override public boolean estaPrestado(){return this.prestado;}


    /**
     * Genera una representación en String del Videojuego con un formato de ficha detallada.
     * Incluye información del producto base y los atributos específicos del videojuego.
     *
     * @return Un String formateado con los datos del videojuego.
     */
    @Override
    public String toString() {
        return  ("===================================\n") +
        ("   🎮VIDEOJUEGO ID: "+id+ "📺\n") +
        ("-----------------------------------\n")+


        ("\tTítulo:     ") + titulo + "\n" +
        ("\tGénero:     ") +genero + "\n" +
        ("\tPlataforma: ") +plataforma +"\n" +
        ("\tAño:        ") +anio +"\n" +
        ("\tFormato:    ") +formato +"\n" +
        ("\tPEGI:       ") +PEGI +"\n" +
        ("\tPrestado:   ") +prestado +"\n" +


        ("\t-----------------\n")+


        ("===================================");

    }
}
