package org.cosses.appmockito.ejemplos.repositories;

import org.cosses.appmockito.ejemplos.models.Examen;

import java.util.Collections;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository{
    @Override
    public List<Examen> findAll() {
        return Collections.emptyList();
    }


}
