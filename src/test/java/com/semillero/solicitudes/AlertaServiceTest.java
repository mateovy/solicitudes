package com.semillero.solicitudes;
import com.semillero.solicitudes.persistence.entities.Alerta;
import com.semillero.solicitudes.persistence.repositories.AlertaRepository;
import com.semillero.solicitudes.services.AlertaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AlertaServiceTest {

    @Mock
    AlertaRepository alertaRepository;

    @InjectMocks
    AlertaService alertaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllAlertas() {
        List<Alerta> alertas = new ArrayList<>();
        Alerta alerta1 = new Alerta();
        alerta1.setId(1L);

        Alerta alerta2 = new Alerta();
        alerta2.setId(2L);

        alertas.add(alerta1);
        alertas.add(alerta2);

        when(alertaRepository.findAll()).thenReturn(alertas);

        List<Alerta> result = alertaService.findAllAlertas();

        assertEquals(alertas, result);
    }

    @Test
    void testFindAlertaById() {
        Long id = 1L;
        Alerta alerta = new Alerta();
        alerta.setId(id);

        when(alertaRepository.findById(id)).thenReturn(Optional.of(alerta));

        Optional<Alerta> result = alertaService.findAlertaById(id);

        assertTrue(result.isPresent());
        assertEquals(alerta, result.get());
    }

    @Test
    void testSaveAlerta() {
        Alerta alerta = new Alerta();

        when(alertaRepository.save(alerta)).thenReturn(alerta);

        Alerta result = alertaService.saveAlerta(alerta);

        assertNotNull(result);

    }

    @Test
    void testDeleteAlerta() {
        Long id = 1L;

        alertaService.deleteAlerta(id);

        verify(alertaRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateAlerta() {
        Long id = 1L;
        Alerta alerta = new Alerta();
        Alerta alertaDetails = new Alerta();

        when(alertaRepository.findById(id)).thenReturn(Optional.of(alerta));
        when(alertaRepository.save(alerta)).thenReturn(alerta);

        Alerta updatedAlerta = alertaService.updateAlerta(id, alertaDetails);

        assertNotNull(updatedAlerta);

    }
}
