package ru.kustikov.cakes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kustikov.cakes.products.Product;
import ru.kustikov.cakes.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-all")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false) String username) {
        if (username != null && !username.isEmpty()) {
            return productService.getProductsByUsername(username);
        } else {
            return productService.getProducts();
        }
    }
}
