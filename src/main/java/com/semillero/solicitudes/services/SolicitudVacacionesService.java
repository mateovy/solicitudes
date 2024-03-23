package com.semillero.solicitudes.services;

import com.semillero.solicitudes.persistence.repositories.SolicitudVacacionesRepository;
import com.semillero.solicitudes.persistence.repositories.UsuarioRepository;
import com.semillero.solicitudes.persistence.entities.Empleado;
import com.semillero.solicitudes.persistence.entities.SolicitudVacaciones;
import com.semillero.solicitudes.persistence.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudVacacionesService {

    private final SolicitudVacacionesRepository solicitudVacacionesRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public SolicitudVacacionesService(SolicitudVacacionesRepository solicitudVacacionesRepository, UsuarioRepository usuarioRepository) {
        this.solicitudVacacionesRepository = solicitudVacacionesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<SolicitudVacaciones> findAllSolicitudes() {
        return solicitudVacacionesRepository.findAll();
    }

    public Optional<SolicitudVacaciones> findSolicitudById(Long id) {
        return solicitudVacacionesRepository.findById(id);
    }

    public SolicitudVacaciones saveSolicitud(SolicitudVacaciones solicitudVacaciones) throws Exception {
       // if (!validarSolicitud(solicitudVacaciones)) {
            //throw new Exception("La solicitud de vacaciones no cumple con los requisitos.");
       // }
        return solicitudVacacionesRepository.save(solicitudVacaciones);
    }

    public void deleteSolicitud(Long id) {
        solicitudVacacionesRepository.deleteById(id);
    }

    public SolicitudVacaciones updateSolicitud(Long id, SolicitudVacaciones solicitudDetails) {
        SolicitudVacaciones solicitud = solicitudVacacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud de Vacaciones no encontrada para este id :: " + id));

        solicitud.setNmDiasSolicita(solicitudDetails.getNmDiasSolicita());
        solicitud.setFeFechaInicio(solicitudDetails.getFeFechaInicio());
        solicitud.setFeFechaFin(solicitudDetails.getFeFechaFin());
        solicitud.setFeFechaRetorna(solicitudDetails.getFeFechaRetorna());
        solicitud.setDsEstado(solicitudDetails.getDsEstado());
        solicitud.setDsObservaciones(solicitudDetails.getDsObservaciones());

        final SolicitudVacaciones updatedSolicitud = solicitudVacacionesRepository.save(solicitud);
        return updatedSolicitud;
    }

    public boolean validarSolicitud(SolicitudVacaciones solicitud) {
        if (solicitud.getFeFechaInicio().after(solicitud.getFeFechaFin())
                || solicitud.getFeFechaInicio().before(new Date())) {
            return false;
        }

        List<SolicitudVacaciones> solicitudesExistentes = solicitudVacacionesRepository.findByUsuario(solicitud.getUsuario());
        for (SolicitudVacaciones existente : solicitudesExistentes) {
            if (!existente.getDsEstado().equals("RECHAZADA") &&
                    (solicitud.getFeFechaInicio().before(existente.getFeFechaFin()) &&
                            solicitud.getFeFechaFin().after(existente.getFeFechaInicio()))) {
                return false;
            }
        }

        int diasYaUsados = calcularDiasVacacionesUsados(solicitud.getUsuario());
        if ((diasYaUsados + solicitud.getNmDiasSolicita()) > 30) {
            return false;
        }

        Empleado empleado = solicitud.getUsuario().getEmpleado();
        if (!empleado.getDsEstadoEmpleado().equalsIgnoreCase("ACTIVO")) {
            return false;
        }

        Date fechaIngreso = empleado.getFeFechaIngreso();
        Calendar fechaMinima = Calendar.getInstance();
        fechaMinima.add(Calendar.MONTH, -6);
        if (fechaIngreso.after(fechaMinima.getTime())) {
            return false;
        }

        if (!fechasSonLaborables(solicitud.getFeFechaInicio(), solicitud.getFeFechaFin())) {
            return false;
        }

        return true;
    }

    private boolean fechasSonLaborables(Date inicio, Date fin) {
        Calendar start = Calendar.getInstance();
        start.setTime(inicio);
        Calendar end = Calendar.getInstance();
        end.setTime(fin);
        while (!start.after(end)) {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
                return false;
            }

            start.add(Calendar.DATE, 1);
        }
        return true;
    }

    private int calcularDiasVacacionesUsados(Usuario usuario) {
        Calendar inicioAño = Calendar.getInstance();
        inicioAño.set(Calendar.DAY_OF_YEAR, 1);
        inicioAño.set(Calendar.HOUR_OF_DAY, 0);
        inicioAño.set(Calendar.MINUTE, 0);
        inicioAño.set(Calendar.SECOND, 0);
        inicioAño.set(Calendar.MILLISECOND, 0);

        Calendar finAño = Calendar.getInstance();
        finAño.set(Calendar.MONTH, Calendar.DECEMBER);
        finAño.set(Calendar.DAY_OF_MONTH, 31);
        finAño.set(Calendar.HOUR_OF_DAY, 23);
        finAño.set(Calendar.MINUTE, 59);
        finAño.set(Calendar.SECOND, 59);
        finAño.set(Calendar.MILLISECOND, 999);

        List<SolicitudVacaciones> solicitudes = solicitudVacacionesRepository.findByUsuarioAndDsEstadoAndFeFechaCreacionBetween(
                usuario, "APROBADA", inicioAño.getTime(), finAño.getTime());

        int diasUsados = 0;
        for (SolicitudVacaciones solicitud : solicitudes) {
            diasUsados += solicitud.getNmDiasSolicita();
        }

        return diasUsados;
    }
    public List<SolicitudVacaciones> findSolicitudesByUsuarioIdAndOrderByFechaCreacionDesc(Usuario usuario) {
        return solicitudVacacionesRepository.findByUsuarioOrderByFeFechaCreacionDesc(usuario);
    }
}
