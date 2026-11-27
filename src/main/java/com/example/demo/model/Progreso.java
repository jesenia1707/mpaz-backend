package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "rut_estudiante", "objetivo_id" })
})
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rut_estudiante", nullable = false)
    private String rutEstudiante;

    @Column(name = "objetivo_id", nullable = false)
    private Integer objetivoId;

    private Boolean aprendeVisto = false;

    private Integer nivelSuperado = 0;

    public Progreso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRutEstudiante() {
        return rutEstudiante;
    }

    public void setRutEstudiante(String rutEstudiante) {
        this.rutEstudiante = rutEstudiante;
    }

    public Integer getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public Boolean getAprendeVisto() {
        return aprendeVisto;
    }

    public void setAprendeVisto(Boolean aprendeVisto) {
        this.aprendeVisto = aprendeVisto;
    }

    public Integer getNivelSuperado() {
        return nivelSuperado;
    }

    public void setNivelSuperado(Integer nivelSuperado) {
        this.nivelSuperado = nivelSuperado;
    }
}
