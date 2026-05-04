# APP: Lista compra - JavaFX

Este proyecto es una aplicación de escritorio diseñada para gestionar una lista de la compra de forma sencilla e intuitiva. Ha sido desarrollado como parte del módulo **Desarrollo de Interfaces** del ciclo DAM.

## Características

*   **Gestión de productos**: Añadir artículos mediante teclado (Enter) o botón visual.
*   **Interfaz Dinámica**: Marcado de productos como "comprados".
*   **Eliminación Selectiva**: Cada producto cuenta con su propio botón de borrado individual.
*   **Contador en Tiempo Real**: Visualización del número total de productos en la lista.
*   **Limpieza Rápida**: Botón para vaciar la lista completa de una sola vez.
*   **Diseño Moderno**: Interfaz estilizada mediante hoja de estilo CSS.

## Tecnologías Utilizadas

*   **Java 17** 
*   **JavaFX**: Framework para la interfaz gráfica.
*   **Scene Builder**: Para el diseño FXML.
*   **Maven**: Gestión de dependencias y construcción del proyecto.
*   **CSS3**: Personalización de componentes y estados visuales.

## Estructura del Proyecto (MVC)

El proyecto sigue una arquitectura organizada para separar la lógica del diseño:

*   `HelloApplication.java`: Punto de entrada que configura el Stage y carga el CSS.
*   `HelloController.java`: Gestiona la lógica de eventos y la manipulación de la `ObservableList`.
*   `Producto.java`: Modelo de datos que utiliza Properties para el binding.
*   `hello-view.fxml`: Definición estructural de la interfaz.
*   `estilos.css`: Hoja de estilos para la personalización visual.

## Instalación y Ejecución

1. Clona el repositorio: `git clone https://github.com/tu-usuario/ProyectoListaCompra.git`
2. Abre el proyecto en **IntelliJ IDEA**.
3. Importa las dependencias de **Maven**.
4. Ejecuta la clase `HelloApplication`.

## Capturas de Pantalla

Para ver la aplicación en funcionamiento:

![Captura de la aplicación](/src/main/resources/org/example/proyectolistacompra/assets/applistacompra.png)

---
Desarrollado por Joanne M Zamorano - 05.2026