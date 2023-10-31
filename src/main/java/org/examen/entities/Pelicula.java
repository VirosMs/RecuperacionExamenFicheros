package org.examen.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Pelicula {
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("year")
    private int anyo;

    public Pelicula(String titulo, int anyo) {
        this.titulo = titulo;
        this.anyo = anyo;
    }
}
