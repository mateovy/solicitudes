package com.semillero.solicitudes.persistence.repositories;

import com.semillero.solicitudes.persistence.entities.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {
}


