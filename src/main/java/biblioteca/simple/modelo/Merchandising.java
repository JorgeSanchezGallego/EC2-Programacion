package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Vendible;

/**
 * Representa un artículo de Merchandising, un tipo específico de {@link Producto}.
 * Implementa la interfaz {@link Vendible}, por lo que puede ser vendido
 * y lleva un registro de su estado de venta.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see Producto
 * @see Vendible
 */
public class Merchandising extends Producto implements Vendible {
    private double precio;
    private String tipo;
    private boolean vendido;
    private Usuario vendidoA;

    /**
     * Constructor para crear un artículo de Merchandising con un ID existente (p.ej., al cargarlo desde la BBDD).
     *
     * @param id El identificador numérico único del artículo.
     * @param titulo El nombre o descripción del artículo.
     * @param anio El año de lanzamiento o fabricación.
     * @param formato El formato (normalmente FISICO).
     * @param tipo El tipo de merchandising (p.ej., "Figura", "Ropa").
     * @param precio El precio de venta del artículo.
     */
    public Merchandising(int id, String titulo, String anio, Formato formato, String tipo, double precio) {
        super(id, titulo, anio, formato);
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * Constructor para crear un nuevo artículo de Merchandising (p.ej., antes de guardarlo en la BBDD).
     * Se asume que el ID será asignado posteriormente.
     *
     * @param titulo El nombre o descripción del artículo.
     * @param anio El año de lanzamiento o fabricación.
     * @param formato El formato (normalmente FISICO).
     * @param tipo El tipo de merchandising (p.ej., "Figura", "Ropa").
     * @param precio El precio de venta del artículo.
     */
    public Merchandising(String titulo, String anio, Formato formato, String tipo, double precio) {
        super(titulo, anio, formato);
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * Obtiene el precio de venta del artículo.
     *
     * @return El precio como un valor 'double'.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el tipo de merchandising.
     *
     * @return El tipo como String (p.ej., "Figura", "Ropa").
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * {@inheritDoc}
     * Marca el artículo como vendido al usuario {@code u}.
     *
     * @param u El usuario que compra el artículo.
     * @throws IllegalStateException si el artículo ya ha sido vendido.
     */
    @Override public void vender(Usuario u){
        if (vendido) throw new IllegalStateException("Ya vendido");
        this.vendido = true;
        this.vendidoA= u;
    }

    /**
     * {@inheritDoc}
     * @return {@code true} si el artículo ya ha sido vendido,
     * {@code false} en caso contrario.
     */
    @Override public boolean estaVendido(){return this.vendido;}

    /**
     * Genera una representación en String del artículo de Merchandising con un formato de ficha detallada.
     * Incluye información del producto base y los atributos específicos del artículo.
     *
     * @return Un String formateado con los datos del artículo.
     */
    @Override
    public String toString() {
        return  ("===================================\n") +
                ("   💲MERCHANDISING ID: "+id+ "✅\n") +
                ("-----------------------------------\n")+


                ("\tTítulo:     ") + titulo + "\n" +
                ("\tPrecio:     ") + precio + "€ \n" +
                ("\tTipo:       ") +tipo +"\n" +
                ("\tAño:        ") +anio +"\n" +
                ("\tFormato:    ") +formato +"\n" +
                ("\tVendido:    ") +vendido +"\n" +




                ("\t-----------------\n")+


                ("===================================");

    }
}
