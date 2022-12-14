package com.javeriana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static org.hamcrest.MatcherAssert.assertThat;

import com.javeriana.Carta;
import com.javeriana.ElManejadorDeArchivos;
import org.junit.runners.Parameterized;

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
    public void testJsonAtributeCarta() {
        System.out.println("Test 3-1");
        String estadoOriginal = ElManejadorDeArchivos.readJsonCarta().get(0).getEstadoDeCarta();
        ElManejadorDeArchivos.changeJsonAtributeCarta(0, "TEST");
        assertEquals("TEST", ElManejadorDeArchivos.readJsonCarta().get(0).getEstadoDeCarta());
        ElManejadorDeArchivos.changeJsonAtributeCarta(0, estadoOriginal);
    }

    @Test
    public void testJsonAtributeCartero() {
        System.out.println("Test 4-1");
        String estadoOriginal = ElManejadorDeArchivos.readJsonCartero().get(0).getEstado();
        ElManejadorDeArchivos.changeJsonAtributeCartero(0, "TEST");
        assertEquals("TEST", ElManejadorDeArchivos.readJsonCartero().get(0).getEstado());
        ElManejadorDeArchivos.changeJsonAtributeCartero(0, estadoOriginal);

    }

    @Test
    public void testJsonReaderCarta() {
        System.out.println("Test 1-1");
        assertEquals(Carta.class, ElManejadorDeArchivos.readJsonCarta().get(0).getClass());
    }

    @Test
    public void testJsonReaderCartero() {
        System.out.println("Test 2-1");
        assertEquals(Cartero.class, ElManejadorDeArchivos.readJsonCartero().get(0).getClass());
    }
}
