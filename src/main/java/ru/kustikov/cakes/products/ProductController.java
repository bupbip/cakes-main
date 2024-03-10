package ru.kustikov.cakes.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/get-all")
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false) String username) {
        if (username != null && !username.isEmpty()) {
            return productService.getProductsByUsername(username);
        } else {
            return productService.getProducts();
        }
    }

    @PostMapping("/save-product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        productService.save(product);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/delete-product")
    public ResponseEntity<Product> deleteProduct(@RequestBody Product product) {
        productService.delete(product);
        return ResponseEntity.ok(product);
    }
}
