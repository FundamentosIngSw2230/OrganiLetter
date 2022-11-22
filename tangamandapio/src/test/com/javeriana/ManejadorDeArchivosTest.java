package com.javeriana;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.javeriana.Carta;
import com.javeriana.ElManejadorDeArchivos;

public class ManejadorDeArchivosTest {
    public ManejadorDeArchivosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCambioDeEstadoCartero() {
        System.out.println(ElManejadorDeArchivos.readJsonCarta().size());
        ArrayList<Carta> lC = ElManejadorDeArchivos.readJsonCarta();
        System.out.println(lC);
        // ElManejadorDeArchivos.changeJsonAtributeCartero(0, "test");

        // assertEquals("recibiendo",
        // ElManejadorDeArchivos.readJsonCartero().get(0).getEstado());

    }

}
