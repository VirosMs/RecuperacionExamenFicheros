package org.examen.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class Actor {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("sex")
    private String sexo;
    @JsonProperty("yearOfBirth")
    private int anyoNacimiento;

    @JsonProperty("movies")
    private List<Pelicula> peliculas;


    public Actor(String nombre, String sexo, int anyoNacimiento, List<Pelicula> peliculas) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.anyoNacimiento = anyoNacimiento;
        this.peliculas = peliculas;
    }
}


