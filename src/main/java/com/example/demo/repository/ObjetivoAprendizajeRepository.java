
package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.ObjetivoAprendizaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjetivoAprendizajeRepository extends JpaRepository<ObjetivoAprendizaje, Integer> {

    List<ObjetivoAprendizaje> findByAsignatura(String asignatura);

    List<ObjetivoAprendizaje> findByUnidad(String unidad);

    List<ObjetivoAprendizaje> findByAsignaturaAndUnidad(String asignatura, String unidad);

}
