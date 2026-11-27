
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.ObjetivoAprendizaje;
import main.java.com.example.demo.service.ObjetivoAprendizajeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/objetivos")
@CrossOrigin(origins = "*")
public class ObjetivoController {

    private final ObjetivoAprendizajeService objetivoService;

    public ObjetivoController(ObjetivoAprendizajeService objetivoService) {
        this.objetivoService = objetivoService;
    }

    @GetMapping
    public List<ObjetivoAprendizaje> listar() {
        return objetivoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoAprendizaje> buscarPorId(
            @PathVariable Integer id) {
        return objetivoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/asignatura/{asignatura}")
    public List<ObjetivoAprendizaje> listarPorAsignatura(
            @PathVariable String asignatura) {
        return objetivoService.listarPorAsignatura(asignatura);
    }

    @GetMapping("/unidad/{unidad}")
    public List<ObjetivoAprendizaje> listarPorUnidad(
            @PathVariable String unidad) {
        return objetivoService.listarPorUnidad(unidad);
    }

    @GetMapping("/filtrar")
    public List<ObjetivoAprendizaje> listarPorAsignaturaYUnidad(
            @RequestParam String asignatura,
            @RequestParam String unidad) {
        return objetivoService.listarPorAsignaturaYUnidad(
                asignatura, unidad);
    }

    @PostMapping
    public ObjetivoAprendizaje guardar(
            @RequestBody ObjetivoAprendizaje objetivo) {
        return objetivoService.guardar(objetivo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        objetivoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
