package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;
import org.cosses.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Examen examen = service.findExamenbyNombre("Matematicas");
        assertNotNull(examen);
        assertEquals(5L, examen.getId());
        assertEquals("Matematicas",examen.getNombre());
    }

    @Test
    void findExamenbyNombreEmptyList() {
        when(examenRepository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(examenRepository.findAll().isEmpty());
    }

    @Test
    void testPreguntasExamen(){
        when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.findPreguntasByExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        var examen = service.findExamenByNombreConPreguntas("Lenguaje");
        assertEquals(5,examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("Integrales"));
        verify(examenRepository).findAll();
        verify(preguntaRepository).findPreguntasByExamenId(6L);
    }


}