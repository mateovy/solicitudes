package com.semillero.solicitudes;
import com.semillero.solicitudes.persistence.entities.Cargos;
import com.semillero.solicitudes.persistence.repositories.CargosRepository;
import com.semillero.solicitudes.services.CargosService;
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

class CargosServiceTest {

    @Mock
    CargosRepository cargosRepository;

    @InjectMocks
    CargosService cargosService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCargos() {
        List<Cargos> cargos = new ArrayList<>();
        Cargos cargo1 = new Cargos();
        cargo1.setId(1L);
        Cargos cargo2 = new Cargos();
        cargo2.setId(2L);
        cargos.add(cargo1);
        cargos.add(cargo2);

        when(cargosRepository.findAll()).thenReturn(cargos);

        List<Cargos> result = cargosService.findAllCargos();

        assertEquals(cargos, result);
    }

    @Test
    void testFindCargoById() {
        Long id = 1L;
        Cargos cargo = new Cargos();
        cargo.setId(id);

        when(cargosRepository.findById(id)).thenReturn(Optional.of(cargo));

        Optional<Cargos> result = cargosService.findCargoById(id);

        assertTrue(result.isPresent());
        assertEquals(cargo, result.get());
    }

    @Test
    void testSaveCargo() {
        Cargos cargo = new Cargos();

        when(cargosRepository.save(cargo)).thenReturn(cargo);

        Cargos result = cargosService.saveCargo(cargo);

        assertNotNull(result);

    }

    @Test
    void testDeleteCargo() {
        Long id = 1L;

        cargosService.deleteCargo(id);

        verify(cargosRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateCargo() {
        Long id = 1L;
        Cargos cargo = new Cargos();
        Cargos cargoDetails = new Cargos();

        when(cargosRepository.findById(id)).thenReturn(Optional.of(cargo));
        when(cargosRepository.save(cargo)).thenReturn(cargo);

        Cargos updatedCargo = cargosService.updateCargo(id, cargoDetails);

        assertNotNull(updatedCargo);

    }
}



