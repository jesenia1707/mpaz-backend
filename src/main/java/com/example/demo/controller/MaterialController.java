
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Material;
import main.java.com.example.demo.service.MaterialService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
@CrossOrigin(origins = "*")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<Material> listar() {
        return materialService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> buscarPorId(@PathVariable Long id) {
        return materialService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/docente/{docenteRut}")
    public List<Material> listarPorDocente(
            @PathVariable String docenteRut) {
        return materialService.listarPorDocente(docenteRut);
    }

    @GetMapping("/estado/{estado}")
    public List<Material> listarPorEstado(@PathVariable String estado) {
        return materialService.listarPorEstado(estado);
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Material> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return materialService.listarPorObjetivo(objetivoId);
    }

    @PostMapping
    public Material guardar(@RequestBody Material material) {
        return materialService.guardar(material);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        materialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
