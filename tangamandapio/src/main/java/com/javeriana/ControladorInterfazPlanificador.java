package com.javeriana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorInterfazPlanificador {

    @FXML
    private RadioButton actualizarCartaEnBuzon;

    @FXML
    private RadioButton actualizarCartaEnOficina;

    @FXML
    private RadioButton actualizarCartaEnRutaRecogida;

    @FXML
    private RadioButton actualizarCartaEntregada;

    @FXML
    private RadioButton actualizarCartaRutaEntregada;

    @FXML
    private ToggleGroup estadoDeLaCarta;

    @FXML
    private ImageView imageViewLogoPlanificador;

    @FXML
    private TextArea textAreaRutaGenerada;

    @FXML
    private TextField textoIdCartaOrdenar;

    @FXML
    private TextField textoIdCarteroAsignarRuta;

    @FXML
    private TextField textoIdCarteroBuzones;

    @FXML
    private Text textoNotificacionesPlanificador;

    @FXML
    private TextField actualizarCartaID;

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




    // ----------------------------------------------------------------
    // ACTUALIZAR CARTA
    @FXML
    void accionarBotonActualizarCarta(ActionEvent event)
    {
        // Este es el estado de la carta
        String estadoDeLaCarta = null;
        // Este es el ID de la carta
        int idCartaAActualizar = 0;

        System.out.println("Holaa, este es el boton de actualizar carta");

        // Tomar el ID de la carta a actualizar
        try
        {
            idCartaAActualizar = Integer.parseInt(actualizarCartaID.getText());
            // EXTRAER AQUI EL ID DE LA CARTA AQUI
        }
        catch (NumberFormatException e)
        {
            textoNotificacionesPlanificador.setText("El ID es incorrecto");
        }

        // Tomar el estado a actualizar
        if(actualizarCartaEnBuzon.isSelected())
        {
            estadoDeLaCarta = "EnBuzon";
        }
        if (actualizarCartaEnOficina.isSelected())
        {
            estadoDeLaCarta = "EnOficina";
        }
        if(actualizarCartaEnRutaRecogida.isSelected())
        {
            estadoDeLaCarta = "EnRutaRecogida";
        }
        if(actualizarCartaEntregada.isSelected())
        {
            estadoDeLaCarta = "EnRutaEntrega";
        }
        if(actualizarCartaEntregada.isSelected())
        {
            estadoDeLaCarta = "Entregada";
        }
        // SACAR EL ESTADO DE LA CARTA AQUI

        System.out.println("El ID de la carta es: " + idCartaAActualizar);
        System.out.println("El estado seleccionado es: " + estadoDeLaCarta);
    }

    // ----------------------------------------------------------------
    // GENERAR Y ASIGNAR RUTA
    @FXML
    void accionarBotonGenerarYAsignarRuta(ActionEvent event) {
        int idCarteroAsignado;

        System.out.println("Holaa, este es el boton de generar y asignar ruta");

        try {
            idCarteroAsignado = Integer.parseInt(textoIdCarteroAsignarRuta.getText());
            System.out.println("El ID puesto en el campo es: " + idCarteroAsignado);
            textoNotificacionesPlanificador.setText("ID del cartero asignado: " + idCarteroAsignado);

            // Mientras tanto...

            textAreaRutaGenerada.setText(FachadaOrganiLetter.getRuta(idCarteroAsignado));
        } catch (NumberFormatException e) {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------
    // ORGANIZAR CARTA
    @FXML
    void accionarBotonOrganizarCarta(ActionEvent event) {
        int idCartaAOrdenar;

        System.out.println("Holaa, este es el boton organizar carta");

        try {
            idCartaAOrdenar = Integer.parseInt(textoIdCartaOrdenar.getText());
            System.out.println("El ID puesto en el campo es: " + idCartaAOrdenar);

            textoNotificacionesPlanificador.setText("ID de la carta organizada: " + idCartaAOrdenar);
        } catch (NumberFormatException e) {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ----------------------------------------------------------------
    // RECOGER BUZONES
    @FXML
    void accionarBotonRecogerBuzones(ActionEvent event) {
        int idCarteroAsignadoBuzonez;

        System.out.println("Holaa, este es el boton recoger buzones");

        try {
            idCarteroAsignadoBuzonez = Integer.parseInt(textoIdCarteroBuzones.getText());
            System.out.println("El ID puesto en el campo es: " + idCarteroAsignadoBuzonez);

            textoNotificacionesPlanificador
                    .setText("ID del cartero asignado a recoger buzones: " + idCarteroAsignadoBuzonez);
        } catch (NumberFormatException e) {
            textoNotificacionesPlanificador.setText(String.valueOf("Error, input invalido"));
            System.out.println("Error: " + e.getMessage());
        }
    }
}
