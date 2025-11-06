package biblioteca.simple.contratos;

import biblioteca.simple.modelo.Usuario;

/**
 * Define el comportamiento de los productos que pueden ser vendidos.
 * Cualquier clase que implemente esta interfaz debe gestionar el estado
 * de venta y el usuario que lo compró.
 *
 * @author Jorge Sánchez
 * @version 1.0
 * @see biblioteca.simple.modelo.Producto
 */
public interface Vendible {
    /**
     * Marca el producto como "vendido" a un usuario específico.
     *
     * @param u El objeto Usuario que compra el producto.
     */
    void vender(Usuario u);

    /**
     * Comprueba el estado de venta actual del producto.
     *
     * @return {@code true} si el producto ya ha sido vendido,
     * {@code false} en caso contrario.
     */
    boolean estaVendido();
}
