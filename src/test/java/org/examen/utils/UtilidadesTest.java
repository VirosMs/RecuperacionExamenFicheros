package org.examen.utils;

import org.examen.entities.Actor;
import org.examen.entities.Pelicula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilidadesTest {

    private List<Actor> actores;

    @BeforeEach
    public void setUp() {
        actores = Arrays.asList(
                new Actor("Jack Nicholson", "M", 1937, List.of(new Pelicula("One Flew Over the Cuckoo's Nest", 1975))),
                new Actor("Daniel Day-Lewis", "M", 1957, List.of(new Pelicula("My Left Foot", 1989), new Pelicula("There Will Be Blood", 2007))));
    }

    @Test
    public void testActoresConMasDeUnOscar() {
        List<String> actoresEsperados = Arrays.asList("Daniel Day-Lewis");

        List<String> actoresConMasDeUnOscar = Utilidades.actoresConMasdeUnOscar(actores);


        assertNotNull(actoresConMasDeUnOscar);

        // Add a semicolon here to complete the statement.
        assertEquals(actoresEsperados, actoresConMasDeUnOscar);
    }



}