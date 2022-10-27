package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorInterfazPlanificador {

    @FXML
    private ImageView imageViewLogoPlanificador;

    @FXML
    private TextField textoIdCartaOrdenar;

    @FXML
    private TextField textoIdCarteroAsignarRuta;

    @FXML
    private TextArea textAreaRutaGenerada;

    @FXML
    private TextField textoIdCarteroBuzones;

    @FXML
    private Text textoNotificacionesPlanificador;

    @FXML
    void PasarAInterfazInicial(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // ----------------------------------------------------------------
    // GENERAR REPORTE
    @FXML
    void accionarBotonGenerarReporte(ActionEvent event)
    {
        System.out.println("Holaa, este es el boton de generar reporte");
    }


    // ----------------------------------------------------------------
    // GENERAR Y ASIGNAR RUTA
    @FXML
    void accionarBotonGenerarYAsignarRuta(ActionEvent event)
    {
        int idCarteroAsignado;

        System.out.println("Holaa, este es el boton de generar y asignar ruta");

        try
        {
            idCarteroAsignado = Integer.parseInt(textoIdCarteroAsignarRuta.getText());
            System.out.println("El ID puesto en el campo es: " + idCarteroAsignado);

            textoNotificacionesPlanificador.setText("ID del cartero asignado: " + idCarteroAsignado);

            // Mientras tanto...
            textAreaRutaGenerada.setText(String.valueOf(idCarteroAsignado));
        }
        catch (NumberFormatException e)
        {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------
    // ORGANIZAR CARTA
    @FXML
    void accionarBotonOrganizarCarta(ActionEvent event)
    {
        int idCartaAOrdenar;

        System.out.println("Holaa, este es el boton organizar carta");

        try
        {
            idCartaAOrdenar = Integer.parseInt(textoIdCartaOrdenar.getText());
            System.out.println("El ID puesto en el campo es: " + idCartaAOrdenar);

            textoNotificacionesPlanificador.setText("ID de la carta organizada: " + idCartaAOrdenar);
        }
        catch (NumberFormatException e)
        {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------
    // RECOGER BUZONES
    @FXML
    void accionarBotonRecogerBuzones(ActionEvent event)
    {
        int idCarteroAsignadoBuzonez;

        System.out.println("Holaa, este es el boton recoger buzones");

        try
        {
            idCarteroAsignadoBuzonez = Integer.parseInt(textoIdCarteroBuzones.getText());
            System.out.println("El ID puesto en el campo es: " + idCarteroAsignadoBuzonez);

            textoNotificacionesPlanificador.setText("ID del cartero asignado a recoger buzones: " + idCarteroAsignadoBuzonez);
        }
        catch (NumberFormatException e)
        {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }

    //Generar arreglo de strings con las direcciones
    public ArrayList<String> generarDirecciones() {
        String calle = "calle";
        String carrera = "carrera";
        String direccion = null;
        ArrayList<Carta> cartas = generarYAsignarRutaACartero();
        ArrayList<String> direcciones = new ArrayList<String>();
        for (Carta carta : cartas) {
            direccion = calle + " " + carta.getCalleEntrega() + "," + carrera + " " + carta.getCarreraEntrega();
            direcciones.add(direccion);
        }
        return direcciones;
    }
}
