
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Contenido;
import main.java.com.example.demo.repository.ContenidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    private final ContenidoRepository contenidoRepository;

    public ContenidoService(ContenidoRepository contenidoRepository) {
        this.contenidoRepository = contenidoRepository;
    }

    public List<Contenido> listar() {
        return contenidoRepository.findAll();
    }

    public Optional<Contenido> buscarPorId(Integer id) {
        return contenidoRepository.findById(id);
    }

    public List<Contenido> listarPorObjetivo(Integer objetivoId) {
        return contenidoRepository.findByObjetivoId(objetivoId);
    }

    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public void eliminar(Integer id) {
        contenidoRepository.deleteById(id);
    }
}
