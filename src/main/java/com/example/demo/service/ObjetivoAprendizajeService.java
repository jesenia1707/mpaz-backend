
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.ObjetivoAprendizaje;
import main.java.com.example.demo.repository.ObjetivoAprendizajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetivoAprendizajeService {

    private final ObjetivoAprendizajeRepository objetivoRepository;

    public ObjetivoAprendizajeService(
            ObjetivoAprendizajeRepository objetivoRepository) {
        this.objetivoRepository = objetivoRepository;
    }

    public List<ObjetivoAprendizaje> listar() {
        return objetivoRepository.findAll();
    }

    public Optional<ObjetivoAprendizaje> buscarPorId(Integer id) {
        return objetivoRepository.findById(id);
    }

    public List<ObjetivoAprendizaje> listarPorAsignatura(String asignatura) {
        return objetivoRepository.findByAsignatura(asignatura);
    }

    public List<ObjetivoAprendizaje> listarPorUnidad(String unidad) {
        return objetivoRepository.findByUnidad(unidad);
    }

    public List<ObjetivoAprendizaje> listarPorAsignaturaYUnidad(
            String asignatura, String unidad) {
        return objetivoRepository.findByAsignaturaAndUnidad(asignatura, unidad);
    }

    public ObjetivoAprendizaje guardar(ObjetivoAprendizaje objetivo) {
        return objetivoRepository.save(objetivo);
    }

    public void eliminar(Integer id) {
        objetivoRepository.deleteById(id);
    }
}
