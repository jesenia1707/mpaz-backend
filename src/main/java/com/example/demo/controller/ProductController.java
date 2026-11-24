package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Endpoint PÚBLICO para consultar todos los productos
    @GetMapping
    public List<Product> listarProductos() {
        return productRepository.findAll();
    }

    // Endpoint PÚBLICO para consultar un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> obtenerProductoPorId(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint PROTEGIDO para crear un producto (requiere token JWT)
    @PostMapping
    public ResponseEntity<Product> crearProducto(@RequestBody Product product) {
        Product nuevoProducto = productRepository.save(product);
        return ResponseEntity.ok(nuevoProducto);
    }
}