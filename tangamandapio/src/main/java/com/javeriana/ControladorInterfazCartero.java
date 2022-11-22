package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorInterfazCartero
{
    @FXML
    private Text textoNotificacionesCartero;

    @FXML
    private TextArea vizualizarRutaCartero;


    // Pasar a la interfaz principal
    @FXML
    void PasarAInterfazInicialDesdeCartero(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void botonTerminarTurno(ActionEvent event)
    {
        // Aqui se pondria que el cartero ya esta desocupado
        System.out.println("Boton terminar turno");

        textoNotificacionesCartero.setText("Turno completado");
    }

    @FXML
    void buscarRutaCartero(ActionEvent event)
    {
        String rutaAMostrar = "null"; // Cargar la ruta a ese string.

        // Aqui se le mostraria la ruta al cartero
        vizualizarRutaCartero.setText(rutaAMostrar);
        textoNotificacionesCartero.setText("La ruta ha sidi cargada exitosamente");
    }
}
