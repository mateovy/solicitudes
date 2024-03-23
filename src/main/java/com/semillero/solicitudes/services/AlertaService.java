package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.AlertaRepository;
import com.semillero.solicitudes.persistence.entities.Alerta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    private final AlertaRepository alertaRepository;

    @Autowired
    public AlertaService(AlertaRepository alertaRepository) {
        this.alertaRepository = alertaRepository;
    }

    public List<Alerta> findAllAlertas() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> findAlertaById(Long id) {
        return alertaRepository.findById(id);
    }

    public Alerta saveAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deleteAlerta(Long id) {
        alertaRepository.deleteById(id);
    }

    public Alerta updateAlerta(Long id, Alerta alertaDetails) {
        Alerta alerta = findAlertaById(id)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada para este id :: " + id));

        alerta.setDsAsunto(alertaDetails.getDsAsunto());
        alerta.setDsDestinatario(alertaDetails.getDsDestinatario());
        alerta.setDsContenidoAlerta(alertaDetails.getDsContenidoAlerta());
        alerta.setDsEstadoAlerta(alertaDetails.getDsEstadoAlerta());

        return alertaRepository.save(alerta);
    }
}
