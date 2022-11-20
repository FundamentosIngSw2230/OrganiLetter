package com.javeriana;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;


public class Planificador {

    // Declaración de variables
    private static int calleOficina = 50;
    private static int carreraOficina = 50;
    private static int alcanceMaxCalle = 100;
    private static int alcanceMaxCarrera = 100;
    private static short bifurcador = 1;
    private static short maxCartasAentregar = 10;
    private static String[] estadosCarta = {"EnBuzon", "EnOficina", "EnRutaRecogida", "EnRutaEntrega", "Entregada"};
    
    static ArrayList<Carta> cartasEntregarNormal;
    static ArrayList<Carta> cartasRecogerNormal;
    static ArrayList<Carta> cartasEntregarExpres;
    static ArrayList<Carta> cartasRecogerExpres;
    static ArrayList<Carta> cartasEntregadas;
    static ArrayList<Cartero> carteros;

    // Constructores
    public Planificador() {
        ElManejadorDeArchivos manejadorDeArchivos = new ElManejadorDeArchivos();
        ArrayList<Carta> cartasLeidas = manejadorDeArchivos.readJsonCarta();
        for (Carta carta : cartasLeidas) {
            ordenarCarta(carta);
        }
        carteros = manejadorDeArchivos.readJsonCartero();
    }
    
    // Getters & Setters
    public static int getCalleOficina() {
        return calleOficina;
    }

    public static void setCalleOficina(int calleOficina) {
        Planificador.calleOficina = calleOficina;
    }

    public static int getCarreraOficina() {
        return carreraOficina;
    }

    public static void setCarreraOficina(int carreraOficina) {
        Planificador.carreraOficina = carreraOficina;
    }

    public static int getAlcanceMaxCalle() {
        return alcanceMaxCalle;
    }

    public static void setAlcanceMaxCalle(int alcanceMaxCalle) {
        Planificador.alcanceMaxCalle = alcanceMaxCalle;
    }

    public static int getAlcanceMaxCarrera() {
        return alcanceMaxCarrera;
    }

    public static void setAlcanceMaxCarrera(int alcanceMaxCarrera) {
        Planificador.alcanceMaxCarrera = alcanceMaxCarrera;
    }

    public static short getBifurcador() {
        return bifurcador;
    }

    public static void setBifurcador(short bifurcador) {
        Planificador.bifurcador = bifurcador;
    }

    public static short getMaxCartasAentregar() {
        return maxCartasAentregar;
    }

    public static void setMaxCartasAentregar(short maxCartasAentregar) {
        Planificador.maxCartasAentregar = maxCartasAentregar;
    }

    public static String[] getEstadosCarta() {
        return estadosCarta;
    }

    public static void setEstadosCarta(String[] estadosCarta) {
        Planificador.estadosCarta = estadosCarta;
    }

    public static ArrayList<Carta> getCartasEntregarNormal() {
        return cartasEntregarNormal;
    }

    public static void setCartasEntregarNormal(ArrayList<Carta> cartasEntregarNormal) {
        Planificador.cartasEntregarNormal = cartasEntregarNormal;
    }

    public static ArrayList<Carta> getCartasRecogerNormal() {
        return cartasRecogerNormal;
    }

    public static void setCartasRecogerNormal(ArrayList<Carta> cartasRecogerNormal) {
        Planificador.cartasRecogerNormal = cartasRecogerNormal;
    }

    public static ArrayList<Carta> getCartasEntregarExpres() {
        return cartasEntregarExpres;
    }

    public static void setCartasEntregarExpres(ArrayList<Carta> cartasEntregarExpres) {
        Planificador.cartasEntregarExpres = cartasEntregarExpres;
    }

    public static ArrayList<Carta> getCartasRecogerExpres() {
        return cartasRecogerExpres;
    }

    public static void setCartasRecogerExpres(ArrayList<Carta> cartasRecogerExpres) {
        Planificador.cartasRecogerExpres = cartasRecogerExpres;
    }

    public static ArrayList<Carta> getCartasEntregadas() {
        return cartasEntregadas;
    }

    public static void setCartasEntregadas(ArrayList<Carta> cartasEntregadas) {
        Planificador.cartasEntregadas = cartasEntregadas;
    }

    public static ArrayList<Cartero> getCarteros() {
        return carteros;
    }

    public static void setCarteros(ArrayList<Cartero> carteros) {
        Planificador.carteros = carteros;
    }

