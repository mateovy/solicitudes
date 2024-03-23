package com.semillero.solicitudes.persistence.repositories;

import com.semillero.solicitudes.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByDsActivo(String dsActivo);
}

