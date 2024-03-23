package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.RolUsuario;
import com.semillero.solicitudes.services.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-usuario")
public class RolUsuarioController {

    private final RolUsuarioService rolUsuarioService;

    @Autowired
    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }

    @GetMapping
    public List<RolUsuario> getAllRoles() {
        return rolUsuarioService.findAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolUsuario> getRolById(@PathVariable Long id) {
        return rolUsuarioService.findRolById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RolUsuario createRol(@RequestBody RolUsuario rolUsuario) {
        return rolUsuarioService.saveRol(rolUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Long id) {
        rolUsuarioService.deleteRol(id);
        return ResponseEntity.ok().build();
    }
}
