package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "solicitud_vaciones")
public class SolicitudVacaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_solicitud")
    private Long nmIdSolicitud;

    @ManyToOne
    @JoinColumn(name = "nm_id_usuario", referencedColumnName = "nm_id_usuario")
    private Usuario usuario;

    @Column(name = "nm_dias_solicita")
    private Integer nmDiasSolicita;

    @Column(name = "fe_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date feFechaInicio;

    @Column(name = "fe_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date feFechaFin;

    @Column(name = "fe_fecha_retorna")
    @Temporal(TemporalType.DATE)
    private Date feFechaRetorna;

    @Column(name = "ds_estado")
    private String dsEstado;

    @Column(name = "ds_observaciones")
    private String dsObservaciones;

    @Column(name = "fe_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date feFechaCreacion;

    public SolicitudVacaciones() {
    }

    public Long getNmIdSolicitud() {
        return nmIdSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getNmDiasSolicita() {
        return nmDiasSolicita;
    }

    public Date getFeFechaInicio() {
        return feFechaInicio;
    }

    public Date getFeFechaFin() {
        return feFechaFin;
    }

    public Date getFeFechaRetorna() {
        return feFechaRetorna;
    }

    public String getDsEstado() {
        return dsEstado;
    }

    public String getDsObservaciones() {
        return dsObservaciones;
    }

    public Date getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public void setNmIdSolicitud(Long nmIdSolicitud) {
        this.nmIdSolicitud = nmIdSolicitud;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setNmDiasSolicita(Integer nmDiasSolicita) {
        this.nmDiasSolicita = nmDiasSolicita;
    }

    public void setFeFechaInicio(Date feFechaInicio) {
        this.feFechaInicio = feFechaInicio;
    }

    public void setFeFechaFin(Date feFechaFin) {
        this.feFechaFin = feFechaFin;
    }

    public void setFeFechaRetorna(Date feFechaRetorna) {
        this.feFechaRetorna = feFechaRetorna;
    }

    public void setDsEstado(String dsEstado) {
        this.dsEstado = dsEstado;
    }

    public void setDsObservaciones(String dsObservaciones) {
        this.dsObservaciones = dsObservaciones;
    }

    public void setFeFechaCreacion(Date feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }
}
