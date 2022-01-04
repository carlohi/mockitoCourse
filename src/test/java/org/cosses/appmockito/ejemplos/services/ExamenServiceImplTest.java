package org.cosses.appmockito.ejemplos.services;

import org.cosses.appmockito.ejemplos.models.Examen;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepository;
import org.cosses.appmockito.ejemplos.repositories.ExamenRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImplTest {

    @Test
    void findExamenbyNombre() {
        ExamenRepository repository = Mockito.mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(new Examen(5L, "Matematicas"), new Examen(6L,"Lenguaje"),new Examen(7l,"Ciencias")));
        Examen examen = service.findExamenbyNombre("Matematicas");
        assertNotNull(examen);
        assertEquals(5L, examen.getId());
        assertEquals("Matematicas",examen.getNombre());
    }

    @Test
    void findExamenbyNombreEmptyList() {
        ExamenRepository repository = Mockito.mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImpl(repository);
        Mockito.when(repository.findAll()).thenReturn(Collections.emptyList());
        assertTrue(repository.findAll().isEmpty());
    }
}