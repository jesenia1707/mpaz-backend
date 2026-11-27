
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Pregunta;
import main.java.com.example.demo.repository.PreguntaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaService(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    public List<Pregunta> listar() {
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> buscarPorId(Integer id) {
        return preguntaRepository.findById(id);
    }

    public List<Pregunta> listarPorObjetivo(Integer objetivoId) {
        return preguntaRepository.findByObjetivoId(objetivoId);
    }

    public Pregunta guardar(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public void eliminar(Integer id) {
        preguntaRepository.deleteById(id);
    }
}
