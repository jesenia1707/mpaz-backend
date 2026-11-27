package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autorizaciones")
public class Autorizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "material_id", nullable = false)
    private Long materialId;

    @Column(name = "utp_rut", nullable = false)
    private String utpRut;

    @Column(nullable = false)
    private String decision;

    @Column(length = 1000)
    private String observacion;

    private Long fecha;

    public Autorizacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getUtpRut() {
        return utpRut;
    }

    public void setUtpRut(String utpRut) {
        this.utpRut = utpRut;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
}
