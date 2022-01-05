package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;
import org.cosses.appmockito.ejemplos.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService{
    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Examen findExamenbyNombre(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll().stream().filter(e -> e.getNombre().contains(nombre)).findFirst();
        return examenOptional.isPresent() ? examenOptional.get() : null;
    }

    @Override
    public Examen findExamenByNombreConPreguntas(String nombre) {
        Examen examen = findExamenbyNombre(nombre);
        List<String> preguntas = preguntaRepository.findPreguntasByExamenId(examen.getId());
        examen.setPreguntas(preguntas);
        return examen;
    }
}
