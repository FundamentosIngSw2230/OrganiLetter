package com.javeriana;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Planificador {
    // Declaración de variables
    private int calleOficina = 50;
    private int carreraOficina = 50;
    private int alcanceMaxCalle = 100;
    private int alcanceMaxCarrera = 100;
    private short contadorRutas = 1;
    private short maxCartasAentregar = 10;
    private String[] estados = { "Reparto", "Recogida", "En oficina" };
    private ArrayList<Carta> cartasEntregarNormal = new ArrayList<Carta>();
    private ArrayList<Carta> cartasRecogerNormal = new ArrayList<Carta>();
    private ArrayList<Carta> cartasEntregarExpres = new ArrayList<Carta>();
    private ArrayList<Carta> cartasRecogerExpres = new ArrayList<Carta>();

    // Constructores
    public Planificador(ArrayList<Carta> cartasEntregarNormal, ArrayList<Carta> cartasEntregarExpres) {
        this.cartasEntregarNormal = cartasEntregarNormal;
        this.cartasEntregarExpres = cartasEntregarExpres;
    }

    // Getters & Setters

    // Get Cartas Ordenadas
    public ArrayList<Carta> getcartasEntregarNormal() {
        return cartasEntregarNormal;
    }

    public int getCalleOficina() {
        return calleOficina;
    }

    public void setCalleOficina(int calleOficina) {
        this.calleOficina = calleOficina;
    }

    public int getCarreraOficina() {
        return carreraOficina;
    }

    public void setCarreraOficina(int carreraOficina) {
        this.carreraOficina = carreraOficina;
    }

    // Set Cartas Ordenadas
    public void setcartasEntregarNormal(ArrayList<Carta> cartasEntregarNormal) {
        this.cartasEntregarNormal = cartasEntregarNormal;
    }

    // Get Cartas Express En Cola
    public ArrayList<Carta> getcartasEntregarExpres() {
        return cartasEntregarExpres;
    }

    // Set Cartas Express En Cola
    public void setcartasEntregarExpres(ArrayList<Carta> cartasEntregarExpres) {
        this.cartasEntregarExpres = cartasEntregarExpres;
    }

    // ToString
    @Override
    public String toString() {
        return "Planificador{" +
                "cartasEntregarNormal=" + cartasEntregarNormal +
                ", cartasEntregarExpres=" + cartasEntregarExpres +
                '}';
    }

    // Metodos de Planificador
    // Metodo Ordenar Carta
    public void ordenarCarta(Carta cartaAOrdenar) {
        System.out.println("Ordenar Carta");
        return;
    }

    // Metodo Generar y Asignar Ruta A Cartero
    public ArrayList<Carta> generarYAsignarRutaACartero() {

        if (contadorRutas == 1 || contadorRutas == 2) {
            if (cartasEntregarExpres.size() > cartasRecogerExpres.size()) {
                contadorRutas++;
                return calcularRuta('c');
            } else {
                contadorRutas++;
                return calcularRuta('d');
            }
        } else {
            if (cartasEntregarNormal.size() > cartasRecogerNormal.size()) {
                contadorRutas = 1;
                return calcularRuta('a');
            } else {
                contadorRutas = 1;
                return calcularRuta('b');
            }
        }
    }

    // Dados una direccion y un arreglo de cartas, la funcion encuentra la carta mas
    // cercana a dicha direccion
    // a = cartasEntregarNormal, b = cartasRecogerNormal, c = cartasEntregarExpres,
    // d = cartasRecogerExpres
    public Carta cartaMasCercana(int calle, int carrera, char tipoDeArreglo) {
        Carta cartaMasCercana = new Carta(alcanceMaxCalle * 2 + 1, alcanceMaxCarrera * 2 + 1, alcanceMaxCalle * 2 + 1,
                alcanceMaxCarrera * 2 + 1);
        if (tipoDeArreglo == 'a') {
            for (Carta carta : cartasEntregarNormal) {
                if (carta.getDistancia('e', calle, carrera) < cartaMasCercana.getDistancia('e', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
            return cartaMasCercana;
        }
        if (tipoDeArreglo == 'b') {
            for (Carta carta : cartasRecogerNormal) {
                if (carta.getDistancia('r', calle, carrera) < cartaMasCercana.getDistancia('r', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
            return cartaMasCercana;
        }
        if (tipoDeArreglo == 'c') {
            for (Carta carta : cartasEntregarExpres) {
                if (carta.getDistancia('e', calle, carrera) < cartaMasCercana.getDistancia('e', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
            return cartaMasCercana;
        }
        if (tipoDeArreglo == 'd') {
            for (Carta carta : cartasRecogerExpres) {
                if (carta.getDistancia('r', calle, carrera) < cartaMasCercana.getDistancia('r', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
            return cartaMasCercana;
        }
        return cartaMasCercana;
    }

    // calcula la ruta mas corta
    // a = cartasEntregarNormal, b = cartasRecogerNormal, c = cartasEntregarExpres,
    // d = cartasRecogerExpres
    public ArrayList<Carta> calcularRuta(char tipoDeArreglo) {

        ArrayList<Carta> rutaCartas = new ArrayList<Carta>();

        if (tipoDeArreglo == 'a' && cartasEntregarNormal.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasEntregarNormal.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasEntregarNormal.remove(cartaMasCercana);
            }
            return rutaCartas;
        }
        if (tipoDeArreglo == 'b' && cartasRecogerNormal.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasRecogerNormal.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasRecogerNormal.remove(cartaMasCercana);
            }
            return rutaCartas;
        }
        if (tipoDeArreglo == 'c' && cartasEntregarExpres.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasEntregarExpres.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasEntregarExpres.remove(cartaMasCercana);
            }
            return rutaCartas;
        }
        if (tipoDeArreglo == 'd' && cartasRecogerExpres.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasRecogerExpres.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasRecogerExpres.remove(cartaMasCercana);
            }
            return rutaCartas;
        }
        return rutaCartas;
    }

    // Metodo generar reporte
    public void generarReporte(Carta HistoricoDeCartas) {
        System.out.println("Generar reporte");
        return;
    }

    // Metodo registrar carta en el inventario
    public void registramentoCartaEnElInventario(Carta cartaRecibida) {
        System.out.println("Registrar carta en el inventario");
        return;
    }

    // Metodo para que el cartero vaya a recoger los buzones
    public Cartero recogerBuzones(Cartero carteroAsignado) {
        System.out.println("Recoger buzones");
        return carteroAsignado;
    }

    // buscar el id de una carta
    public boolean buscarId(int id) {

        for (Carta carta : cartasEntregarNormal) {
            if (carta.idCarta == id) {
                return true;
            }
        }
        return false;
    }

    // Genera un id para una carta nueva
    public int generarId() {

        int idNuevo = 0;
        while (buscarId(idNuevo) == true) {
            idNuevo++;
        }
        return idNuevo;
    }

    // Genera cartas aleatoriamente
    public Carta generarCartaAleatoria() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date fechaActual = new Date();
        Random r = new Random();
        Carta carta = new Carta(generarId(), sdf.format(fechaActual), null, calleOficina, carreraOficina,
                r.nextInt(alcanceMaxCalle), r.nextInt(alcanceMaxCarrera), estados[2], r.nextBoolean());
        return carta;
    }
}
