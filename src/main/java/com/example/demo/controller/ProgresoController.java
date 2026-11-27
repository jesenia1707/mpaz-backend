
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Progreso;
import main.java.com.example.demo.service.ProgresoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
@CrossOrigin(origins = "*")
public class ProgresoController {

    private final ProgresoService progresoService;

    public ProgresoController(ProgresoService progresoService) {
        this.progresoService = progresoService;
    }

    @GetMapping
    public List<Progreso> listar() {
        return progresoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progreso> buscarPorId(@PathVariable Long id) {
        return progresoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{rutEstudiante}")
    public List<Progreso> listarPorEstudiante(
            @PathVariable String rutEstudiante) {
        return progresoService.listarPorEstudiante(rutEstudiante);
    }

    @GetMapping("/estudiante/{rutEstudiante}/objetivo/{objetivoId}")
    public ResponseEntity<Progreso> buscarPorEstudianteYObjetivo(
            @PathVariable String rutEstudiante,
            @PathVariable Integer objetivoId) {
        return progresoService.buscarPorEstudianteYObjetivo(
                rutEstudiante, objetivoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Progreso guardar(@RequestBody Progreso progreso) {
        return progresoService.guardar(progreso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        progresoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
