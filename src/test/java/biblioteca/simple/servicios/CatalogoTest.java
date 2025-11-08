package biblioteca.simple.servicios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import biblioteca.simple.modelo.*;

/**
 * Pruebas unitarias para la clase Catalogo.
 */
class CatalogoTest {
    private Catalogo catalogo;

    @BeforeEach
    void setUp(){
        catalogo = new Catalogo();
    }


    /**
     * Test para comprobar que el alta de un producto funciona
     * y el listado lo refleja.
     */
    @Test
    void testAlta(){
        Libro libro = new Libro(1, "El Quijote", "1608", Formato.FISICO, "isbn-falso", "Cervantes");
        catalogo.alta(libro);
        assertEquals(1, catalogo.listar().size());
        assertEquals("El Quijote", catalogo.listar().get(0).getTitulo());
    }

    /**
     * Test para comprobar que el método de búsqueda por título funciona.
     */
    @Test
    void testBuscarPorTitulo() {
        catalogo.alta(new Libro(1, "El Quijote", "1608", Formato.FISICO, "isbn-falso", "Cervantes"));
        catalogo.alta(new Videojuego(5, "Call Of Duty", "2022", Formato.DIGITAL, "18", Genero.SHOOTER, Plataforma.PC));
        catalogo.alta(new Pelicula(3, "El Padrino", "1972", Formato.FISICO, "Francis Ford", 175));

        var resultados = catalogo.buscar("Duty");

        assertEquals(1, resultados.size());
        assertEquals("Call Of Duty", resultados.get(0).getTitulo());
    }

    /**
     * Test para comprobar que la búsqueda devuelve una lista vacía
     * si no encuentra nada.
     */
    @Test
    void testBuscarNoEncontrado() {
        catalogo.alta(new Libro(1, "El Quijote", "1608", Formato.FISICO, "isbn-falso", "Cervantes"));

        var resultados = catalogo.buscar("Zelda");

        assertTrue(resultados.isEmpty());
    }

}
