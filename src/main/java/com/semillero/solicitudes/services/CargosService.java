package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.CargosRepository;
import com.semillero.solicitudes.persistence.entities.Cargos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CargosService {

    private final CargosRepository cargosRepository;

    @Autowired
    public CargosService(CargosRepository cargosRepository) {
        this.cargosRepository = cargosRepository;
    }

    public List<Cargos> findAllCargos() {
        return cargosRepository.findAll();
    }

    public Optional<Cargos> findCargoById(Long id) {
        return cargosRepository.findById(id);
    }

    public Cargos saveCargo(Cargos cargos) {
        return cargosRepository.save(cargos);
    }

    public void deleteCargo(Long id) {
        cargosRepository.deleteById(id);
    }

    public Cargos updateCargo(Long id, Cargos cargosDetails) {
        Cargos cargos = findCargoById(id)
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado para este id :: " + id));

        cargos.setDsCargo(cargosDetails.getDsCargo());
        cargos.setDsDescripcion(cargosDetails.getDsDescripcion());
        cargos.setDsActivo(cargosDetails.getDsActivo());

        return cargosRepository.save(cargos);
    }
}
