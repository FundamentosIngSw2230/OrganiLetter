package com.javeriana;

public class Cliente
{
    // Metodos de la clase Cliente
    // Metodo Consultar Estado De La Carta
    public String consultarEstadoDeLaCarta (int idCarta)
    {
        return "Hola, esta es el metodo de Consultar el estado de la carta jajaaj";
    }

    // Metodo Generar Carta
    public Carta generarCarta (String fechaDeEntrega, String direccionDeEntrega, boolean esExpress)
    {
        Carta cartaGenerada = new Carta(0, null, fechaDeEntrega, direccionDeEntrega,null, esExpress);

        System.out.println("Generar Carta");
        return cartaGenerada;
    }
}
