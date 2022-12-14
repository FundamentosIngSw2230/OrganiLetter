package com.javeriana;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ElManejadorDeArchivos {

    public static ElManejadorDeArchivos ElManejadorDeArchivos_Instance = null;

    public static ArrayList<Carta> readJsonCarta() {

        ArrayList<Carta> lCartas = new ArrayList<Carta>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            // InputStream is = new FileInputStream(new
            // File("tangamandapio\\BDcartas.json"));
            InputStream is = new FileInputStream(new File("BDcartas.json"));
            TypeReference<ArrayList<Carta>> typeReference = new TypeReference<ArrayList<Carta>>() {
            };
            lCartas = mapper.readValue(is, typeReference);
            /*
             * for (Carta c : lCartas) {
             * System.out
             * .println(c.getCalleEntrega() + '\t' + c.getCarreraEntrega() + '\t' +
             * c.getEstadoDeCarta() + '\t'
             * + c.getFechaDeDeposito() + '\t' + c.getFechaDeEntrega() + '\t' +
             * c.getEsExpress()
             * + '\t' + c.getIdCarta());
             * }
             */
            is.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lCartas;

    }

    public static synchronized void updateJsonFileCarta(Carta carta) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Path path = Paths.get("tangamandapio\\BDcartas.json");
        Path path = Paths.get("BDcartas.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(carta));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
            fileWriter.close();
        }
    }

    public static ArrayList<Cartero> readJsonCartero() {
        ArrayList<Cartero> lCarteros = new ArrayList<Cartero>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new FileInputStream(new File("BDcarteros.json"));
            TypeReference<ArrayList<Cartero>> typeReference = new TypeReference<ArrayList<Cartero>>() {
            };
            lCarteros = mapper.readValue(is, typeReference);
            /*
             * for (Cartero c : lCarteros) {
             * System.out.println(
             * c.getIdCartero() + '\t' + c.getEstado() + '\t' +
             * c.getListadoDeCartasDeCartero().toString()
             * + '\t' + c.getListadoDeCartasDeCartero().toString());
             * }
             */

            is.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lCarteros;

    }

    public static synchronized void updateJsonFileCartero(Cartero cartero) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("BDcarteros.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(cartero));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
            fileWriter.close();
        }
    }

    public static void changeJsonAtributeCartero(int idCartero, String estadoACambiar) {

        ArrayList<Cartero> lCarteros = ElManejadorDeArchivos.readJsonCartero();
        boolean seEncontro = false;
        while (seEncontro == false) {
            int i = 0;
            if (lCarteros.get(i).getIdCartero() == idCartero) {
                seEncontro = true;
                lCarteros.get(i).setEstado(estadoACambiar);

            } else {
                if (i == lCarteros.size()) {
                    seEncontro = true;
                }
                i++;
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("BDcarteros.json"), lCarteros);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static void changeJsonAtributeCarta(int idCarta, String estadoACambiar) {

        ArrayList<Carta> lCartas = ElManejadorDeArchivos.readJsonCarta();
        boolean seEncontro = false;
        while (seEncontro == false) {
            int i = 0;

            if (lCartas.get(i).getIdCarta() == idCarta) {
                seEncontro = true;
                lCartas.get(i).setEstadoDeCarta(estadoACambiar);

            } else {
                if (i == lCartas.size()) {
                    seEncontro = true;
                }
                i++;
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("BDcartas.json"), lCartas);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static ElManejadorDeArchivos getInstance() {
        if (ElManejadorDeArchivos_Instance == null) {
            ElManejadorDeArchivos_Instance = new ElManejadorDeArchivos();

        }
        return ElManejadorDeArchivos_Instance;

    }

}
