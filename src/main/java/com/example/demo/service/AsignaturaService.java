
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Asignatura;
import main.java.com.example.demo.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public List<Asignatura> listar() {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> buscarPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
