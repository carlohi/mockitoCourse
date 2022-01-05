package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;

public interface ExamenService {

    Examen findExamenbyNombre(String nombre);

    Examen findExamenByNombreConPreguntas(String nombre);

}
