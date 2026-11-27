
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgresoRepository extends JpaRepository<Progreso, Long> {

    List<Progreso> findByRutEstudiante(String rutEstudiante);

    Optional<Progreso> findByRutEstudianteAndObjetivoId(
            String rutEstudiante,
            Integer objetivoId);
}
