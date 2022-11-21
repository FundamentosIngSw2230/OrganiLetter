package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

<<<<<<< HEAD:tangamandapio/src/main/java/com/javeriana/PrimaryController.java
public class PrimaryController {
=======
public class ControladorInterfazPrincipal
{
>>>>>>> d9c9780bd51a799074056a505454df57b7f8ff89:tangamandapio/src/main/java/com/javeriana/ControladorInterfazPrincipal.java
    private Stage stage;
    private Scene scene;

    @FXML
    void PasarAInterfazPlanificador(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazPlanificador.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
<<<<<<< HEAD:tangamandapio/src/main/java/com/javeriana/PrimaryController.java
    void PasarAInterfazInicial(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
=======
    void PasarAInterfazCartero(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazCartero.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
>>>>>>> d9c9780bd51a799074056a505454df57b7f8ff89:tangamandapio/src/main/java/com/javeriana/ControladorInterfazPrincipal.java
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
<<<<<<< HEAD:tangamandapio/src/main/java/com/javeriana/PrimaryController.java
    void PasarAInterfazPlanificador(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("secondary.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
=======
    void PasarAInterfazReporte(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InterfazReporte.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
>>>>>>> d9c9780bd51a799074056a505454df57b7f8ff89:tangamandapio/src/main/java/com/javeriana/ControladorInterfazPrincipal.java
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
