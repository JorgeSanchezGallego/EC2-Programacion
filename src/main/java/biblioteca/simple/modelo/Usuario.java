package biblioteca.simple.modelo;

/**
 * Representa a un Usuario del sistema.
 * Contiene la información básica como el ID y el nombre.
 *
 * @author Jorge Sánchez
 * @version 1.0
 */
public class Usuario {
    private int id;
    private String nombre;

    /**
     * Constructor para crear un Usuario solo con nombre (p.ej., antes de asignarle ID).
     *
     * @param nombre El nombre para el nuevo usuario.
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor para crear un Usuario con todos los datos.
     *
     * @param id El identificador numérico único para el usuario.
     * @param nombre El nombre del usuario.
     */
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID del usuario.
     *
     * @return El identificador numérico del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece o actualiza el nombre del usuario.
     *
     * @param nombre El nuevo nombre para el usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera una representación en String del Usuario con un formato de ficha.
     *
     * @return Un String formateado con los datos del usuario.
     */
    @Override
    public String toString() {
        return  ("===================================\n") +
                ("   👤 USUARIO ID: " + id + " ✅\n") +
                ("-----------------------------------\n") +
                ("\tNombre:     ") + nombre + "\n" +
                ("===================================");
    }
}
