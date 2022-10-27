package com.javeriana;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    public ArrayList<Carta> readJsonCarta() {
        ArrayList<Carta> lCartas = new ArrayList<Carta>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new FileInputStream(new File("tangamandapio\\BDcartas.json"));
            TypeReference<ArrayList<Carta>> typeReference = new TypeReference<ArrayList<Carta>>() {
            };
            lCartas = mapper.readValue(is, typeReference);
            for (Carta c : lCartas) {
                System.out
                        .println(c.getCalleEntrega() + '\t' + c.getCarreraEntrega() + '\t' + c.getEstadoDeCarta() + '\t'
                                + c.getFechaDeDeposito() + '\t' + c.getFechaDeEntrega() + '\t' + c.isEsExpress()
                                + '\t' + c.getIdCarta());
            }
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
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
        Path path = Paths.get("tangamandapio\\BDcartas.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(carta));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
            fileWriter.close();
        }
    }

    public ArrayList<Cartero> readJsonCartero() {
        ArrayList<Cartero> lCarteros = new ArrayList<Cartero>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new FileInputStream(new File("tangamandapio\\BDcarteros.json"));
            TypeReference<ArrayList<Cartero>> typeReference = new TypeReference<ArrayList<Cartero>>() {
            };
            lCarteros = mapper.readValue(is, typeReference);
            for (Cartero c : lCarteros) {
                System.out.println(
                        c.getIdCartero() + '\t' + c.getEstado() + '\t' + c.getListadoDeCartasDeCartero().toString()
                                + '\t' + c.getListadoDeCartasDeCartero().toString());
            }

            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
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

    public static synchronized void updateJsonFileCartero(Cartero carta) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("tangamandapio\\BDcarteros.json");
        final String currentJsonArrayAsString = Files.readString(path);

        try (FileWriter fileWriter = new FileWriter(path.toFile(), false)) {

            JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(carta));
            JSONArray jsonArray = new JSONArray(currentJsonArrayAsString);
            jsonArray.put(jsonObject);

            fileWriter.write(jsonArray.toString());
            fileWriter.close();
        }
    }

}
