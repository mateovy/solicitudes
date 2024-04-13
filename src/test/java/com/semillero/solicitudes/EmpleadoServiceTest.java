package com.semillero.solicitudes;
import com.semillero.solicitudes.persistence.entities.Empleado;
import com.semillero.solicitudes.persistence.repositories.EmpleadoRepository;
import com.semillero.solicitudes.services.EmpleadoService;
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

class EmpleadoServiceTest {

    @Mock
    EmpleadoRepository empleadoRepository;

    @InjectMocks
    EmpleadoService empleadoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        Empleado empleado1 = new Empleado();
        empleado1.setId(1L);
        Empleado empleado2 = new Empleado();
        empleado2.setId(2L);
        empleados.add(empleado1);
        empleados.add(empleado2);

        when(empleadoRepository.findAll()).thenReturn(empleados);

        List<Empleado> result = empleadoService.findAllEmpleados();

        assertEquals(empleados, result);
    }

    @Test
    void testFindEmpleadoById() {
        Long id = 1L;
        Empleado empleado = new Empleado();
        empleado.setId(id);

        when(empleadoRepository.findById(id)).thenReturn(Optional.of(empleado));

        Optional<Empleado> result = empleadoService.findEmpleadoById(id);

        assertTrue(result.isPresent());
        assertEquals(empleado, result.get());
    }

    @Test
    void testSaveEmpleado() {
        Empleado empleado = new Empleado();

        when(empleadoRepository.save(empleado)).thenReturn(empleado);

        Empleado result = empleadoService.saveEmpleado(empleado);

        assertNotNull(result);
    }

    @Test
    void testDeleteEmpleado() {
        Long id = 1L;
        boolean exists = true;

        when(empleadoRepository.existsById(id)).thenReturn(exists);

        empleadoService.deleteEmpleado(id);

        verify(empleadoRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateEmpleado() {
        Long id = 1L;
        Empleado empleado = new Empleado();
        Empleado empleadoDetails = new Empleado();

        when(empleadoRepository.findById(id)).thenReturn(Optional.of(empleado));
        when(empleadoRepository.save(empleado)).thenReturn(empleado);

        Empleado updatedEmpleado = empleadoService.updateEmpleado(id, empleadoDetails);

        assertNotNull(updatedEmpleado);

    }

    @Test
    void testFindEmpleadosBySupervisor() {
        Long supervisorId = 1L;
        List<Empleado> empleados = new ArrayList<>();

        when(empleadoRepository.findByNmSupervisorInmediato(supervisorId)).thenReturn(empleados);

        List<Empleado> result = empleadoService.findEmpleadosBySupervisor(supervisorId);

        assertEquals(empleados, result);
    }
}

