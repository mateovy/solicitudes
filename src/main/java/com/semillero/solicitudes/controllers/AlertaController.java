package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.Alerta;
import com.semillero.solicitudes.services.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    @Autowired
    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping
    public List<Alerta> getAllAlertas() {
        return alertaService.findAllAlertas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> getAlertaById(@PathVariable Long id) {
        return alertaService.findAlertaById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alerta createAlerta(@RequestBody Alerta alerta) {
        return alertaService.saveAlerta(alerta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> updateAlerta(@PathVariable Long id, @RequestBody Alerta alertaDetails) {
        try {
            Alerta updatedAlerta = alertaService.updateAlerta(id, alertaDetails);
            return ResponseEntity.ok(updatedAlerta);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlerta(@PathVariable Long id) {
        try {
            alertaService.deleteAlerta(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
