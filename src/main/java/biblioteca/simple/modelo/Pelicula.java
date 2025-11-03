package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Pelicula extends Producto implements Prestable {

    private String director;
    private int minutosDuracion;
    private boolean prestado;
    private Usuario prestadoA;

    public Pelicula(int id, String titulo, String anio, Formato formato, String director, int duracion) {
        super(id, titulo, anio, formato);
        this.director = director;
        this.minutosDuracion = duracion;
    }

    public Pelicula(String titulo, String anio, Formato formato, String director, int duracion) {
        super(titulo, anio, formato);
        this.director = director;
        this.minutosDuracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public int getMinutosDuracion() {
        return minutosDuracion;
    }


    @Override public void prestar(Usuario u){
        if (prestado)throw new IllegalStateException("Ya prestado");
        this.prestado = true;
        this.prestadoA = u;
    }

    @Override public void devolver(){
        this.prestado = false;
        this.prestadoA = null;
    }

    @Override public boolean estaPrestado(){return this.prestado;}

    /*@Override
    public String toString() {
        return "Pelicula{" +
                "director='" + director + '\'' +
                ", minutosDuracion=" + minutosDuracion +
                ", id=" + id +
                ", anio='" + anio + '\'' +
                ", titulo='" + titulo + '\'' +
                ", formato=" + formato +
                '}';
    }*/

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
