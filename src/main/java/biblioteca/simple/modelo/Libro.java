package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Libro extends Producto implements Prestable {

    private String ISBN;
    private String autor;
    private boolean prestado;
    private Usuario prestadoA;


    public Libro(int id, String titulo, String anio, Formato formato, String ISBN, String autor) {
        super(id, titulo, anio, formato);
        this.ISBN = ISBN;
        this.autor = autor;
    }

    public Libro(String titulo, String anio, Formato formato, String autor, String ISBN) {
        super(titulo, anio, formato);
        this.autor = autor;
        this.ISBN = ISBN;
    }



    public String getISBN() {
        return ISBN;
    }

    public String getAutor() {
        return autor;
    }



    @Override public void prestar(Usuario u){
        if (prestado)throw  new IllegalStateException("Ya prestado");
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
        return "Libro{" +
                "ISBN='" + ISBN + '\'' +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                ", anio='" + anio + '\'' +
                ", formato=" + formato +
                '}';
    }*/

    @Override
    public String toString() {
        return  ("===================================\n") +
                ("   📖LIBRO ID: "+id+ "📚\n") +
                ("-----------------------------------\n")+


                ("\tTítulo:     ") + titulo + "\n" +
                ("\tISBN:       ") +ISBN + "\n" +
                ("\tAutor:      ") +autor +"\n" +
                ("\tAño:        ") +anio +"\n" +
                ("\tFormato:    ") +formato +"\n" +
                ("\tPrestado:   ") +prestado +"\n" +



                ("\t-----------------\n")+


                ("===================================");

    }
}
