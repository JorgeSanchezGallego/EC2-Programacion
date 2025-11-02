package biblioteca.simple.servicios;

import biblioteca.simple.contratos.Prestable;
import biblioteca.simple.contratos.Vendible;
import biblioteca.simple.modelo.Producto;

import java.util.ArrayList;
import java.util.List;


public class Catalogo {

    private final List<Producto> listaPrestables = new ArrayList<>();
    private final List<Producto> listaVendibles = new ArrayList<>();

    public void alta(Producto p){
        if (p instanceof Prestable){
            listaPrestables.add(p);
        } else if (p instanceof Vendible) {
            listaVendibles.add(p);
        }
    }


    public List<Producto> listar(){
        List<Producto> todo = new ArrayList<>();
        todo.addAll(listaPrestables);
        todo.addAll(listaVendibles);
        return todo;
        }

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