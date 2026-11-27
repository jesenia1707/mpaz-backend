
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByIntentoId(Long intentoId);

    List<Respuesta> findByPreguntaId(Integer preguntaId);

}
