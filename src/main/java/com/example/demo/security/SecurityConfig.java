
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

        private final JwtUtils jwtUtils;

        public SecurityConfig(JwtUtils jwtUtils) {
                this.jwtUtils = jwtUtils;
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http)
                        throws Exception {

                http
                                .csrf(csrf -> csrf.disable())

                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                .authorizeHttpRequests(auth -> auth

                                                // Registro e inicio de sesión
                                                .requestMatchers("/api/auth/**").permitAll()

                                                // Consultar contenidos educativos
                                                .requestMatchers(HttpMethod.GET,
                                                                "/api/unidades/**",
                                                                "/api/asignaturas/**",
                                                                "/api/objetivos/**",
                                                                "/api/contenidos/**",
                                                                "/api/preguntas/**",
                                                                "/api/guias/**",
                                                                "/api/evaluaciones/**")
                                                .hasAnyRole("ESTUDIANTE", "DOCENTE", "JEFEUTP")

                                                // Administrar contenidos: solamente JEFEUTP
                                                .requestMatchers(
                                                                "/api/unidades/**",
                                                                "/api/asignaturas/**",
                                                                "/api/objetivos/**",
                                                                "/api/contenidos/**",
                                                                "/api/preguntas/**",
                                                                "/api/guias/**",
                                                                "/api/evaluaciones/**")
                                                .hasRole("JEFEUTP")

                                                // Consultar materiales
                                                .requestMatchers(HttpMethod.GET, "/api/materiales/**")
                                                .hasAnyRole("ESTUDIANTE", "DOCENTE", "JEFEUTP")

                                                // Docente y JEFEUTP pueden cargar materiales
                                                .requestMatchers(HttpMethod.POST, "/api/materiales/**")
                                                .hasAnyRole("DOCENTE", "JEFEUTP")

                                                // Otras modificaciones de materiales: JEFEUTP
                                                .requestMatchers("/api/materiales/**")
                                                .hasRole("JEFEUTP")

                                                // Solamente JEFEUTP administra autorizaciones
                                                .requestMatchers("/api/autorizaciones/**")
                                                .hasRole("JEFEUTP")

                                                // Consultar progreso
                                                .requestMatchers(HttpMethod.GET, "/api/progreso/**")
                                                .hasAnyRole("ESTUDIANTE", "DOCENTE", "JEFEUTP")

                                                // Estudiantes registran su progreso
                                                .requestMatchers(HttpMethod.POST, "/api/progreso/**")
                                                .hasRole("ESTUDIANTE")

                                                // Consultar intentos y respuestas
                                                .requestMatchers(HttpMethod.GET,
                                                                "/api/intentos/**",
                                                                "/api/respuestas/**")
                                                .hasAnyRole("ESTUDIANTE", "DOCENTE", "JEFEUTP")

                                                // Estudiantes envían intentos y respuestas
                                                .requestMatchers(HttpMethod.POST,
                                                                "/api/intentos/**",
                                                                "/api/respuestas/**")
                                                .hasRole("ESTUDIANTE")

                                                // Administrar usuarios
                                                .requestMatchers("/api/usuarios/**")
                                                .hasRole("JEFEUTP")

                                                // Cualquier otra petición queda bloqueada
                                                .anyRequest().denyAll())

                                .addFilterBefore(
                                                new JwtAuthFilter(jwtUtils),
                                                UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}
