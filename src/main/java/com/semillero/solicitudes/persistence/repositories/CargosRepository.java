package com.semillero.solicitudes.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.solicitudes.persistence.entities.Cargos;

@Repository
public interface CargosRepository extends JpaRepository<Cargos, Long> {
}

