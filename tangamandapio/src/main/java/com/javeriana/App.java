package com.javeriana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
<<<<<<< HEAD
    public void start(Stage stage) {
        try {
=======
    public void start(Stage stage)
    {
        try
        {
>>>>>>> 65b5c5c2e44863cf44fffedaead5482f44ce89d0
            Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(true);
            stage.setTitle("Proyecto Tangamandapio");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 01");
        launch(args);
    }

}