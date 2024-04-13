package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_usuario")
    private Long nmIdUsuario;

    @ManyToOne
    @JoinColumn(name = "nm_id_empleado", referencedColumnName = "nm_id_empleado")
    private Empleado empleado;

    @Column(name = "ds_usaurio")
    private String dsUsuario;

    @Column(name = "fe_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date feFechaCreacion;

    @Column(name = "ds_activo")
    private String dsActivo;

    @Column(name = "ds_contraseña")
    private String dsContraseña;

    @ManyToOne
    @JoinColumn(name = "nm_rol", referencedColumnName = "nm_id_rol")
    private RolUsuario rolUsuario;

    public Usuario(long l, String usuario1, String contraseña1, Date date, String activo, String rol1, Object o) {}

    public Long getNmIdUsuario() {
        return nmIdUsuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getDsUsuario() {
        return dsUsuario;
    }

    public Date getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public String getDsActivo() {
        return dsActivo;
    }

    public String getDsContraseña() {
        return dsContraseña;
    }

    public RolUsuario getRolUsuario() {
        return rolUsuario;
    }

    public void setNmIdUsuario(Long nmIdUsuario) {
        this.nmIdUsuario = nmIdUsuario;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setDsUsuario(String dsUsuario) {
        this.dsUsuario = dsUsuario;
    }

    public void setFeFechaCreacion(Date feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }

    public void setDsActivo(String dsActivo) {
        this.dsActivo = dsActivo;
    }

    public void setDsContraseña(String dsContraseña) {
        this.dsContraseña = dsContraseña;
    }

    public void setRolUsuario(RolUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }
}
