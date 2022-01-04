package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenRepository examenRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Examen findExamenbyNombre(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll().stream().filter(e -> e.getNombre().contains(nombre)).findFirst();
        return examenOptional.isPresent() ? examenOptional.get() : null;
    }
}
