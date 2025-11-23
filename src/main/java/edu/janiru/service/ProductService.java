package edu.janiru.service;

import edu.janiru.model.dto.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product Product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product Product);
    void deleteProduct(Long id);
    
}
