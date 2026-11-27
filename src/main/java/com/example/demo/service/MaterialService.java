
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Material;
import main.java.com.example.demo.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> listar() {
        return materialRepository.findAll();
    }

    public Optional<Material> buscarPorId(Long id) {
        return materialRepository.findById(id);
    }

    public List<Material> listarPorDocente(String docenteRut) {
        return materialRepository.findByDocenteRut(docenteRut);
    }

    public List<Material> listarPorEstado(String estado) {
        return materialRepository.findByEstado(estado);
    }

    public List<Material> listarPorObjetivo(Integer objetivoId) {
        return materialRepository.findByObjetivoId(objetivoId);
    }

    public Material guardar(Material material) {
        return materialRepository.save(material);
    }

    public void eliminar(Long id) {
        materialRepository.deleteById(id);
    }
}
