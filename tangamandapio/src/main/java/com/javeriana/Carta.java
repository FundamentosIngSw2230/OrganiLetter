package com.javeriana;

public class Carta
{
    //Declaración de Variables
    int idCarta;
    String fechaDeDeposito;
    String fechaDeEntrega;
    String direccionDeEntrega;
    String estadoDeCarta;
    boolean esExpress;

    //Contructores
    public Carta(int idCarta, String fechaDeDeposito, String fechaDeEntrega, String direccionDeEntrega, String estadoDeCarta, boolean esExpress)
    {
        this.idCarta = idCarta;
        this.fechaDeDeposito = fechaDeDeposito;
        this.fechaDeEntrega = fechaDeEntrega;
        this.direccionDeEntrega = direccionDeEntrega;
        this.estadoDeCarta = estadoDeCarta;
        this.esExpress = esExpress;
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

    // Get direccionDeEntrega
    public String getDireccionDeEntrega() {
        return direccionDeEntrega;
    }

    // Set direccionDeEntreg
    public void setDireccionDeEntrega(String direccionDeEntrega) {
        this.direccionDeEntrega = direccionDeEntrega;
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


    //toString
    @Override
    public String toString() {
        return "Carta{" +
                "idCarta=" + idCarta +
                ", fechaDeDeposito='" + fechaDeDeposito + '\'' +
                ", fechaDeEntrega='" + fechaDeEntrega + '\'' +
                ", direccionDeEntrega='" + direccionDeEntrega + '\'' +
                ", estadoDeCarta='" + estadoDeCarta + '\'' +
                ", esExpress=" + esExpress +
                '}';
    }


    // Metodos clase Carta
    public String notificarSobrePerdida()
    {
        return "Hola, este es el metodo que notifica sobre la perdida jajajajaj";
    }
}
