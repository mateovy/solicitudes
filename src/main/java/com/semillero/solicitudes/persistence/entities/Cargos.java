package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cargos")
public class Cargos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_cargo")
    private Long nmIdCargo;

    @Column(name = "ds_cargo")
    private String dsCargo;

    @Column(name = "ds_descripcion")
    private String dsDescripcion;

    @Column(name = "fe_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date feFechaCreacion;

    @Column(name = "ds_activo")
    private String dsActivo;

    public Cargos() {
    }

    public Cargos(Long nmIdCargo, String dsCargo, String dsDescripcion, Date feFechaCreacion, String dsActivo) {
        this.nmIdCargo = nmIdCargo;
        this.dsCargo = dsCargo;
        this.dsDescripcion = dsDescripcion;
        this.feFechaCreacion = feFechaCreacion;
        this.dsActivo = dsActivo;
    }

    public Long getNmIdCargo() {
        return nmIdCargo;
    }

    public String getDsCargo() {
        return dsCargo;
    }

    public String getDsDescripcion() {
        return dsDescripcion;
    }

    public Date getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public String getDsActivo() {
        return dsActivo;
    }

    // Setters
    public void setNmIdCargo(Long nmIdCargo) {
        this.nmIdCargo = nmIdCargo;
    }

    public void setDsCargo(String dsCargo) {
        this.dsCargo = dsCargo;
    }

    public void setDsDescripcion(String dsDescripcion) {
        this.dsDescripcion = dsDescripcion;
    }

    public void setFeFechaCreacion(Date feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }

    public void setDsActivo(String dsActivo) {
        this.dsActivo = dsActivo;
    }

    public void setId(Long id) {
    }
}
