package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "materiales")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(length = 1000)
    private String descripcion;

    private String nombreArchivo;

    private String rutaArchivo;

    private String tipoArchivo;

    @Column(name = "objetivo_id")
    private Integer objetivoId;

    @Column(name = "docente_rut", nullable = false)
    private String docenteRut;

    private String estado = "PENDIENTE";

    @Column(length = 1000)
    private String observacion;

    private Long fechaSubida;

    public Material() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public Integer getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public String getDocenteRut() {
        return docenteRut;
    }

    public void setDocenteRut(String docenteRut) {
        this.docenteRut = docenteRut;
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

    public Long getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Long fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
}
