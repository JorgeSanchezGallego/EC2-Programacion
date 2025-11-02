package biblioteca.simple.modelo;

public abstract class Producto {
    protected int id;
    protected String titulo;
    protected String anio;
    protected Formato formato;

    //Constructor para recibir objetos de la base de datos
    protected Producto(int id, String titulo, String anio, Formato formato) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.formato = formato;
    }

    //Constructor para crear nuevos productos desde la app
    protected Producto(String titulo, String anio, Formato formato) {
        this.titulo = titulo;
        this.anio = anio;
        this.formato = formato;
    }

    protected int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAnio() {
        return anio;
    }

    protected Formato getFormato() {
        return formato;
    }


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
