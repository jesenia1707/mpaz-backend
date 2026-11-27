
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Progreso;
import main.java.com.example.demo.repository.ProgresoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoService {

    private final ProgresoRepository progresoRepository;

    public ProgresoService(ProgresoRepository progresoRepository) {
        this.progresoRepository = progresoRepository;
    }

    public List<Progreso> listar() {
        return progresoRepository.findAll();
    }

    public Optional<Progreso> buscarPorId(Long id) {
        return progresoRepository.findById(id);
    }

    public List<Progreso> listarPorEstudiante(String rutEstudiante) {
        return progresoRepository.findByRutEstudiante(rutEstudiante);
    }

    public Optional<Progreso> buscarPorEstudianteYObjetivo(
            String rutEstudiante, Integer objetivoId) {
        return progresoRepository.findByRutEstudianteAndObjetivoId(
                rutEstudiante, objetivoId);
    }

    public Progreso guardar(Progreso progreso) {
        return progresoRepository.save(progreso);
    }

    public void eliminar(Long id) {
        progresoRepository.deleteById(id);
    }
}
