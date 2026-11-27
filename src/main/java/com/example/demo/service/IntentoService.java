
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Intento;
import main.java.com.example.demo.repository.IntentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntentoService {

    private final IntentoRepository intentoRepository;

    public IntentoService(IntentoRepository intentoRepository) {
        this.intentoRepository = intentoRepository;
    }

    public List<Intento> listarTodos() {
        return intentoRepository.findAll();
    }

    public Optional<Intento> buscarPorId(Integer id) {
        return intentoRepository.findById(id);
    }

    public List<Intento> buscarPorEstudiante(String estudianteRut) {
        return intentoRepository.findByEstudianteRut(estudianteRut);
    }

    public List<Intento> buscarPorObjetivo(Integer objetivoId) {
        return intentoRepository.findByObjetivoId(objetivoId);
    }

    public List<Intento> buscarPorEstudianteYObjetivo(
            String estudianteRut,
            Integer objetivoId) {

        return intentoRepository.findByEstudianteRutAndObjetivoId(
                estudianteRut,
                objetivoId);
    }

    public Intento guardar(Intento intento) {
        return intentoRepository.save(intento);
    }

    public void eliminar(Integer id) {
        intentoRepository.deleteById(id);
    }
}
