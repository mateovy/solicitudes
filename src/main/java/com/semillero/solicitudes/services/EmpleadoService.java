package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.EmpleadoRepository;
import com.semillero.solicitudes.persistence.entities.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> findEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id) {
        boolean exists = empleadoRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Empleado con ID " + id + " no existe.");
        }
        empleadoRepository.deleteById(id);
    }

    public Empleado updateEmpleado(Long id, Empleado empleadoDetails) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Empleado con ID " + id + " no existe."));

        if (empleadoDetails.getNmDocumento() != null && !empleadoDetails.getNmDocumento().equals(empleado.getNmDocumento())) {
            empleado.setNmDocumento(empleadoDetails.getNmDocumento());
        }
        if (empleadoDetails.getDsTipoDocumento() != null && !empleadoDetails.getDsTipoDocumento().isEmpty()) {
            empleado.setDsTipoDocumento(empleadoDetails.getDsTipoDocumento());
        }
        if (empleadoDetails.getDsNombre() != null && !empleadoDetails.getDsNombre().isEmpty()) {
            empleado.setDsNombre(empleadoDetails.getDsNombre());
        }
        if (empleadoDetails.getDsApellido() != null && !empleadoDetails.getDsApellido().isEmpty()) {
            empleado.setDsApellido(empleadoDetails.getDsApellido());
        }
        if (empleadoDetails.getDsTelefono() != null && !empleadoDetails.getDsTelefono().isEmpty()) {
            empleado.setDsTelefono(empleadoDetails.getDsTelefono());
        }
        if (empleadoDetails.getDsDireccion() != null && !empleadoDetails.getDsDireccion().isEmpty()) {
            empleado.setDsDireccion(empleadoDetails.getDsDireccion());
        }
        if (empleadoDetails.getFeFechaIngreso() != null) {
            empleado.setFeFechaIngreso(empleadoDetails.getFeFechaIngreso());
        }
        if (empleadoDetails.getFeFechaRetiro() != null) {
            empleado.setFeFechaRetiro(empleadoDetails.getFeFechaRetiro());
        }
        if (empleadoDetails.getDsTipoContrato() != null && !empleadoDetails.getDsTipoContrato().isEmpty()) {
            empleado.setDsTipoContrato(empleadoDetails.getDsTipoContrato());
        }
        if (empleadoDetails.getDsEstadoEmpleado() != null && !empleadoDetails.getDsEstadoEmpleado().isEmpty()) {
            empleado.setDsEstadoEmpleado(empleadoDetails.getDsEstadoEmpleado());
        }
        if (empleadoDetails.getNmSupervisorInmediato() != null && !empleadoDetails.getNmSupervisorInmediato().equals(empleado.getNmSupervisorInmediato())) {
            empleado.setNmSupervisorInmediato(empleadoDetails.getNmSupervisorInmediato());
        }
        if (empleadoDetails.getNmCargo() != null && !empleadoDetails.getNmCargo().equals(empleado.getNmCargo())) {
            empleado.setNmCargo(empleadoDetails.getNmCargo());
        }

        return empleadoRepository.save(empleado);
    }

    public List<Empleado> findEmpleadosBySupervisor(Long nmSupervisorInmediato) {
        return empleadoRepository.findByNmSupervisorInmediato(nmSupervisorInmediato);
    }
}
