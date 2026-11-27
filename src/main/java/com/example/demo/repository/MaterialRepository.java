
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByDocenteRut(String docenteRut);

    List<Material> findByEstado(String estado);

    List<Material> findByObjetivoId(Integer objetivoId);

    List<Material> findByDocenteRutAndEstado(
            String docenteRut,
            String estado);
}
