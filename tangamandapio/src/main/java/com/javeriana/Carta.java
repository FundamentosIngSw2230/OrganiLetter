package com.javeriana;

import java.lang.FdLibm.Pow;
import java.util.Date;

public class Carta
{
    //Declaración de Variables
    int idCarta;
    String fechaDeDeposito;
    String fechaDeEntrega;
    int calleRecogida;
    int carreraRecogida;
    int calleEntrega;
    int carreraEntrega;
    String estadoDeCarta;
    boolean esExpress;

    //Contructores
    public Carta(int idCarta, String fechaDeDeposito, String fechaDeEntrega, int calleRecogida, int carreraRecogida,
            int calleEntrega, int carreraEntrega, String estadoDeCarta, boolean esExpress) {
        this.idCarta = idCarta;
        this.fechaDeDeposito = fechaDeDeposito;
        this.fechaDeEntrega = fechaDeEntrega;
        this.calleRecogida = calleRecogida;
        this.carreraRecogida = carreraRecogida;
        this.calleEntrega = calleEntrega;
        this.carreraEntrega = carreraEntrega;
        this.estadoDeCarta = estadoDeCarta;
        this.esExpress = esExpress;
    }

    public Carta(int calleRecogida, int carreraRecogida, int calleEntrega, int carreraEntrega) {
        this.calleRecogida = calleRecogida;
        this.carreraRecogida = carreraRecogida;
        this.calleEntrega = calleEntrega;
        this.carreraEntrega = carreraEntrega;
    }

    //Setters & Getters
    // Get idCarta
    public int getIdCarta() {
        return idCarta;
    }

    // Set idCarta
    public void setIdCarta(int idCarta)
    {
        this.idCarta = idCarta;
    }

    // Get fechaDeDeposito
    public String getFechaDeDeposito() {
        return fechaDeDeposito;
    }

    // Set fechaDeDeposito
    public void setFechaDeDeposito(String fechaDeDeposito) {
        this.fechaDeDeposito = fechaDeDeposito;
    }

    // Get fechaDeEntrega
    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    // Set fechaDeEntrega
    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    // get Calle Recogida
    public int getCalleRecogida() {
        return calleRecogida;
    }

    //set Calle Recogida
    public void setCalleRecogida(int calleRecogida) {
        this.calleRecogida = calleRecogida;
    }

    // get Carrera Recogida
    public int getCarreraRecogida() {
        return carreraRecogida;
    }

    //set Carrera Recogida
    public void setCarreraRecogida(int carreraRecogida) {
        this.carreraRecogida = carreraRecogida;
    }

    // get Calle Entrega
    public int getCalleEntrega() {
        return calleEntrega;
    }

    //set Calle Entrega
    public void setCalleEntrega(int calleEntrega) {
        this.calleEntrega = calleEntrega;
    }

    // get Carrera Entrega
    public int getCarreraEntrega() {
        return carreraEntrega;
    }

    //set Carrera Entrega
    public void setCarreraEntrega(int carreraEntrega) {
        this.carreraEntrega = carreraEntrega;
    }

    // Get estadoDeLaCarta
    public String getEstadoDeCarta() {
        return estadoDeCarta;
    }

    // Set estadoDeLaCarta
    public void setEstadoDeCarta(String estadoDeCarta) {
        this.estadoDeCarta = estadoDeCarta;
    }

    // Get esExpress (is)
    public boolean isEsExpress() {
        return esExpress;
    }

    // Set esExpress
    public void setEsExpress(boolean esExpress) {
        this.esExpress = esExpress;
    }


    @Override
    public String toString() {
        return "Carta [idCarta=" + idCarta + ", fechaDeDeposito=" + fechaDeDeposito + ", fechaDeEntrega="
                + fechaDeEntrega + ", calleRecogida=" + calleRecogida + ", carreraRecogida=" + carreraRecogida
                + ", calleEntrega=" + calleEntrega + ", carreraEntrega=" + carreraEntrega + ", estadoDeCarta="
                + estadoDeCarta + ", esExpress=" + esExpress + "]";
    }


    // Metodos clase Carta
    public String notificarSobrePerdida()
    {
        return "Hola, este es el metodo que notifica sobre la perdida jajajajaj";
    }

    //Calcula la distacia entre la direccion de la carta y una direccion dada
    public double getDistancia(char opcion, int calleDestino, int carreraDestino) {
        if (opcion == 'e') {
            return Math.sqrt(Math.pow(calleDestino - calleEntrega,2) + Math.pow(carreraDestino - carreraEntrega,2));
        } else {
            return Math.sqrt(Math.pow(calleDestino - calleRecogida,2) + Math.pow(carreraDestino - carreraRecogida,2));
        }
        
    }
    
}
