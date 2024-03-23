package com.semillero.solicitudes.controllers;

import com.semillero.solicitudes.persistence.entities.SolicitudVacaciones;
import com.semillero.solicitudes.services.SolicitudVacacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes-vacaciones")
public class SolicitudVacacionesController {

    private final SolicitudVacacionesService solicitudVacacionesService;

    @Autowired
    public SolicitudVacacionesController(SolicitudVacacionesService solicitudVacacionesService) {
        this.solicitudVacacionesService = solicitudVacacionesService;
    }

    @GetMapping
    public List<SolicitudVacaciones> getAllSolicitudes() {
        return solicitudVacacionesService.findAllSolicitudes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudVacaciones> getSolicitudById(@PathVariable Long id) {
        return solicitudVacacionesService.findSolicitudById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SolicitudVacaciones createSolicitud(@RequestBody SolicitudVacaciones solicitud) throws Exception {
        return solicitudVacacionesService.saveSolicitud(solicitud);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable Long id) {
        solicitudVacacionesService.deleteSolicitud(id);
        return ResponseEntity.ok().build();
    }
}
