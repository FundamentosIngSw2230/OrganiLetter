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
    public static List<Carta> readJsonCarta() {
        List<Carta> lCartas = new ArrayList<Carta>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new FileInputStream(new File("tangamandapio\\BDcartas.json"));
            TypeReference<List<Carta>> typeReference = new TypeReference<List<Carta>>() {
            };
            lCartas = mapper.readValue(is, typeReference);
            for (Carta c : lCartas) {
                System.out.println(c.getCalleEntrega() + '\t' + c.getCarreraEntrega() + '\t' + c.getCalleRecogida()
                        + '\t' + c.getCarreraRecogida() + '\t' + c.getEstadoDeCarta() + '\t'
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

    public static List<Cartero> readJsonCartero() {
        List<Cartero> lCarteros = new ArrayList<Cartero>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = new FileInputStream(new File("tangamandapio\\BDcarteros.json"));
            TypeReference<List<Cartero>> typeReference = new TypeReference<List<Cartero>>() {
            };
            lCarteros = mapper.readValue(is, typeReference);

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
