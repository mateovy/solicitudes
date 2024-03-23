package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.Cargos;
import com.semillero.solicitudes.services.CargosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargosController {

    private final CargosService cargosService;

    @Autowired
    public CargosController(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @GetMapping
    public List<Cargos> getAllCargos() {
        return cargosService.findAllCargos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargos> getCargoById(@PathVariable Long id) {
        return cargosService.findCargoById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cargos createCargo(@RequestBody Cargos cargos) {
        return cargosService.saveCargo(cargos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Long id) {
        cargosService.deleteCargo(id);
        return ResponseEntity.ok().build();
    }
}
