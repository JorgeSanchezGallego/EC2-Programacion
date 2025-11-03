package biblioteca.simple.modelo;

import biblioteca.simple.contratos.Prestable;

public class Videojuego extends Producto implements Prestable {

    private String PEGI;
    private Genero genero;
    private Plataforma plataforma;
    private boolean prestado;
    private Usuario prestadoA;

    public Videojuego(int id, String titulo, String anio, Formato formato, String PEGI, Genero genero, Plataforma plataforma) {
        super(id, titulo, anio, formato);
        this.PEGI = PEGI;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public Videojuego(String titulo, String anio, Formato formato, String PEGI, Genero genero, Plataforma plataforma) {
        super(titulo, anio, formato);
        this.PEGI = PEGI;
        this.genero = genero;
        this.plataforma = plataforma;
    }

    public Genero getGenero() {
        return genero;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public String getPEGI() {
        return PEGI;
    }

    @Override public void prestar(Usuario u ){
        if (prestado) throw new IllegalStateException("Ya prestado");
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
        return "Videojuego{" +
                "PEGI='" + PEGI + '\'' +
                ", genero=" + genero +
                ", plataforma=" + plataforma +
                ", prestado=" + prestado +
                ", prestadoA=" + prestadoA +
                ", titulo='" + titulo + '\'' +
                ", id=" + id +
                ", anio='" + anio + '\'' +
                ", formato=" + formato +
                '}';
    }*/

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
