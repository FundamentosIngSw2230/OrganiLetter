package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorInterfazRecepcion
{
    @FXML
    private ImageView logoAsereje;

    @FXML
    private TextField registrarCartaCalleEntrega;

    @FXML
    private TextField registrarCartaCalleRecogida;

    @FXML
    private TextField registrarCartaCarreraEntrega;

    @FXML
    private TextField registrarCartaCarreraRecogida;

    @FXML
    private TextField registrarCartaEstadoCarta;

    @FXML
    private RadioButton registrarCartaExpressNO;

    @FXML
    private RadioButton registrarCartaExpressSI;

    @FXML
    private TextField registrarCartaFechaDeDeposito;

    @FXML
    private TextField registrarCartaFechaDeEntrega;

    @FXML
    private TextField registrarCartaID;

    @FXML
    private Text textoNotificacionesRecepcion;


    // Pasar a la interfaz principal
    @FXML
    void PasarAInterfazInicialDesdePlanificador(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Registrar carta
    
}
