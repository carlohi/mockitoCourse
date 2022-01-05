package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;
import org.cosses.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    ExamenRepository examenRepository;
    ExamenService service;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp(){
        examenRepository = Mockito.mock(ExamenRepository.class);
        preguntaRepository = Mockito.mock(PreguntaRepository.class);
        service = new ExamenServiceImpl(examenRepository,preguntaRepository);
    }

    @Test
    void findExamenbyNombre() {
        Mockito.when(examenRepository.findAll()).thenReturn(Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lenguaje"),new Examen(7l,"Ciencias")));
        Examen examen = service.findExamenbyNombre("Matematicas");
        assertNotNull(examen);
        assertEquals(5L, examen.getId());
        assertEquals("Matematicas",examen.getNombre());
    }

    @Test
    void findExamenbyNombreEmptyList() {
        Mockito.when(examenRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(examenRepository.findAll().isEmpty());
    }
}