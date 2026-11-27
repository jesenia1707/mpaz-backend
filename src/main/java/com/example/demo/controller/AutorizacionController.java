
package main.java.com.example.demo.controller;

import main.java.com.example.demo.model.Autorizacion;
import main.java.com.example.demo.service.AutorizacionService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autorizaciones")
@CrossOrigin(origins = "*")
public class AutorizacionController {

    private final AutorizacionService autorizacionService;

    public AutorizacionController(
            AutorizacionService autorizacionService) {
        this.autorizacionService = autorizacionService;
    }

    // Consultar todas las autorizaciones
    @GetMapping
    public List<Autorizacion> listar() {
        return autorizacionService.listar();
    }

    // Buscar autorización por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autorizacion> buscarPorId(
            @PathVariable Long id) {

        return autorizacionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Consultar historial de un material
    @GetMapping("/material/{materialId}")
    public List<Autorizacion> listarPorMaterial(
            @PathVariable Long materialId) {

        return autorizacionService.listarPorMaterial(materialId);
    }

    // Consultar autorizaciones del JEFEUTP autenticado
    @GetMapping("/mis-autorizaciones")
    public List<Autorizacion> listarMisAutorizaciones(
            Authentication authentication) {

        String utpRut = authentication.getName();

        return autorizacionService.listarPorUtp(utpRut);
    }

    // Filtrar por decisión
    @GetMapping("/decision/{decision}")
    public List<Autorizacion> listarPorDecision(
            @PathVariable String decision) {

        return autorizacionService.listarPorDecision(decision);
    }

    // Aprobar o rechazar material
    @PostMapping
    public ResponseEntity<Autorizacion> guardar(
            @RequestBody Autorizacion autorizacion,
            Authentication authentication) {

        // El RUT se obtiene del token JWT
        autorizacion.setUtpRut(authentication.getName());

        Autorizacion resultado = autorizacionService.guardar(autorizacion);

        return ResponseEntity.ok(resultado);
    }

    // No se permite eliminar el historial de autorizaciones
}
