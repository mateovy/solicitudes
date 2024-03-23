package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.RolUsuarioRepository;
import com.semillero.solicitudes.persistence.entities.RolUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolUsuarioService {

    private final RolUsuarioRepository rolUsuarioRepository;

    @Autowired
    public RolUsuarioService(RolUsuarioRepository rolUsuarioRepository) {
        this.rolUsuarioRepository = rolUsuarioRepository;
    }

    public List<RolUsuario> findAllRoles() {
        return rolUsuarioRepository.findAll();
    }

    public Optional<RolUsuario> findRolById(Long id) {
        return rolUsuarioRepository.findById(id);
    }

    public RolUsuario saveRol(RolUsuario rolUsuario) {
        return rolUsuarioRepository.save(rolUsuario);
    }

    public void deleteRol(Long id) {
        rolUsuarioRepository.deleteById(id);
    }

    public RolUsuario updateRol(Long id, RolUsuario rolUsuarioDetails) {
        RolUsuario rolUsuario = findRolById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado para este id :: " + id));

        rolUsuario.setDsRol(rolUsuarioDetails.getDsRol());

        return rolUsuarioRepository.save(rolUsuario);
    }
}
