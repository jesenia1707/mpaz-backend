package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "objetivos")
public class ObjetivoAprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String asignatura;

    @Column(nullable = false)
    private String unidad;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private String estado = "PENDIENTE";

    @Column(columnDefinition = "TEXT")
    private String observacion = "";

    @Column(nullable = false)
    private Boolean asignado = false;

    @Column(nullable = false)
    private Integer maxIntentos = 2;

    @Column(nullable = false)
    private Boolean informeValidado = false;

    @Column(nullable = false)
    private Long fechaValidacion = 0L;

    // Constructor vacío requerido por JPA
    public ObjetivoAprendizaje() {
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(Boolean asignado) {
        this.asignado = asignado;
    }

    public Integer getMaxIntentos() {
        return maxIntentos;
    }

    public void setMaxIntentos(Integer maxIntentos) {
        this.maxIntentos = maxIntentos;
    }

    public Boolean getInformeValidado() {
        return informeValidado;
    }

    public void setInformeValidado(Boolean informeValidado) {
        this.informeValidado = informeValidado;
    }

    public Long getFechaValidacion() {
        return fechaValidacion;
    }

    public void setFechaValidacion(Long fechaValidacion) {
        this.fechaValidacion = fechaValidacion;
    }
}