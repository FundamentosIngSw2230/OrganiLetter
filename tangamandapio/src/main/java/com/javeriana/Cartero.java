package com.javeriana;

import java.util.ArrayList;

public class Cartero
{
    // Declaración de variables
    private int idCartero;
    private String estado;
    private ArrayList <Carta> listadoDeCartasDeCartero = null;
    private ArrayList <Carta> rutaASeguir = null;
    
    // Constructores
    public Cartero(int idCartero, String estado, ArrayList<Carta> listadoDeCartasDeCartero,
            ArrayList<Carta> rutaASeguir) {
        this.idCartero = idCartero;
        this.estado = estado;
        this.listadoDeCartasDeCartero = listadoDeCartasDeCartero;
        this.rutaASeguir = rutaASeguir;
    }
    
    // Getters & Setters
    // Get getEstado
    public String getEstado() {
        return estado;
    }

    // Set getEstado
    public void setEstado(String estado) {
        this.estado = estado;
    }

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
    
    //ToString
    @Override
    public String toString() 
    {
        return "Cartero{" +
                "idCartero=" + idCartero +
                ", listadoDeCartasDeCartero=" + listadoDeCartasDeCartero +
                ", rutaASeguir=" + rutaASeguir +
                '}';
    }
    
    // Metodos de Cartero
    public void actualizarCarta(Carta cartaAActualizar, String estadoDeLaCarta)
    {
        System.out.println("Actualizar Carta");
        return;
    }



    

    
}
