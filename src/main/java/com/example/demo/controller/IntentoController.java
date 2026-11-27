
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Intento;
import main.java.com.example.demo.service.IntentoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intentos")
@CrossOrigin(origins = "*")
public class IntentoController {

    private final IntentoService intentoService;

    public IntentoController(IntentoService intentoService) {
        this.intentoService = intentoService;
    }

    @GetMapping
    public List<Intento> listar() {
        return intentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Intento> buscarPorId(@PathVariable Integer id) {
        return intentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estudiante/{estudianteRut}")
    public List<Intento> listarPorEstudiante(
            @PathVariable String estudianteRut) {
        return intentoService.buscarPorEstudiante(estudianteRut);
    }

    @GetMapping("/objetivo/{objetivoId}")
    public List<Intento> listarPorObjetivo(
            @PathVariable Integer objetivoId) {
        return intentoService.buscarPorObjetivo(objetivoId);
    }

    @GetMapping("/estudiante/{estudianteRut}/objetivo/{objetivoId}")
    public List<Intento> listarPorEstudianteYObjetivo(
            @PathVariable String estudianteRut,
            @PathVariable Integer objetivoId) {
        return intentoService.buscarPorEstudianteYObjetivo(
                estudianteRut, objetivoId);
    }

    @PostMapping
    public Intento guardar(@RequestBody Intento intento) {
        return intentoService.guardar(intento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        intentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
