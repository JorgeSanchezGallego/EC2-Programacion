package biblioteca.simple.modelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Pruebas unitarias para la lógica de préstamo de la clase Libro.
 */
class LibroTest {
    private Libro libro;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        libro = new Libro(1, "El nombre del viento", "2007", Formato.FISICO, "isbn-test", "Rothfuss");
        usuario = new Usuario(1, "Jorge");
    }

    /**
     * Test para comprobar el estado inicial de un libro.
     */
    @Test
    void testLibroNuevoNoEstaPrestado() {
        assertFalse(libro.estaPrestado(), "Un libro recién creado no debería estar prestado");
    }

    /**
     * Test para comprobar que el método prestar() funciona.
     */
    @Test
    void testPrestarLibro() {
        libro.prestar(usuario);
        assertTrue(libro.estaPrestado(), "El libro debería estar prestado después de prestar()");
    }

    /**
     * Test para comprobar que el método devolver() funciona.
     */
    @Test
    void testDevolverLibro() {
        libro.prestar(usuario);
        assertTrue(libro.estaPrestado(), "Fallo en la preparación: el libro no se prestó");
        libro.devolver();
        assertFalse(libro.estaPrestado(), "El libro no se ha devuelto correctamente");
    }



}
