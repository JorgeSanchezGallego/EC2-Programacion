# Proyecto Biblioteca - Evaluación Continua 2

Este proyecto corresponde a la **Segunda Evaluación Continua (EC 2)** de la asignatura de Programación. El objetivo es ampliar una aplicación de consola existente de gestión de una biblioteca, aplicando herencia, interfaces y persistencia de datos.

* **Alumno:** Jorge Sánchez
* **Curso:** 1º Desarrollo de Aplicaciones Web (DAW)
* **Escuela:** Prometeo

---

## 📋 Descripción del Proyecto

Partiendo de una aplicación base, esta tarea consistía en ampliar el sistema para incluir nuevos tipos de productos (`Videojuego`), mejorar la gestión de usuarios (altas manuales y "al vuelo") y añadir persistencia de datos para los usuarios mediante JSON.

Además de los requisitos mínimos, este proyecto ha sido ampliado con funcionalidades adicionales para demostrar una comprensión más profunda de la Programación Orientada a Objetos y la gestión de proyectos.

---

## ✨ Funcionalidades Implementadas

La aplicación presenta un menú de consola interactivo con las siguientes funcionalidades:

* **Gestión del Catálogo:**
  * Listar todos los productos (Libros, Películas, Videojuegos y Merchandising).
  * Buscar productos por título o por año de lanzamiento.
* **Gestión de Préstamos:**
  * Permite prestar cualquier ítem `Prestable` (Libro, Película, Videojuego).
  * Permite devolver productos prestados.
* **Gestión de Usuarios:**
  * **Alta manual:** Opción de menú dedicada para crear nuevos usuarios.
  * **Alta "al vuelo":** Si se intenta un préstamo para un usuario que no existe, el sistema ofrece crearlo en el momento sin abortar la operación.
  * Mostrar la lista completa de usuarios.
* **Persistencia de Datos:**
  * **Importación automática:** Al iniciar, la aplicación carga la lista de usuarios desde `usuarios.json`.
  * **Exportación automática:** Al salir, la aplicación guarda la lista actualizada de usuarios en `usuarios.json`, asegurando que los nuevos usuarios creados persistan.

---

## 🌟 Ampliaciones Personales (Extras)

Para ir más allá de los requisitos de la evaluación, el proyecto incluye las siguientes mejoras:

### 1. Interfaz `Vendible` y clase `Merchandising`
Se ha añadido una nueva interfaz `Vendible` (con métodos `vender()` y `estaVendido()`) y una clase `Merchandising` que la implementa. Esto demuestra un diseño de interfaces paralelo a `Prestable`, permitiendo que el catálogo gestione productos que se prestan y productos que se venden, cada uno con su propio contrato.

### 2. Mejora Visual de la Interfaz (CLI)
El menú de la consola se ha rediseñado con caracteres ASCII para ofrecer una experiencia de usuario más limpia, profesional y agradable que un simple listado de texto.

### 3. Documentación Javadoc Exhaustiva
Todo el código fuente (clases, métodos, atributos) ha sido documentado profesionalmente con Javadoc, explicando el propósito de cada elemento, sus parámetros (`@param`) y sus valores de retorno (`@return`). La documentación generada está lista para ser consultada.

### 4. Pruebas Unitarias (JUnit)
Para garantizar la robustez y el correcto funcionamiento de la lógica de negocio, se han implementado pruebas unitarias (tests) con **JUnit 5**. Se ha creado una suite de tests en la carpeta `src/test/java` que valida el comportamiento de las clases más críticas:
* **`CatalogoTest`**: Comprueba que el alta, listado y, especialmente, los métodos de búsqueda (`buscarPorTitulo`) funcionan como se espera, manejando casos de éxito y casos donde no se encuentran resultados.
* **`LibroTest`**: Valida la lógica de estado de la interfaz `Prestable`. Se asegura de que un libro no pueda ser prestado dos veces seguidas (lanzando la `IllegalStateException` esperada) y que los métodos `estaPrestado()` y `devolver()` modifican el estado correctamente.

---

## 🛠️ Arquitectura y Diseño Técnico

El proyecto sigue una estructura de paquetes clara (`app`, `contratos`, `modelo`, `servicios`) y se basa en los siguientes pilares de la POO:

* **Herencia:** Todos los artículos del catálogo (`Libro`, `Pelicula`, `Videojuego`, `Merchandising`) heredan de una clase abstracta `Producto`.
* **Interfaces (Contratos):** Se utilizan para definir comportamientos específicos que no todos los productos comparten.
  * **`Prestable`:** Implementado por `Libro`, `Pelicula` y `Videojuego`.
  * **`Vendible`:** Implementado por `Merchandising`.
* **Persistencia JSON:**
  * Se utiliza la biblioteca **Gson** de Google para la serialización y deserialización.
  * Para la importación, se utiliza un `TypeToken` para convertir correctamente el JSON de un *array* de usuarios de nuevo a una `List<Usuario>` en Java.
  * La importación se realiza al inicio (`cargarDatos()`) y la exportación al final (`menu()`, `case 0`), haciendo la persistencia transparente para el usuario.
* **Pruebas Unitarias:**
  * Se utiliza **JUnit 5** (a través de Maven con `scope=test`) para la validación de la lógica de negocio en un directorio `src/test/java` separado.

---

## 💻 Stack Tecnológico

* **Lenguaje:** Java (JDK 17+)
* **Gestión de Dependencias:** Maven
* **Pruebas:** JUnit 5
* **Biblioteca JSON:** Google Gson (`com.google.code.gson`)
* **Documentación:** Javadoc (con `maven-javadoc-plugin`)
* **IDE:** IntelliJ IDEA

---

## 🚀 Cómo Ejecutar

1.  Clonar este repositorio.
2.  Abrir el proyecto en un IDE (IntelliJ IDEA).
3.  El IDE detectará el archivo `pom.xml` y descargará automáticamente las dependencias (Gson y JUnit).
4.  Localizar y ejecutar el método `main()` en la clase `biblioteca.simple.app.Main`.
5.  **Para ejecutar los tests:** Hacer clic derecho en la carpeta `src/test/java` y seleccionar "Run Tests".

---

## 📸 Vistazo a la Aplicación

*Así se ve el nuevo menú principal de la biblioteca:*

```sh
╔══════════════════════════════════╗
║    📚 Menú de la Biblioteca 📚   ║
╠══════════════════════════════════╣
║ 1. Listar                        ║
║ 2. Buscar por título             ║
║ 3. Buscar por año                ║
║ 4. Prestar producto              ║
║ 5. Comprar producto              ║
║ 6. Devolver producto             ║
║ 7. Alta usuario                  ║
║ 8. Mostrar usuarios              ║
╟──────────────────────────────────╢
║ 0. Salir                         ║
╚══════════════════════════════════╝
  -> Introduce tu opción: