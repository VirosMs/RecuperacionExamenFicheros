package org.examen;

import org.examen.entities.Actor;
import org.examen.entities.PeliculaOscarizada;
import org.examen.utils.Utilidades;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.examen.utils.Utilidades.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Path pathCsvHombre = Path.of(".", "src", "main", "resources", "oscar_age_male.csv");
        Path pathCsvMujer = Path.of(".", "src", "main", "resources", "oscar_age_female.csv");

// 1. leerPeliculasOscarizadasCsv: lee un fichero CSV y devuelve una lista de objetos PeliculaOscarizada.


        List<PeliculaOscarizada> peliculaOscarizadaList = new ArrayList<>();

        peliculaOscarizadaList.addAll(leerPeliculasOscarizadasCsv(pathCsvHombre));
        peliculaOscarizadaList.addAll(leerPeliculasOscarizadasCsv(pathCsvMujer));

        //peliculaOscarizadaList.forEach(System.out::println);

        List<Actor> actorList = convertirPeliculasOscarizadasEnActores(peliculaOscarizadaList);

        //actorList.forEach(System.out::println);

        Utilidades.escribirActoresenJson(actorList, Path.of(".", "src", "main", "resources", "actores.json"));

        List<String> actores = actoresConMasdeUnOscar(actorList);

        actores.forEach(System.out::println);


    }
}