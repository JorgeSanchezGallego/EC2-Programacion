package biblioteca.simple.servicios;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.contratos.Vendible;
import biblioteca.simple.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de gestión del catálogo de productos de la biblioteca.
 * Separa los productos en listas internas según si son Pretables o Vendibles.
 * Proporciona métodos para añadir, listar y buscar productos.
 *
 * @author Jorge Sánchez
 * @version 1.0
 */
public class Catalogo {

    private final List<Producto> listaPrestables = new ArrayList<>();
    private final List<Producto> listaVendibles = new ArrayList<>();

    /**
     * Da de alta un nuevo producto en el catálogo.
     * El producto se almacena en la lista de prestables o vendibles
     * según las interfaces que implemente.
     *
     * @param p El {@link Producto} a añadir al catálogo.
     */
    public void alta(Producto p){
        if (p instanceof Prestable){
            listaPrestables.add(p);
        } else if (p instanceof Vendible) {
            listaVendibles.add(p);
        }
    }


    /**
     * Devuelve una lista unificada de todos los productos del catálogo.
     * Combina la lista de prestables y la de vendibles.
     *
     * @return Una nueva {@link List} que contiene todos los productos.
     */
    public List<Producto> listar(){
        List<Producto> todo = new ArrayList<>();
        todo.addAll(listaPrestables);
        todo.addAll(listaVendibles);
        return todo;
        }

    /**
     * Busca productos en el catálogo cuyo título contenga el texto proporcionado.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param titulo El fragmento de texto a buscar en el título del producto.
     * @return Una {@link List} con los productos que coinciden con la búsqueda.
     */
    public List<Producto> buscar(String titulo){
        List<Producto> todo = new ArrayList<>();
        todo.addAll(listaPrestables);
        todo.addAll(listaVendibles);
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : todo){
            if (p.getTitulo().toLowerCase().contains(titulo.toLowerCase())) resultado.add(p);
        }
        return resultado;
    }

    /**
     * Busca productos en el catálogo que coincidan exactamente con el año proporcionado.
     *
     * @param anio El año (como entero) a buscar.
     * @return Una {@link List} con los productos que coinciden con el año.
     */
    public List<Producto> buscar(int anio){
        List<Producto> todo = new ArrayList<>();
        todo.addAll(listaPrestables);
        todo.addAll(listaVendibles);
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : todo){
            if (Integer.parseInt(p.getAnio()) == anio) resultado.add(p);
        }
        return resultado;
    }


}