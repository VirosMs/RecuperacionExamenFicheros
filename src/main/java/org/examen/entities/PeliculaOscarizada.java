package org.examen.entities;


import lombok.Data;


import java.util.List;


@Data
public class PeliculaOscarizada {
    private String pelicula;
    private int anyo;
    private String actor;
    private int edad;
    private String sexo;

    public PeliculaOscarizada(String year, String age, String nombre, String pelicula, String sexo) {
        this.pelicula = pelicula;
        this.anyo = Integer.parseInt(year);
        this.actor = nombre;
        this.edad = Integer.parseInt(age);
        this.sexo = sexo;
    }
}