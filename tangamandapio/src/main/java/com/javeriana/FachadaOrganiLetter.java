package com.javeriana;

import java.util.ArrayList;

public class FachadaOrganiLetter {
    
    private static Planificador planificador = new Planificador();

    //CONSTRUCTOR
    public FachadaOrganiLetter() {
        
    }

    
    //GETERS Y SETERS    
    public static Planificador getPlanificador() {
        return planificador;
    }

    public static void setPlanificador(Planificador planificador) {
        FachadaOrganiLetter.planificador = planificador;
    }
    //Metodos de FachadaOrganiLetter
    //retorna en arreglo con la direcciones. ej: {(calle 23, carrera 10), (calle 3, carrera 19), (calle 99, carrera 44)}
    public static String getRuta(int idCartero) {
        int requisitos = 0;
        String ruta = new String();
        ArrayList<Cartero> carteros = Planificador.getCarteros();

        for (Cartero cartero : Planificador.getCarteros()) {
            if (cartero.getIdCartero() == idCartero) {
                requisitos++;
                if (cartero.getEstado().equals("Disponible")){
                    requisitos++;
                    if (cartero.getListadoDeCartasDeCartero() == null || cartero.getListadoDeCartasDeCartero().size() == 0){                        
                        requisitos++;
                        planificador.generarYAsignarRutaACartero(idCartero);
                    }
                }
            }
        }
        if (requisitos==0) {
            ruta = "el id no existe";
            return ruta;
        }
        if (requisitos==1) {
            ruta = "el cartero no esta disponible";
            return ruta;
        }
        if (requisitos==2) {
            ruta = "el cartero no esta disponible";
            return ruta;
        }
        if (requisitos==3) {
            carteros = Planificador.getCarteros();
            for (Cartero cartero : carteros) {
                if (cartero.getIdCartero() == idCartero) {
                    ruta = cartero.getDireccionesStr();
                }
            }
            return ruta;
        }
        return ruta;
    }

    /*
    //retorna un arreglo de string de la misma forma que el ejemplo anterior
    public static ArrayList<String> getRutaRecogida () {
        
    }

    //recibe un objeto tipo carta
    //retorna el id de la carta depositada si fue exitoso.
    //si hubo un error, retorna menos uno.
    public static int depositarCarta(Carta carta) {
        
    }

    // recibe un id de una carta.
    //retorna un objeto Carta si lo encuentra. Si no lo encuentra, retorna null.
    public static Carta buscarCarta(int idCarta) {
        
    }

    //retorna un Objeto de tipo Cartero. Si no lo encuentra, retorna null.
    public static Cartero buscarCartero(int idCartero){

    }
    
    //generar reporte
    public static String generarReporte() {
        
    }

    //recibe un id de carta
    //retorna true si se pudo hacer la cancelacion del envio
    //retorna false si hubo un error
    public static boolean cancelarEnvio(int idCarta) {
        
    }

    //recibe un objeto de tipo Cartero
    //retorna true o false
    public static boolean inscribirCartero() {
        
    }
    
    //recibe el id del cartero
    //deja al cartero libre para un nuevo trabajo
    public static boolean terminarRuta() {
        
    }
*/

}
