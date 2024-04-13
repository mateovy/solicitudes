package com.semillero.solicitudes;
import com.semillero.solicitudes.persistence.entities.RolUsuario;
import com.semillero.solicitudes.persistence.repositories.RolUsuarioRepository;
import com.semillero.solicitudes.services.RolUsuarioService;
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

class RolUsuarioServiceTest {

    @Mock
    RolUsuarioRepository rolUsuarioRepository;

    @InjectMocks
    RolUsuarioService rolUsuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllRoles() {
        List<RolUsuario> roles = new ArrayList<>();
        RolUsuario rol1 = new RolUsuario();
        rol1.setId(1L);
        RolUsuario rol2 = new RolUsuario();
        rol2.setId(2L);
        roles.add(rol1);
        roles.add(rol2);

        when(rolUsuarioRepository.findAll()).thenReturn(roles);

        List<RolUsuario> result = rolUsuarioService.findAllRoles();

        assertEquals(roles, result);
    }

    @Test
    void testFindRolById() {
        Long id = 1L;
        RolUsuario rol = new RolUsuario();
        rol.setId(id);

        when(rolUsuarioRepository.findById(id)).thenReturn(Optional.of(rol));

        Optional<RolUsuario> result = rolUsuarioService.findRolById(id);

        assertTrue(result.isPresent());
        assertEquals(rol, result.get());
    }

    @Test
    void testSaveRol() {
        RolUsuario rol = new RolUsuario();

        when(rolUsuarioRepository.save(rol)).thenReturn(rol);

        RolUsuario result = rolUsuarioService.saveRol(rol);

        assertNotNull(result);

    }

    @Test
    void testDeleteRol() {
        Long id = 1L;

        rolUsuarioService.deleteRol(id);

        verify(rolUsuarioRepository, times(1)).deleteById(id);
    }

    @Test
    void testUpdateRol() {
        Long id = 1L;
        RolUsuario rol = new RolUsuario();
        RolUsuario rolDetails = new RolUsuario();

        when(rolUsuarioRepository.findById(id)).thenReturn(Optional.of(rol));
        when(rolUsuarioRepository.save(rol)).thenReturn(rol);

        RolUsuario updatedRol = rolUsuarioService.updateRol(id, rolDetails);

        assertNotNull(updatedRol);

    }
}

