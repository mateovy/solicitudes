package com.semillero.solicitudes.persistence.repositories;

import com.semillero.solicitudes.persistence.entities.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}

