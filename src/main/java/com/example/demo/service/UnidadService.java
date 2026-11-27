
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Unidad;
import main.java.com.example.demo.repository.UnidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadService {

    private final UnidadRepository unidadRepository;

    public UnidadService(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    public List<Unidad> listar() {
        return unidadRepository.findAll();
    }

    public Optional<Unidad> buscarPorId(Long id) {
        return unidadRepository.findById(id);
    }

    public List<Unidad> listarPorAsignatura(Long asignaturaId) {
        return unidadRepository.findByAsignaturaId(asignaturaId);
    }

    public Unidad guardar(Unidad unidad) {
        return unidadRepository.save(unidad);
    }

    public void eliminar(Long id) {
        unidadRepository.deleteById(id);
    }
}
