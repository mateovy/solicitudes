package com.semillero.solicitudes;

import com.semillero.solicitudes.persistence.entities.SolicitudVacaciones;
import com.semillero.solicitudes.persistence.repositories.SolicitudVacacionesRepository;
import com.semillero.solicitudes.persistence.repositories.UsuarioRepository;
import com.semillero.solicitudes.services.SolicitudVacacionesService;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SolicitudVacacionesServiceTest {

    @Mock
    private SolicitudVacacionesRepository solicitudVacacionesRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private SolicitudVacacionesService solicitudVacacionesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllSolicitudes() {

        when(solicitudVacacionesRepository.findAll()).thenReturn(List.of(new SolicitudVacaciones()));

        List<SolicitudVacaciones> result = solicitudVacacionesService.findAllSolicitudes();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        verify(solicitudVacacionesRepository).findAll();
    }

    @Test
    public void testSaveSolicitud() throws Exception {
        SolicitudVacaciones solicitud = new SolicitudVacaciones(); // Configura los atributos necesarios
        when(solicitudVacacionesRepository.save(any(SolicitudVacaciones.class))).thenReturn(solicitud);

        SolicitudVacaciones savedSolicitud = solicitudVacacionesService.saveSolicitud(solicitud);

        assertNotNull(savedSolicitud);
        verify(solicitudVacacionesRepository).save(solicitud);
    }

    @Test
    public void testValidarSolicitudConFechaInicioDespuesDeFechaFin() {
        SolicitudVacaciones solicitud = new SolicitudVacaciones();
        solicitud.setFeFechaInicio(new Date());
        solicitud.setFeFechaFin(new Date(solicitud.getFeFechaInicio().getTime() - 1000));

        boolean isValid = solicitudVacacionesService.validarSolicitud(solicitud);

        assertFalse(isValid);
    }
}