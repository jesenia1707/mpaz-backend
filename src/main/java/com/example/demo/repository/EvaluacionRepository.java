
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

    List<Evaluacion> findByObjetivoId(Integer objetivoId);

    List<Evaluacion> findByActiva(Boolean activa);

}
