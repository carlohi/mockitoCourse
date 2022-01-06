package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lenguaje"),new Examen(7l,"Ciencias"));

    public final static List<String> PREGUNTAS = Arrays.asList("Aritmetica", "Integrales", "Trigonometria", "Derivadas", "Geometria");

}
