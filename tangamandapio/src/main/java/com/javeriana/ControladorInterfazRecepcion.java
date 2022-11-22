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
    @FXML
    void RegistrarCartaRecepcion(ActionEvent event)
    {
        // Si la carta es de envio express o no
        boolean esExpress;

        System.out.println("Holaa");
        // Obtener ID carta
        try
        {
            int idCarta = Integer.parseInt(registrarCartaID.getText());
        }
        catch (NumberFormatException e) {
            textoNotificacionesRecepcion.setText("El ID es incorrecto");
            return;
        }

        // Obtener fecha de deposito
        try
        {
            String fechaDeDeposito = registrarCartaFechaDeDeposito.getText();
        }
        catch (Exception e) {
            textoNotificacionesRecepcion.setText("La fecha de deposito es incorrecta");
        }

        // Obtener fecha de entrega
        try
        {
            String fechaDeEntrega = registrarCartaFechaDeEntrega.getText();
        }
        catch (Exception e) {
            textoNotificacionesRecepcion.setText("La fecha de entrega es incorrecta");
        }

        // Obtener calle - direccion de recogida
        try
        {
            int calleRecogida = Integer.parseInt(registrarCartaCalleRecogida.getText());
        }
        catch (NumberFormatException e) {
            textoNotificacionesRecepcion.setText("La calle de recogida es incorrecta");
            return;
        }

        // Obtener carrera - direccion de recogida
        try
        {
            int carreraRecogida = Integer.parseInt(registrarCartaCarreraRecogida.getText());
        }
        catch (NumberFormatException e) {
            textoNotificacionesRecepcion.setText("La carrera de recogida es incorrecta");
            return;
        }

        // Obtener calle - direccion de entrega
        try
        {
            int calleEntrega = Integer.parseInt(registrarCartaCalleEntrega.getText());
        }
        catch (NumberFormatException e) {
            textoNotificacionesRecepcion.setText("La calle de entrega es incorrecta");
            return;
        }

        // Obtener carrera - direccion de entrega
        try
        {
            int carreraEntrega = Integer.parseInt(registrarCartaCarreraEntrega.getText());
        }
        catch (NumberFormatException e) {
            textoNotificacionesRecepcion.setText("La calle de entrega es incorrecta");
            return;
        }

        // Obtener estado de la carta
        // Este es para comprobar si esta bien ingresado o no
        String estado = registrarCartaEstadoCarta.getText();

        // Utilizar este
        String estadoFinal;

        switch (estado)
        {
            case ("En buzon"):
            {
                estadoFinal = "EnBuzon";
                break;
            }

            case ("En oficina"):
            {
                estadoFinal = "EnOficina";
                break;
            }

            case ("En Ruta de Recogida"):
            {
                estadoFinal = "EnRutaRecogida";
                break;
            }

            case ("En Ruta de Entrega"):
            {
                estadoFinal = "EnRutaEntrega";
                break;
            }

            case ("Entregada"):
            {
                estadoFinal = "Entregada";
                break;
            }

            default:
            {
                textoNotificacionesRecepcion.setText("Estado ingresado de forma incorrecta");
            }
        }


        // Obtener si es express o no
        if(registrarCartaExpressNO.isSelected())
        {
            esExpress = false;
        }
        else
        {
            esExpress = true;
        }
    }

    // Buscar carta
    @FXML
    void BuscarCartaRecepcion(ActionEvent event)
    {
        System.out.println("Holaa buscar");
    }
}
