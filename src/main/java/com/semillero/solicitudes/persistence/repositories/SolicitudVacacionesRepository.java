package com.semillero.solicitudes.persistence.repositories;

import com.semillero.solicitudes.persistence.entities.SolicitudVacaciones;
import com.semillero.solicitudes.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SolicitudVacacionesRepository extends JpaRepository<SolicitudVacaciones, Long> {
    List<SolicitudVacaciones> findByUsuarioOrderByFeFechaCreacionDesc(Usuario usuario);

    List<SolicitudVacaciones> findByUsuario(Usuario usuario);

    List<SolicitudVacaciones> findByUsuarioAndDsEstadoAndFeFechaCreacionBetween(Usuario usuario, String dsEstado, Date feFechaInicio, Date feFechaFin);
}
