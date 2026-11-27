
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Guia;
import main.java.com.example.demo.service.GuiaService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guias")
@CrossOrigin(origins = "*")
public class GuiaController {

    private final GuiaService guiaService;

    public GuiaController(GuiaService guiaService) {
        this.guiaService = guiaService;
    }

    @GetMapping
    public List<Guia> listar() {
        return guiaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guia> buscarPorId(@PathVariable Integer id) {
        return guiaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Guia> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return guiaService.listarPorObjetivo(objetivoId);
    }

    @PostMapping
    public Guia guardar(@RequestBody Guia guia) {
        return guiaService.guardar(guia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        guiaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
