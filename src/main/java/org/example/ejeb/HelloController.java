package org.example.ejeb;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * Controlador de la interfaz gráfica para gestionar personas.
 * <p>
 * Esta clase se encarga de gestionar la interfaz, incluyendo la tabla de personas y los campos de entrada.
 * Permite agregar personas a la tabla y muestra mensajes de alerta para validación de entradas y acciones realizadas.
 * </p>
 */
public class HelloController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private TextField edadField;

    @FXML
    private Button agregarButton;

    @FXML
    private TableView<Persona> tableView;

    @FXML
    private TableColumn<Persona, String> nombreColumn;

    @FXML
    private TableColumn<Persona, String> apellidosColumn;

    @FXML
    private TableColumn<Persona, Integer> edadColumn;

    private ObservableList<Persona> personas;

    /**
     * Método de inicialización llamado automáticamente después de cargar el archivo FXML.
     * <p>
     * Configura la lista observable de personas y vincula las columnas de la tabla con las propiedades de cada persona.
     * También asigna la acción del botón "Agregar" para invocar el método {@link #agregarPersona()}.
     * </p>
     */
    @FXML
    public void initialize() {
        personas = FXCollections.observableArrayList();
        tableView.setItems(personas);

        // Configuración de las columnas de la tabla
        nombreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        apellidosColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellidos()));
        edadColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());

        // Asignar la acción al botón
        agregarButton.setOnAction(e -> agregarPersona());
    }

    /**
     * Agrega una nueva persona a la lista de personas.
     * <p>
     * Recoge los valores de los campos de texto, los valida y, si son correctos, crea una nueva instancia de {@link Persona}.
     * Muestra un mensaje de error si los campos están vacíos, la edad no es un número, o la persona ya existe en la lista.
     * En caso de éxito, agrega la persona a la lista y muestra un mensaje de confirmación.
     * </p>
     */
    private void agregarPersona() {
        String nombre = nombreField.getText().trim();
        String apellidos = apellidosField.getText().trim();
        String edadText = edadField.getText().trim();

        // Validación de campos
        if (nombre.isEmpty() || apellidos.isEmpty() || edadText.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben estar rellenos.");
            return;
        }

        int edad;
        try {
            edad = Integer.parseInt(edadText);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "La edad debe ser un número entero.");
            return;
        }

        Persona nuevaPersona = new Persona(nombre, apellidos, edad);

        // Comprobar si la persona ya existe
        if (personas.contains(nuevaPersona)) {
            mostrarAlerta("Error", "Esta persona ya existe en la lista.");
        } else {
            personas.add(nuevaPersona);
            mostrarAlerta("Éxito", "Persona agregada con éxito.");
        }
    }

    /**
     * Muestra una alerta informativa con el mensaje proporcionado.
     * <p>
     * Configura y muestra una ventana de alerta, que puede utilizarse para notificar al usuario de errores
     * o mensajes de éxito en la interfaz gráfica.
     * </p>
     *
     * @param titulo  Título de la alerta.
     * @param mensaje Mensaje de contenido de la alerta.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION); // Cambiado a ALERT_TYPE.INFORMATION para éxito
        alert.setTitle(titulo);
        alert.setHeaderText(null); // No encabezado
        alert.setContentText(mensaje);
        alert.showAndWait(); // Muestra la alerta y espera a que el usuario la cierre
    }
}
