package ru.kustikov.cakes.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kustikov.cakes.producttype.ProductType;
import ru.kustikov.cakes.producttype.ProductTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAll(@RequestParam(required = false) String username,
                                                @RequestParam(required = false) Integer skip,
                                                @RequestParam(required = false) Integer limit) {
        if (username != null && !username.isEmpty()) {
            return productService.getProductsByUsername(username);
        } else {
            return productService.getProducts(skip, limit);
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

    @PostMapping("/delete-product-type")
    public ResponseEntity<?> deleteProductType(@RequestBody Long productTypeId) {
        productTypeService.delete(productTypeId);
        return ResponseEntity.ok("Success");
    }
}
