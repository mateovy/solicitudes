package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.UsuarioRepository;
import com.semillero.solicitudes.persistence.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario) {
        if (usuario.getDsUsuario() == null || usuario.getDsUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }

        if (usuario.getDsContraseña() == null || usuario.getDsContraseña().trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        if (usuario.getFeFechaCreacion() == null) {
            usuario.setFeFechaCreacion(new Date());
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado para este id :: " + id));

        usuario.setDsUsuario(usuarioDetails.getDsUsuario());
        usuario.setEmpleado(usuarioDetails.getEmpleado());
        usuario.setFeFechaCreacion(usuarioDetails.getFeFechaCreacion());
        usuario.setDsActivo(usuarioDetails.getDsActivo());
        usuario.setDsContraseña(usuarioDetails.getDsContraseña());
        usuario.setRolUsuario(usuarioDetails.getRolUsuario());

        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return updatedUsuario;
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado para este id :: " + id));
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> findByDsActivo(String dsActivo) {
        return usuarioRepository.findByDsActivo(dsActivo);
    }
}
