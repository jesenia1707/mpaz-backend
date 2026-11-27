
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Intento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntentoRepository extends JpaRepository<Intento, Integer> {

    List<Intento> findByEstudianteRut(String estudianteRut);

    List<Intento> findByObjetivoId(Integer objetivoId);

    List<Intento> findByEstudianteRutAndObjetivoId(
            String estudianteRut,
            Integer objetivoId);
}
