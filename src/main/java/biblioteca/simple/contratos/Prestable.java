package biblioteca.simple.contratos;

import biblioteca.simple.modelo.Usuario;

/**
 * Define el comportamiento de los productos que pueden ser prestados.
 * Cualquier clase que implemente esta interfaz debe gestionar el estado
 * de préstamo y el usuario que lo posee.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see biblioteca.simple.modelo.Producto
 */
public interface Prestable {

    /**
     * Marca el producto como "prestado" a un usuario específico.
     *
     * @param u El objeto Usuario que toma prestado el producto.
     */
    void prestar(Usuario u);

    /**
     * Marca el producto como "devuelto".
     * Generalmente, esto implica poner el usuario asociado al préstamo como 'null'.
     */
    void devolver();

    /**
     * Comprueba el estado actual del producto.
     *
     * @return {@code true} si el producto está actualmente prestado,
     * {@code false} en caso contrario.
     */
    boolean estaPrestado();
}
