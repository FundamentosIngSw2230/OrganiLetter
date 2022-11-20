package com.javeriana;

public class Cliente
{
    
    public Cliente() {
    }

    // Metodos de la clase Cliente
    // Metodo Consultar Estado De La Carta
    public String consultarEstadoDeLaCarta (int idCarta)
    {
        return "Hola, esta es el metodo de Consultar el estado de la carta jajaaj";
    }

    // Metodo Generar Carta
    public Carta generarCarta (String fechaDeEntrega, String direccionDeEntrega, boolean esExpress)
    {
        int idCarta = 0;
        
        Carta cartaGenerada = new Carta(idCarta, direccionDeEntrega, fechaDeEntrega, idCarta, idCarta, idCarta, idCarta, direccionDeEntrega, esExpress);

        System.out.println("Generar Carta");
        return cartaGenerada;
    }
}
