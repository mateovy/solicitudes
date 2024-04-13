package com.semillero.solicitudes.persistence.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alerta")
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nm_id_alerta")
    private Long nmIdAlerta;

    @Column(name = "ds_asunto")
    private String dsAsunto;

    @Column(name = "ds_destinatario")
    private String dsDestinatario;

    @Column(name = "ds_contenido_alerta")
    private String dsContenidoAlerta;

    @Column(name = "ds_estado_alerta")
    private String dsEstadoAlerta;

    @Column(name = "fe_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date feFechaCreacion;

    public Alerta() {}

    public Long getNmIdAlerta() {
        return nmIdAlerta;
    }

    public void setNmIdAlerta(Long nmIdAlerta) {
        this.nmIdAlerta = nmIdAlerta;
    }

    public String getDsAsunto() {
        return dsAsunto;
    }

    public void setDsAsunto(String dsAsunto) {
        this.dsAsunto = dsAsunto;
    }

    public String getDsDestinatario() {
        return dsDestinatario;
    }

    public void setDsDestinatario(String dsDestinatario) {
        this.dsDestinatario = dsDestinatario;
    }

    public String getDsContenidoAlerta() {
        return dsContenidoAlerta;
    }

    public void setDsContenidoAlerta(String dsContenidoAlerta) {
        this.dsContenidoAlerta = dsContenidoAlerta;
    }

    public String getDsEstadoAlerta() {
        return dsEstadoAlerta;
    }

    public void setDsEstadoAlerta(String dsEstadoAlerta) {
        this.dsEstadoAlerta = dsEstadoAlerta;
    }

    public Date getFeFechaCreacion() {
        return feFechaCreacion;
    }

    public void setFeFechaCreacion(Date feFechaCreacion) {
        this.feFechaCreacion = feFechaCreacion;
    }

    public void setId(long l) {
    }
}
