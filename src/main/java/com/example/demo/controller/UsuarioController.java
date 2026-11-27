
package main.java.com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UserRepository userRepository;

    public UsuarioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Map<String, Object>> listar() {
        return userRepository.findAll()
                .stream()
                .map(this::convertirUsuario)
                .toList();
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Map<String, Object>> buscarPorRut(
            @PathVariable String rut) {

        return userRepository.findByRut(rut)
                .map(usuario -> ResponseEntity.ok(convertirUsuario(usuario)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    private Map<String, Object> convertirUsuario(User usuario) {
        Map<String, Object> datos = new HashMap<>();

        datos.put("id", usuario.getId());
        datos.put("rut", usuario.getRut());
        datos.put("nombre", usuario.getNombre());
        datos.put("rol", usuario.getRol());

        return datos;
    }
}