    // Metodos de Planificador
    // Metodo Ordenar Carta -> guarda la carta en uno de los cuatro vectores de acuerdo a su estado prioridad
    public void ordenarCarta(Carta cartaAOrdenar) {
        
        switch (cartaAOrdenar.getEstadoDeCarta()) {
            case "EnBuzon":
                if (cartaAOrdenar.getEsExpress() == true) {
                    cartasRecogerExpres.add(cartaAOrdenar);
                } else {
                    cartasRecogerNormal.add(cartaAOrdenar);
                }
                break;
            case "EnOficina":
                if (cartaAOrdenar.getEsExpress() == true) {
                    cartasEntregarExpres.add(cartaAOrdenar);
                } else {
                    cartasEntregarNormal.add(cartaAOrdenar);
                }
                break;
            case "Entregada":
                cartasEntregadas.add(cartaAOrdenar);
                break;
            default:
                break;
        }
    }

    // Metodo Generar y Asignar Ruta A Cartero.
    public void generarYAsignarRutaACartero(int idCartero) {

        for (Cartero cartero : carteros) {
            if (cartero.getIdCartero() == idCartero) {
                cartero.setEstado("en reparto");
                if (bifurcador == 1 || bifurcador == 2) {
                    if (cartasEntregarExpres.size() > cartasRecogerExpres.size()) {
                        bifurcador++;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('c'));
                    } else {
                        bifurcador++;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('d'));
                    }
                } else {
                    if (cartasEntregarNormal.size() > cartasRecogerNormal.size()) {
                        bifurcador = 1;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('a'));
                    } else {
                        bifurcador = 1;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('b'));
                    }
                }
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
        }
        if (tipoDeArreglo == 'b') {
            for (Carta carta : cartasRecogerNormal) {
                if (carta.getDistancia('r', calle, carrera) < cartaMasCercana.getDistancia('r', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
        }
        if (tipoDeArreglo == 'c') {
            for (Carta carta : cartasEntregarExpres) {
                if (carta.getDistancia('e', calle, carrera) < cartaMasCercana.getDistancia('e', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
        }
        if (tipoDeArreglo == 'd') {
            for (Carta carta : cartasRecogerExpres) {
                if (carta.getDistancia('r', calle, carrera) < cartaMasCercana.getDistancia('r', calle, carrera)) {
                    cartaMasCercana = carta;
                }
            }
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
        }
        if (tipoDeArreglo == 'b' && cartasRecogerNormal.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasRecogerNormal.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasRecogerNormal.remove(cartaMasCercana);
            }
        }
        if (tipoDeArreglo == 'c' && cartasEntregarExpres.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasEntregarExpres.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasEntregarExpres.remove(cartaMasCercana);
            }
        }
        if (tipoDeArreglo == 'd' && cartasRecogerExpres.size() != 0) {
            Carta cartaMasCercana = new Carta(calleOficina, carreraOficina, calleOficina, carreraOficina);
            for (int i = 0; (i < maxCartasAentregar) && (cartasRecogerExpres.size() != 0); i++) {
                cartaMasCercana = cartaMasCercana(cartaMasCercana.getCalleEntrega(),
                        cartaMasCercana.getCarreraEntrega(), tipoDeArreglo);
                rutaCartas.add(cartaMasCercana);
                cartasRecogerExpres.remove(cartaMasCercana);
            }
        }
        return rutaCartas;
    }

    // Metodo generar reporte
    public void generarReporte(Carta HistoricoDeCartas) {
        System.out.println("Generar reporte");
        return;
    }

    // buscar el id de una carta
    public boolean buscarId(int id) {

        for (Carta carta : cartasEntregarNormal) {
            if (carta.idCarta == id) {
                return true;
            }
        }
        for (Carta carta : cartasRecogerNormal) {
            if (carta.idCarta == id) {
                return true;
            }
        }
        for (Carta carta : cartasEntregarExpres) {
            if (carta.idCarta == id) {
                return true;
            }
        }
        for (Carta carta : cartasRecogerExpres) {
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
                r.nextInt(alcanceMaxCalle), r.nextInt(alcanceMaxCarrera), estadosCarta[2], r.nextBoolean());
        return carta;
    }

    // retorna un arreglo de strings con las direcciones de entrega para un cartero
    // don idCartero
    public ArrayList<String> generarDirecciones(int idCartero) {

        String calle = "calle";
        String carrera = "carrera";
        String direccion = null;
        ArrayList<String> direcciones = new ArrayList<String>();

        for (Cartero cartero : carteros) {
            if (cartero.getIdCartero() == idCartero) {
                for (Carta carta : cartero.getListadoDeCartasDeCartero()) {
                    direccion = calle + " " + carta.getCalleEntrega() + "," + carrera + " " + carta.getCarreraEntrega();
                    direcciones.add(direccion);
                }
            }
        }
        return direcciones;
    }

}
