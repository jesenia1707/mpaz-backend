
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Respuesta;
import main.java.com.example.demo.service.RespuestaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
@CrossOrigin(origins = "*")
public class RespuestaController {

    private final RespuestaService respuestaService;

    public RespuestaController(RespuestaService respuestaService) {
        this.respuestaService = respuestaService;
    }

    @GetMapping
    public List<Respuesta> listar() {
        return respuestaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> buscarPorId(@PathVariable Long id) {
        return respuestaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/intento/{intentoId}")
    public List<Respuesta> listarPorIntento(
            @PathVariable Long intentoId) {
        return respuestaService.listarPorIntento(intentoId);
    }

    @GetMapping("/pregunta/{preguntaId}")
    public List<Respuesta> listarPorPregunta(
            @PathVariable Integer preguntaId) {
        return respuestaService.listarPorPregunta(preguntaId);
    }

    @PostMapping
    public Respuesta guardar(@RequestBody Respuesta respuesta) {
        return respuestaService.guardar(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
