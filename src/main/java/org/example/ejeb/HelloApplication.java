package org.example.ejeb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal de la aplicación JavaFX.
 * <p>
 * Extiende la clase {@link Application} para gestionar el ciclo de vida de la aplicación.
 * Esta clase configura y lanza la ventana principal de la aplicación, cargando el archivo FXML para el diseño
 * y estableciendo un icono en la ventana.
 * </p>
 */
public class HelloApplication extends Application {

    /**
     * Método de inicio de la aplicación.
     * <p>
     * Este método se invoca automáticamente al lanzar la aplicación JavaFX.
     * Carga el archivo FXML, establece el tamaño de la ventana y configura un icono y título para la ventana.
     * </p>
     *
     * @param stage el escenario principal de la aplicación, proporcionado por el sistema JavaFX.
     * @throws IOException si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        // Cargar el logo como imagen
        Image icon = new Image(getClass().getResourceAsStream("/img/agenda.png"));
        stage.getIcons().add(icon); // Establecer el ícono de la ventana

        Scene scene = new Scene(fxmlLoader.load(), 750, 450);
        stage.setTitle("Personas");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal de la aplicación.
     * <p>
     * Este método es el punto de entrada de la aplicación JavaFX, llamando al método `launch()`
     * para iniciar el ciclo de vida de la aplicación.
     * </p>
     *
     * @param args argumentos de línea de comandos (no se usan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }
}
