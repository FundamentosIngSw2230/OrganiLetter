package com.javeriana;

import java.util.ArrayList;

public class Cartero {
    // Declaración de variables
    private int idCartero;
    private String estado; //EnReparto Recogiendo Disponible
    private ArrayList<Carta> listadoDeCartasDeCartero = null;

    // Constructores
    public Cartero(int idCartero, String estado, ArrayList<Carta> listadoDeCartasDeCartero) {
        this.idCartero = idCartero;
        this.estado = estado;
        this.listadoDeCartasDeCartero = listadoDeCartasDeCartero;
    }

    public Cartero() {

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

    @Override
    public String toString() {
        return "Cartero [idCartero=" + idCartero + ", estado=" + estado + ", listadoDeCartasDeCartero="
                + listadoDeCartasDeCartero + "]";
    }

    // Metodos de Cartero
    public void actualizarCarta(Carta cartaAActualizar, String estadoDeLaCarta) {
        System.out.println("Actualizar Carta");
        return;
    }

    public void setAllCartas(String string) {
        for (Carta carta : listadoDeCartasDeCartero) {
            carta.setEstadoDeCarta(string);
        }
    }
//EnReparto Recogiendo Disponible
    public String getDireccionesStr(){
        String direcciones = new String("");
        if (estado.equals("EnReparto")) {
            for (Carta carta : listadoDeCartasDeCartero) {
                direcciones = new String(direcciones+"[Calle: " + carta.getCalleEntrega() + ", Carrera: " + carta.getCarreraEntrega()+"] ");
            }
        }
        if (estado.equals("Recogiendo")) {
            for (Carta carta : listadoDeCartasDeCartero) {
                direcciones = new String(direcciones+"[Calle: " + carta.getCalleEntrega() + ", Carrera: " + carta.getCarreraEntrega()+"] ");
            }
        }
        return direcciones;
    }

}
