package edu.janiru.controller;

import edu.janiru.model.dto.Product;
import edu.janiru.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CREATE
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product Product) {
        return productService.saveProduct(Product);
    }

    // READ (single)
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    // READ (all)
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product Product) {
        return productService.updateProduct(id, Product);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted";
    }
}