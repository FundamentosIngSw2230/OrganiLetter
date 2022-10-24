package com.javeriana;

import java.util.ArrayList;

public class Planificador
{
    // Declaración de variables
    ArrayList<Carta> cartasOrdenadas = new ArrayList <Carta>();
    ArrayList<Carta> cartasExpressEnCola = new ArrayList <Carta>();

    // Constructores
    public Planificador(ArrayList<Carta> cartasOrdenadas, ArrayList<Carta> cartasExpressEnCola)
    {
        this.cartasOrdenadas = cartasOrdenadas;
        this.cartasExpressEnCola = cartasExpressEnCola;
    }

    // Getters & Setters
    // Get Cartas Ordenadas
    public ArrayList<Carta> getCartasOrdenadas() {
        return cartasOrdenadas;
    }

    // Set Cartas Ordenadas
    public void setCartasOrdenadas(ArrayList<Carta> cartasOrdenadas) {
        this.cartasOrdenadas = cartasOrdenadas;
    }

    // Get Cartas Express En Cola
    public ArrayList<Carta> getCartasExpressEnCola() {
        return cartasExpressEnCola;
    }

    // Set Cartas Express En Cola
    public void setCartasExpressEnCola(ArrayList<Carta> cartasExpressEnCola) {
        this.cartasExpressEnCola = cartasExpressEnCola;
    }

    // ToString
    @Override
    public String toString()
    {
        return "Planificador{" +
                "cartasOrdenadas=" + cartasOrdenadas +
                ", cartasExpressEnCola=" + cartasExpressEnCola +
                '}';
    }


    // Metodos de Planificador
    // Metodo Ordenar Carta
    public void ordenarCarta(Carta cartaAOrdenar)
    {
        System.out.println("Ordenar Carta");
        return;
    }

    // Metodo Generar y Asignar Ruta A Cartero
    public Cartero generarYAsignarRutaACartero (Cartero carteroAsignado)
    {
        System.out.println("Generar y Asignar ruta a cartero");
        return carteroAsignado;
    }

    // Metodo generar reporte
    public void generarReporte(Carta HistoricoDeCartas)
    {
        System.out.println("Generar reporte");
        return;
    }

    //Metodo registrar carta en el inventario
    public void registramentoCartaEnElInventario(Carta cartaRecibida)
    {
        System.out.println("Registrar carta en el inventario");
        return;
    }

    //Metodo para que el cartero vaya a recoger los buzones
    public Cartero recogerBuzones (Cartero carteroAsignado)
    {
        System.out.println("Recoger buzones");
        return carteroAsignado;
    }
}
