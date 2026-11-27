
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Contenido;
import main.java.com.example.demo.service.ContenidoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
@CrossOrigin(origins = "*")
public class ContenidoController {

    private final ContenidoService contenidoService;

    public ContenidoController(ContenidoService contenidoService) {
        this.contenidoService = contenidoService;
    }

    @GetMapping
    public List<Contenido> listar() {
        return contenidoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> buscarPorId(@PathVariable Integer id) {
        return contenidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Contenido> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return contenidoService.listarPorObjetivo(objetivoId);
    }

    @PostMapping
    public Contenido guardar(@RequestBody Contenido contenido) {
        return contenidoService.guardar(contenido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        contenidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
