package biblioteca.simple.modelo;

/**
 * Representa un producto en el sistema.
 * Es una clase abstracta que sirve como base para tipos de productos específicos.
 *
 * @author Jorge Sánchez
 * @version 1.0
 */
public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String anio;
    protected Formato formato;

    /**
     * Constructor para crear un Producto con un ID existente (p.ej., al cargarlo desde la BBDD).
     *
     * @param id El identificador numérico único del producto.
     * @param titulo El título o nombre del producto.
     * @param anio El año de lanzamiento o creación (como String).
     * @param formato El formato del producto (p.ej., Físico, Digital).
     */
    protected Producto(int id, String titulo, String anio, Formato formato) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.formato = formato;
    }

    /**
     * Constructor para crear un nuevo Producto (p.ej., antes de guardarlo en la BBDD).
     * Se asume que el ID será asignado posteriormente.
     *
     * @param titulo El título o nombre del producto.
     * @param anio El año de lanzamiento o creación (como String).
     * @param formato El formato del producto (p.ej., Físico, Digital).
     */
    protected Producto(String titulo, String anio, Formato formato) {
        this.titulo = titulo;
        this.anio = anio;
        this.formato = formato;
    }

    /**
     * Obtiene el ID del producto.
     *
     * @return El identificador numérico del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el título del producto.
     *
     * @return El título del producto.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el año de lanzamiento del producto.
     *
     * @return El año del producto como String.
     */
    public String getAnio() {
        return anio;
    }

    /**
     * Obtiene el formato del producto.
     *
     * @return El objeto Formato que representa el formato del producto.
     */
    protected Formato getFormato() {
        return formato;
    }


    /**
     * Genera una representación en String de los atributos básicos del producto.
     *
     * @return Una cadena de texto con los datos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio='" + anio + '\'' +
                ", formato=" + formato +
                '}';
    }


}
