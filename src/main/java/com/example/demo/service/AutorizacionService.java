
package main.java.com.example.demo.service;

import main.java.com.example.demo.model.Autorizacion;
import main.java.com.example.demo.repository.AutorizacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorizacionService {

    private final AutorizacionRepository autorizacionRepository;

    public AutorizacionService(AutorizacionRepository autorizacionRepository) {
        this.autorizacionRepository = autorizacionRepository;
    }

    public List<Autorizacion> listar() {
        return autorizacionRepository.findAll();
    }

    public Optional<Autorizacion> buscarPorId(Long id) {
        return autorizacionRepository.findById(id);
    }

    public List<Autorizacion> listarPorMaterial(Long materialId) {
        return autorizacionRepository.findByMaterialId(materialId);
    }

    public List<Autorizacion> listarPorUtp(String utpRut) {
        return autorizacionRepository.findByUtpRut(utpRut);
    }

    public List<Autorizacion> listarPorDecision(String decision) {
        return autorizacionRepository.findByDecision(decision);
    }

    public Autorizacion guardar(Autorizacion autorizacion) {
        return autorizacionRepository.save(autorizacion);
    }

    public void eliminar(Long id) {
        autorizacionRepository.deleteById(id);
    }
}
