# Proyecto Biblioteca 2.0 - EC 2

Este proyecto corresponde a la **Segunda Evaluación Continua (EC 2)** de la asignatura de Programación. El objetivo es ampliar una aplicación de consola existente de gestión de una biblioteca.

* **Alumno:** Jorge Sánchez
* **Curso:** 1º Desarrollo de Aplicaciones Web (DAW)
* **Escuela:** Prometeo

---

## 📋 Descripción del Proyecto

Partiendo de una aplicación base que gestionaba `Libros` y `Películas`, esta tarea consiste en ampliar el sistema para que sea más robusto y completo.

Los objetivos de esta ampliación eran:
1.  **Ampliar la jerarquía de clases** para incluir el nuevo tipo de producto `Videojuego`.
2.  **Mejorar la gestión de usuarios**, permitiendo su creación manual y "al vuelo" durante un préstamo.
3.  **Añadir persistencia de datos** para los usuarios mediante exportación/importación JSON.

Adicionalmente a los requisitos solicitados, **el proyecto incluye como ampliación personal** la creación de una nueva interfaz `Vendible` y una clase `Merchandising`, para demostrar una jerarquía de clases más compleja y la coexistencia de diferentes tipos de contratos (interfaces).

---

## ✨ Funcionalidades Implementadas

El menú de la aplicación ha sido modificado para incluir las nuevas funcionalidades, ofreciendo:

* **Listar Catálogo Completo:** Muestra todos los productos (Libros, Películas, Videojuegos y Merchandising).
* **Buscar por Título / Año:** Filtra el catálogo según los criterios del usuario.
* **Prestar Producto:**
    * Permite prestar cualquier ítem que sea `Prestable` (Libros, Películas y el nuevo `Videojuego`).
    * Solicita el ID de un usuario.
    * **Mejora clave:** Si el usuario introducido no existe, el sistema ofrece crearlo en ese mismo momento sin cancelar la operación de préstamo.
* **Devolver Producto:** Libera un producto que estaba prestado.
* **Gestión de Usuarios:**
    * **Crear Usuario Manualmente:** Una opción de menú dedicada para dar de alta nuevos usuarios.
    * **Exportar Usuarios a JSON:** Guarda la lista actual de usuarios en un archivo `usuarios.json`.
    * **Importar Usuarios desde JSON:** Carga la lista de usuarios desde `usuarios.json`.
* **Salir:** Cierra la aplicación.

---

## 🛠️ Estructura Técnica y Diseño

Para cumplir con los requisitos, el proyecto se ha estructurado siguiendo los principios de la Programación Orientada a Objetos:

### 1. Herencia e Interfaces

* **`Producto` (Clase Abstracta):** Sirve como clase base para todos los artículos del catálogo.
* **`Videojuego` (Clase Requerida):**
    * Hereda de `Producto`.
    * Añade atributos propios (p.ej., `Plataforma`, `Genero`, `PEGI`).
    * Implementa la interfaz `Prestable`.
* **`Merchandising` (Ampliación Personal):**
    * Hereda de `Producto`.
    * Representa artículos que no se prestan pero se venden (figuras, tazas, ropa).
    * Implementa la interfaz `Vendible`.

### 2. Contratos (Interfaces)

* **`Prestable` (Interfaz Requerida):** Contrato que define el comportamiento de préstamo (`prestar()`, `devolver()`, `estaPrestado()`). Es implementado por `Libro`, `Pelicula` y `Videojuego`.
* **`Vendible` (Interfaz Personal):** Contrato de creación propia para definir el comportamiento de los productos que tienen un precio y pueden ser vendidos. Es implementado por `Merchandising`.

### 3. Gestión de Usuarios y Préstamos

La lógica de préstamo (`prestar()`) ha sido modificada para ser más flexible. En lugar de abortar la operación si un usuario no existe, se encapsula la lógica de "comprobar o crear" en un método (`comprobarExistenciaUser()`), mejorando la experiencia de usuario.

### 4. Persistencia con JSON

Se han implementado métodos para la serialización (guardado) y deserialización (lectura) de la lista de `Usuario` a un archivo `usuarios.json`, permitiendo que los datos de usuario persistan entre ejecuciones.

---

## 🚀 Cómo Ejecutar

1.  Clonar este repositorio.
2.  Abrir el proyecto en un IDE (como IntelliJ IDEA).
3.  Asegurarse de tener configurado el JDK de Java.
4.  Ejecutar el método `main()` en la clase `biblioteca.simple.app.Main`.