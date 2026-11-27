
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Pregunta;
import main.java.com.example.demo.service.PreguntaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preguntas")
@CrossOrigin(origins = "*")
public class PreguntaController {

    private final PreguntaService preguntaService;

    public PreguntaController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;
    }

    @GetMapping
    public List<Pregunta> listar() {
        return preguntaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> buscarPorId(@PathVariable Integer id) {
        return preguntaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Pregunta> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return preguntaService.listarPorObjetivo(objetivoId);
    }

    @PostMapping
    public Pregunta guardar(@RequestBody Pregunta pregunta) {
        return preguntaService.guardar(pregunta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        preguntaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
