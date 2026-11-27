
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Evaluacion;
import main.java.com.example.demo.service.EvaluacionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
@CrossOrigin(origins = "*")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @GetMapping
    public List<Evaluacion> listar() {
        return evaluacionService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> buscarPorId(
            @PathVariable Long id) {
        return evaluacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Evaluacion> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return evaluacionService.listarPorObjetivo(objetivoId);
    }

    @GetMapping("/estado/{activa}")
    public List<Evaluacion> listarPorEstado(
            @PathVariable Boolean activa) {
        return evaluacionService.listarPorEstado(activa);
    }

    @PostMapping
    public Evaluacion guardar(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.guardar(evaluacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        evaluacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
