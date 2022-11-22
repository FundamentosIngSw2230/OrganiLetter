package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorInterfazReporte {

    @FXML
    private ImageView logoAsereje;

    @FXML
    private Text numeroDeCartasEnOficina;

    @FXML
    private Text numeroDeCartasEnRutaDeEntrega;

    @FXML
    private Text numeroDeCartasEnRutaRecogida;

    @FXML
    private Text numeroDeCartasEntregadas;

    @FXML
    private Text numeroDeCarterosActivos;

    @FXML
    void PasarAInterfazInicialDesdeReporte(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void actualizarReporte(ActionEvent event)
    {
        int cantidadCartasEntregadas = 0; // Poner donde va el 0 la cantidad de cada elemento
        int cantidadCartasEnOficina = 0; // Poner donde va el 0 la cantidad de cada elemento
        int cantidadCartasEnRutaRecogida = 0; // Poner donde va el 0 la cantidad de cada elemento
        int cantidadCartasEnRutaEntrega = 0; // Poner donde va el 0 la cantidad de cada elemento

        int cantidadCarterosActivos = 0; // Poner donde va el 0 la cantidad de cada elemento

        numeroDeCartasEntregadas.setText(String.valueOf(cantidadCartasEntregadas));
        numeroDeCartasEnOficina.setText(String.valueOf(cantidadCartasEnOficina));
        numeroDeCartasEnRutaRecogida.setText(String.valueOf(cantidadCartasEnRutaRecogida));
        numeroDeCartasEnRutaDeEntrega.setText(String.valueOf(cantidadCartasEnRutaEntrega));
        numeroDeCarterosActivos.setText(String.valueOf(cantidadCarterosActivos));
    }
}
