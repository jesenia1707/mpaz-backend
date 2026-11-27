package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intentos")
public class Intento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estudiante_rut", nullable = false)
    private String estudianteRut;

    @Column(name = "objetivo_id", nullable = false)
    private Integer objetivoId;

    @Column(nullable = false)
    private Integer correctas = 0;

    @Column(nullable = false)
    private Integer total = 0;

    @Column(nullable = false)
    private Long fecha = System.currentTimeMillis();

    public Intento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstudianteRut() {
        return estudianteRut;
    }

    public void setEstudianteRut(String estudianteRut) {
        this.estudianteRut = estudianteRut;
    }

    public Integer getObjetivoId() {
        return objetivoId;
    }

    public void setObjetivoId(Integer objetivoId) {
        this.objetivoId = objetivoId;
    }

    public Integer getCorrectas() {
        return correctas;
    }

    public void setCorrectas(Integer correctas) {
        this.correctas = correctas;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
}
