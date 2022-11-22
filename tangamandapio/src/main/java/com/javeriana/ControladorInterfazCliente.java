package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorInterfazCliente {

    @FXML
    private TextField clienteIDCartaABuscar;

    @FXML
    private ImageView logoAsereje;


    @FXML
    private Text textoNotificacionesCliente;

    @FXML
    void PasarAInterfazInicialDesdePlanificador(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buscarCartaCliente(ActionEvent event)
    {
        try
        {
            int cartaDelClienteABuscar = Integer.parseInt(clienteIDCartaABuscar.getText());
            // EXTRAER AQUI EL ID DE LA CARTA AQUI

            textoNotificacionesCliente.setText("Buscando...");
            System.out.println("ID de la carta a buscar: " + cartaDelClienteABuscar);
        }
        catch (NumberFormatException e)
        {
            textoNotificacionesCliente.setText("El ID es incorrecto");
        }
    }

}