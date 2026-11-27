
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Guia;
import main.java.com.example.demo.repository.GuiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuiaService {

    private final GuiaRepository guiaRepository;

    public GuiaService(GuiaRepository guiaRepository) {
        this.guiaRepository = guiaRepository;
    }

    public List<Guia> listar() {
        return guiaRepository.findAll();
    }

    public Optional<Guia> buscarPorId(Integer id) {
        return guiaRepository.findById(id);
    }

    public List<Guia> listarPorObjetivo(Integer objetivoId) {
        return guiaRepository.findByObjetivoId(objetivoId);
    }

    public Guia guardar(Guia guia) {
        return guiaRepository.save(guia);
    }

    public void eliminar(Integer id) {
        guiaRepository.deleteById(id);
    }
}
