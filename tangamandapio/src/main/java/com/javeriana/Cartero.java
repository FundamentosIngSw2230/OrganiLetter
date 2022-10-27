package com.javeriana;

import java.util.ArrayList;

public class Cartero {
    // Declaración de variables
    int idCartero;
    ArrayList<Carta> listadoDeCartasDeCartero = new ArrayList<Carta>();
    ArrayList<Carta> rutaASeguir = new ArrayList<Carta>();

    // Constructores
    public Cartero(int idCartero, ArrayList<Carta> listadoDeCartasDeCartero, ArrayList<Carta> rutaASeguir) {
        this.idCartero = idCartero;
        this.listadoDeCartasDeCartero = listadoDeCartasDeCartero;
        this.rutaASeguir = rutaASeguir;
    }

    public Cartero() {

    }

    // Getters & Setters
    // Get idCartero
    public int getIdCartero() {
        return idCartero;
    }

    // Set idCartero
    public void setIdCartero(int idCartero) {
        this.idCartero = idCartero;
    }

    // Get listado de cartas de cartero
    public ArrayList<Carta> getListadoDeCartasDeCartero() {
        return listadoDeCartasDeCartero;
    }

    // Set listado de cartas de carterp
    public void setListadoDeCartasDeCartero(ArrayList<Carta> listadoDeCartasDeCartero) {
        this.listadoDeCartasDeCartero = listadoDeCartasDeCartero;
    }

    // Get ruta a seguir
    public ArrayList<Carta> getRutaASeguir() {
        return rutaASeguir;
    }

    // Set ruta a seguir
    public void setRutaASeguir(ArrayList<Carta> rutaASeguir) {
        this.rutaASeguir = rutaASeguir;
    }

    // ToString
    @Override
    public String toString() {
        return "Cartero{" +
                "idCartero=" + idCartero +
                ", listadoDeCartasDeCartero=" + listadoDeCartasDeCartero +
                ", rutaASeguir=" + rutaASeguir +
                '}';
    }

    // Metodos de Cartero
    public void actualizarCarta(Carta cartaAActualizar, String estadoDeLaCarta) {
        System.out.println("Actualizar Carta");
        return;
    }
}
