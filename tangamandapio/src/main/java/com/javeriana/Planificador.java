package com.javeriana;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    ArrayList<Carta> cartasRecogerNormal = new ArrayList<Carta>();
    ArrayList<Carta> cartasEntregarExpres = new ArrayList<Carta>();
    ArrayList<Carta> cartasRecogerExpres = new ArrayList<Carta>();
    ArrayList<Cartero> carteros = new ArrayList<Cartero>();
    ArrayList<Carta> cartasEntregarNormal = new ArrayList<Carta>();

    // Constructores
    public Planificador(ArrayList<Carta> cartasEntregarNormal, ArrayList<Carta> cartasEntregarExpres) {
        this.cartasEntregarNormal = cartasEntregarNormal;
        this.cartasEntregarExpres = cartasEntregarExpres;
    }

    // Getters & Setters

    public ArrayList<Carta> getCartasEntregarNormal() {
        return cartasEntregarNormal;
    }

    public void setCartasEntregarNormal(ArrayList<Carta> cartasEntregarNormal) {
        this.cartasEntregarNormal = cartasEntregarNormal;
    }

    public ArrayList<Carta> getCartasRecogerNormal() {
        return cartasRecogerNormal;
    }

    public void setCartasRecogerNormal(ArrayList<Carta> cartasRecogerNormal) {
        this.cartasRecogerNormal = cartasRecogerNormal;
    }

    public ArrayList<Carta> getCartasEntregarExpres() {
        return cartasEntregarExpres;
    }

    public void setCartasEntregarExpres(ArrayList<Carta> cartasEntregarExpres) {
        this.cartasEntregarExpres = cartasEntregarExpres;
    }

    public ArrayList<Carta> getCartasRecogerExpres() {
        return cartasRecogerExpres;
    }

    public void setCartasRecogerExpres(ArrayList<Carta> cartasRecogerExpres) {
        this.cartasRecogerExpres = cartasRecogerExpres;
    }

    public ArrayList<Cartero> getCarteros() {
        return carteros;
    }

    public void setCarteros(ArrayList<Cartero> carteros) {
        this.carteros = carteros;
    }

    public Planificador() {
    }

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

    public void setcartasEntregarNormal(ArrayList<Carta> cartasEntregarNormal) {
        this.cartasEntregarNormal = cartasEntregarNormal;
    }

    public ArrayList<Carta> getcartasEntregarExpres() {
        return cartasEntregarExpres;
    }

    public void setcartasEntregarExpres(ArrayList<Carta> cartasEntregarExpres) {
        this.cartasEntregarExpres = cartasEntregarExpres;
    }

    @Override
    public String toString() {
        return "Planificador [calleOficina=" + calleOficina + ", carreraOficina=" + carreraOficina
                + ", alcanceMaxCalle=" + alcanceMaxCalle + ", alcanceMaxCarrera=" + alcanceMaxCarrera
                + ", contadorRutas=" + contadorRutas + ", maxCartasAentregar=" + maxCartasAentregar + ", estados="
                + Arrays.toString(estados) + ", cartasEntregarNormal=" + cartasEntregarNormal + ", cartasRecogerNormal="
                + cartasRecogerNormal + ", cartasEntregarExpres=" + cartasEntregarExpres + ", cartasRecogerExpres="
                + cartasRecogerExpres + ", carteros=" + carteros + "]";
    }

    // Metodos de Planificador
    // Metodo Ordenar Carta
    public void ordenarCarta(Carta cartaAOrdenar) {
        System.out.println("Ordenar Carta");
        return;
    }

    // Metodo Generar y Asignar Ruta A Cartero.
    public void generarYAsignarRutaACartero(int idCartero) {

        for (Cartero cartero : carteros) {
            if (cartero.getIdCartero() == idCartero) {
                cartero.setEstado("en reparto");
                if (contadorRutas == 1 || contadorRutas == 2) {
                    if (cartasEntregarExpres.size() > cartasRecogerExpres.size()) {
                        contadorRutas++;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('c'));
                    } else {
                        contadorRutas++;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('d'));
                    }
                } else {
                    if (cartasEntregarNormal.size() > cartasRecogerNormal.size()) {
                        contadorRutas = 1;
                        cartero.getListadoDeCartasDeCartero().addAll(calcularRuta('a'));
                    } else {
                        contadorRutas = 1;
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

    // funciones deprueba
    public void imprimirC1() {
        for (Carta carta : cartasEntregarNormal) {
            System.out.println(carta.toString());
        }
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
