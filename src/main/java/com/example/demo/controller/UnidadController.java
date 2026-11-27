
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Unidad;
import main.java.com.example.demo.service.UnidadService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unidades")
@CrossOrigin(origins = "*")
public class UnidadController {

    private final UnidadService unidadService;

    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    @GetMapping
    public List<Unidad> listar() {
        return unidadService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidad> buscarPorId(@PathVariable Long id) {
        return unidadService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public List<Unidad> listarPorAsignatura(
            @PathVariable Long asignaturaId) {
        return unidadService.listarPorAsignatura(asignaturaId);
    }

    @PostMapping
    public Unidad guardar(@RequestBody Unidad unidad) {
        return unidadService.guardar(unidad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        unidadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
