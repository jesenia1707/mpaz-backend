
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {

    List<Unidad> findByAsignaturaId(Long asignaturaId);

}
