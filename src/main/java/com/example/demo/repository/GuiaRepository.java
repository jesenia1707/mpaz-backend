package main.java.com.example.demo.repository;

import main.java.com.example.demo.model.Guia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuiaRepository extends JpaRepository<Guia, Integer> {

    List<Guia> findByObjetivoId(Integer objetivoId);

}
