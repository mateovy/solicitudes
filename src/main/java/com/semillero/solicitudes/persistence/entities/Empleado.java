package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_empleado")
    private Long nmIdEmpleado;

    @Column(name = "nm_documento")
    private Integer nmDocumento;

    @Column(name = "ds_tipo_documento")
    private String dsTipoDocumento;

    @Column(name = "ds_nombre")
    private String dsNombre;

    @Column(name = "ds_apellido")
    private String dsApellido;

    @Column(name = "ds_telefono")
    private String dsTelefono;

    @Column(name = "ds_direccion")
    private String dsDireccion;

    @Column(name = "fe_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date feFechaIngreso;

    @Column(name = "fe_fecha_retiro")
    @Temporal(TemporalType.DATE)
    private Date feFechaRetiro;

    @Column(name = "ds_tipo_contrato")
    private String dsTipoContrato;

    @Column(name = "ds_estado_empleado")
    private String dsEstadoEmpleado;

    @Column(name = "nm_supervisor_inmediato")
    private Integer nmSupervisorInmediato;

    @Column(name = "nm_cargo")
    private Integer nmCargo;

    public Empleado() {}

    // Getters
    public Long getNmIdEmpleado() {
        return nmIdEmpleado;
    }

    public Integer getNmDocumento() {
        return nmDocumento;
    }

    public String getDsTipoDocumento() {
        return dsTipoDocumento;
    }

    public String getDsNombre() {
        return dsNombre;
    }

    public String getDsApellido() {
        return dsApellido;
    }

    public String getDsTelefono() {
        return dsTelefono;
    }

    public String getDsDireccion() {
        return dsDireccion;
    }

    public Date getFeFechaIngreso() {
        return feFechaIngreso;
    }

    public Date getFeFechaRetiro() {
        return feFechaRetiro;
    }

    public String getDsTipoContrato() {
        return dsTipoContrato;
    }

    public String getDsEstadoEmpleado() {
        return dsEstadoEmpleado;
    }

    public Integer getNmSupervisorInmediato() {
        return nmSupervisorInmediato;
    }

    public Integer getNmCargo() {
        return nmCargo;
    }

    // Setters
    public void setNmIdEmpleado(Long nmIdEmpleado) {
        this.nmIdEmpleado = nmIdEmpleado;
    }

    public void setNmDocumento(Integer nmDocumento) {
        this.nmDocumento = nmDocumento;
    }

    public void setDsTipoDocumento(String dsTipoDocumento) {
        this.dsTipoDocumento = dsTipoDocumento;
    }

    public void setDsNombre(String dsNombre) {
        this.dsNombre = dsNombre;
    }

    public void setDsApellido(String dsApellido) {
        this.dsApellido = dsApellido;
    }

    public void setDsTelefono(String dsTelefono) {
        this.dsTelefono = dsTelefono;
    }

    public void setDsDireccion(String dsDireccion) {
        this.dsDireccion = dsDireccion;
    }

    public void setFeFechaIngreso(Date feFechaIngreso) {
        this.feFechaIngreso = feFechaIngreso;
    }

    public void setFeFechaRetiro(Date feFechaRetiro) {
        this.feFechaRetiro = feFechaRetiro;
    }

    public void setDsTipoContrato(String dsTipoContrato) {
        this.dsTipoContrato = dsTipoContrato;
    }

    public void setDsEstadoEmpleado(String dsEstadoEmpleado) {
        this.dsEstadoEmpleado = dsEstadoEmpleado;
    }

    public void setNmSupervisorInmediato(Integer nmSupervisorInmediato) {
        this.nmSupervisorInmediato = nmSupervisorInmediato;
    }

    public void setNmCargo(Integer nmCargo) {
        this.nmCargo = nmCargo;
    }

    public void setId(long l) {
    }
}


