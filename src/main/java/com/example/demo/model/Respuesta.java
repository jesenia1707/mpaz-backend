package main.java.com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "respuestas")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intento_id", nullable = false)
    private Long intentoId;

    @Column(name = "pregunta_id", nullable = false)
    private Integer preguntaId;

    private Integer elegida;

    private Boolean esCorrecta;

    public Respuesta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIntentoId() {
        return intentoId;
    }

    public void setIntentoId(Long intentoId) {
        this.intentoId = intentoId;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Integer getElegida() {
        return elegida;
    }

    public void setElegida(Integer elegida) {
        this.elegida = elegida;
    }

    public Boolean getEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(Boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }
}
