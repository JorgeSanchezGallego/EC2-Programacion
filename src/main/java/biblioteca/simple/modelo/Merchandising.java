package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Vendible;

public class Merchandising extends Producto implements Vendible {
    private double precio;
    private String tipo;
    private boolean vendido;
    private Usuario vendidoA;

    public Merchandising(int id, String titulo, String anio, Formato formato, String tipo, double precio) {
        super(id, titulo, anio, formato);
        this.tipo = tipo;
        this.precio = precio;
    }

    public Merchandising(String titulo, String anio, Formato formato, String tipo, double precio) {
        super(titulo, anio, formato);
        this.tipo = tipo;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    @Override public void vender(Usuario u){
        if (vendido) throw new IllegalStateException("Ya vendido");
        this.vendido = true;
        this.vendidoA= u;
    }

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



                ("\t-----------------\n")+


                ("===================================");

    }
}
