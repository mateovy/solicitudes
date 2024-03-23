package com.semillero.solicitudes.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.semillero.solicitudes.persistence.entities.Empleado;
import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByNmSupervisorInmediato(Long nmSupervisorInmediato);
}

