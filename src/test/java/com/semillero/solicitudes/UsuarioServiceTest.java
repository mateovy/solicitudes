package com.semillero.solicitudes;

import com.semillero.solicitudes.persistence.entities.Usuario;
import com.semillero.solicitudes.persistence.repositories.UsuarioRepository;
import com.semillero.solicitudes.services.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;

class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "usuario1", "contraseña1", new Date(), "activo", "rol1", null));
        usuarios.add(new Usuario(2L, "usuario2", "contraseña2", new Date(), "activo", "rol2", null));
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> result = usuarioService.findAllUsuarios();

        assertEquals(2, result.size());
    }
    @Test
    void testDeleteUsuario() {
        Usuario usuario = new Usuario(1L, "usuario1", "contraseña1", new Date(), "activo", "rol1", null);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        usuarioService.deleteUsuario(1L);

        verify(usuarioRepository, times(1)).delete(usuario);
    }
    @Test
    void testFindByDsActivo() {

        Usuario usuarioActivo1 = new Usuario(1L, "usuario1", "contraseña1", new Date(), "activo", "rol1", null);
        Usuario usuarioActivo2 = new Usuario(2L, "usuario2", "contraseña2", new Date(), "activo", "rol2", null);
        List<Usuario> usuariosActivos = Arrays.asList(usuarioActivo1, usuarioActivo2);
        when(usuarioRepository.findByDsActivo("activo")).thenReturn(usuariosActivos);

        List<Usuario> resultado = usuarioService.findByDsActivo("activo");

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals(usuarioActivo1, resultado.get(0));
        assertEquals(usuarioActivo2, resultado.get(1));
    }

}
