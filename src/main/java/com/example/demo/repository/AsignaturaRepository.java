package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

    Optional<Asignatura> findByNombre(String nombre);
}