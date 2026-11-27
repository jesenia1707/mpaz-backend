
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    List<Pregunta> findByObjetivoId(Integer objetivoId);

}
