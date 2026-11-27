
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Respuesta;
import main.java.com.example.demo.repository.RespuestaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    private final RespuestaRepository respuestaRepository;

    public RespuestaService(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    public List<Respuesta> listar() {
        return respuestaRepository.findAll();
    }

    public Optional<Respuesta> buscarPorId(Long id) {
        return respuestaRepository.findById(id);
    }

    public List<Respuesta> listarPorIntento(Long intentoId) {
        return respuestaRepository.findByIntentoId(intentoId);
    }

    public List<Respuesta> listarPorPregunta(Integer preguntaId) {
        return respuestaRepository.findByPreguntaId(preguntaId);
    }

    public Respuesta guardar(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public void eliminar(Long id) {
        respuestaRepository.deleteById(id);
    }
}
