package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;
import org.cosses.appmockito.ejemplos.repositories.PreguntaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImplTest {

    @Mock
    ExamenRepository examenRepository;

    @InjectMocks
    ExamenServiceImpl service;

    @Mock
    PreguntaRepository preguntaRepository;

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

    @Test
    void testSaveExamen(){
        when(examenRepository.save(any(Examen.class))).thenReturn(Datos.EXAMEN);
        Examen examen = service.save(Datos.EXAMEN);
        assertNotNull(examen.getId());
        assertEquals("Fisica",examen.getNombre());
    }


}