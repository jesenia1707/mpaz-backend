
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Evaluacion;
import main.java.com.example.demo.repository.EvaluacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionService(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    public List<Evaluacion> listar() {
        return evaluacionRepository.findAll();
    }

    public Optional<Evaluacion> buscarPorId(Long id) {
        return evaluacionRepository.findById(id);
    }

    public List<Evaluacion> listarPorObjetivo(Integer objetivoId) {
        return evaluacionRepository.findByObjetivoId(objetivoId);
    }

    public List<Evaluacion> listarPorEstado(Boolean activa) {
        return evaluacionRepository.findByActiva(activa);
    }

    public Evaluacion guardar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public void eliminar(Long id) {
        evaluacionRepository.deleteById(id);
    }
}
