
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        if (user.getRut() == null || user.getNombre() == null
                || user.getPassword() == null || user.getRol() == null) {
            return ResponseEntity.badRequest()
                    .body("Todos los campos son obligatorios.");
        }

        if (userRepository.findByRut(user.getRut()).isPresent()) {
            return ResponseEntity.badRequest()
                    .body("El RUT ya está registrado.");
        }

        Set<String> rolesPermitidos = Set.of("ESTUDIANTE", "DOCENTE");

        if (!rolesPermitidos.contains(user.getRol().toUpperCase())) {
            return ResponseEntity.badRequest()
                    .body("Rol no permitido para el registro.");
        }

        user.setRol(user.getRol().toUpperCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        var foundUser = userRepository.findByRut(user.getRut());

        if (foundUser.isPresent()
                && passwordEncoder.matches(
                        user.getPassword(),
                        foundUser.get().getPassword())) {

            User usuario = foundUser.get();
            String token = jwtUtils.generateToken(
                    usuario.getRut(),
                    usuario.getRol());

            return ResponseEntity.ok(Map.of(
                    "token", token,
                    "rut", usuario.getRut(),
                    "nombre", usuario.getNombre(),
                    "rol", usuario.getRol()));
        }

        return ResponseEntity.status(401)
                .body("Credenciales inválidas.");
    }
}
