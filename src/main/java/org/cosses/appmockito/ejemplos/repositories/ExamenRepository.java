package org.cosses.appmockito.ejemplos.repositories;

import org.cosses.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepository {
    List<Examen> findAll();

}
