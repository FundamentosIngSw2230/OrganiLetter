package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ControladorInterfazPrincipal
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void PasarAInterfazPlanificador(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("InterfazPlanificador.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PasarAInterfazCartero(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("InterfazCartero.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PasarAInterfazReporte(ActionEvent event)
    {
        System.out.println("Hola");
    }

}
