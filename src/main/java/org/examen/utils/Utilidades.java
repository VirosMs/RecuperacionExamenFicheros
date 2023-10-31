package org.examen.utils;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.examen.entities.Actor;
import org.examen.entities.Pelicula;
import org.examen.entities.PeliculaOscarizada;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilidades {

    private final static String DOT_COMMA_DELIMITER = ";";

    // Métodos a implementar:

    // 1. leerPeliculasOscarizadasCsv: lee un fichero CSV y devuelve una lista de objetos PeliculaOscarizada.
    //                                 Debe tener en cuenta también el parámetro sexo para filtrar por sexo.
    public static List<PeliculaOscarizada> leerPeliculasOscarizadasCsv(Path file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("No se ha encontrado el fichero");
        }


        String sexo, fileName = file.getFileName().toString();
        if (fileName.equalsIgnoreCase("oscar_age_female.csv")) {
            sexo = "M";
        } else if (fileName.equalsIgnoreCase("oscar_age_male.csv")) {
            sexo = "H";
        } else {
            throw new IllegalArgumentException("El nombre del fichero no indica el sexo");
        }

        try(Stream<String> contenido = Files.lines(file)) {
            List<PeliculaOscarizada> listFile;
            listFile = contenido.map(line -> Arrays.asList(line.split(DOT_COMMA_DELIMITER))).skip(1)
                    .map(persona -> new PeliculaOscarizada(persona.get(1), persona.get(2), persona.get(3), persona.get(4), sexo))
                    .toList();
            return listFile;
        }catch (IOException e){
            throw new IOException("Error al leer el fichero");
        }
    }


    // 2. convertirPeliculasOscarizadasEnActores: dada una lista de PeliculasOscarizadas, devuelve una lista de objetos Actor
    //                                 en la que estarán incluidos todos los actores y actrices.

    public static List<Actor> convertirPeliculasOscarizadasEnActores(List<PeliculaOscarizada> peliculasOscarizadas) {
        if (peliculasOscarizadas == null) {
            throw new IllegalArgumentException("No se ha encontrado el fichero");
        }

        List<Actor> listActores = new ArrayList<>();
        for(PeliculaOscarizada peliculaOscarizada : peliculasOscarizadas){
            listActores.add(new Actor(peliculaOscarizada.getActor(), peliculaOscarizada.getSexo(),
                    calcularEdad(peliculaOscarizada.getEdad(), peliculaOscarizada.getAnyo()), List.of(new Pelicula(peliculaOscarizada.getPelicula(), peliculaOscarizada.getAnyo()))));
        }
        return listActores;

    }

    public static int calcularEdad(int edad, int anyoOscar) {
        if (anyoOscar < 0) {
            throw new IllegalArgumentException("El año de nacimiento no puede ser negativo");
        }

        return anyoOscar - edad;
    }


    // 3. escribirActoresenJson: escribe en un fichero JSON la lista de actores/actrices en el formato solicitado.

    public static void escribirActoresenJson(List<Actor> actores, Path ruta) {
        if (actores == null) {
            throw new IllegalArgumentException("No se ha encontrado el fichero");
        }

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(ruta.toFile(), actores);
        } catch (StreamWriteException | DatabindException e) {
            throw new RuntimeException(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 4. actoresConMasdeUnOscar: devuelve una lista de Strings con los nombres de los actores/actrices que hayan ganado más de un Oscar.

    public static List<String> actoresConMasdeUnOscar(List<Actor> actores) {
        if (actores == null) {
            throw new IllegalArgumentException("No se ha encontrado el fichero");
        }



        return null;
    }

    // 5. actoresMasJovenesEnGanarUnOscar: devuelve una lista de Strings con el actor y la actriz más jóvenes en ganar un Oscar.
    public static List<String> actoresMasJovenesEnGanarUnOscar(List<Actor> actores) {
        if (actores == null) {
            throw new IllegalArgumentException("No se ha encontrado el fichero");
        }



        return null;
    }

}
