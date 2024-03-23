package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_rol")
    private Long nmIdRol;

    @Column(name = "ds_rol")
    private String dsRol;

    @Column(name = "fe_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date feFechaCreacion;

    public RolUsuario() {
    }

    public RolUsuario(Long nmIdRol, String dsRol, Date feFechaCreacion) {
        this.nmIdRol = nmIdRol;
        this.dsRol = dsRol;
        this.feFechaCreacion = feFechaCreacion;
    }

    public Long getNmIdRol() {
        return nmIdRol;
    }

    public String getDsRol() {
        return dsRol;
    }

    public Date getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public void setNmIdRol(Long nmIdRol) {
        this.nmIdRol = nmIdRol;
    }

    public void setDsRol(String dsRol) {
        this.dsRol = dsRol;
    }

    public void setFeFechaCreacion(Date feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }

}
