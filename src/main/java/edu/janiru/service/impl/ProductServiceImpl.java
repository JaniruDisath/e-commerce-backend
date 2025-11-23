package edu.janiru.service.impl;

import edu.janiru.model.dto.Product;
import edu.janiru.model.entity.ProductEntity;
import edu.janiru.repository.ProductRepository;
import edu.janiru.service.ProductService;
import edu.janiru.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return Mapper.toModel(productRepository.save(Mapper.toEntity(product)));
    }

    @Override
    public Product getProduct(Long id) {
        return Mapper.toModel(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<Product> getAllProducts() {
        return Mapper.toModelList(productRepository.findAll());
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = Mapper.toModel(productRepository.findById(id).orElse(null));

        if (product == null) return null;

        product.setName(updatedProduct.getName());
        product.setEmail(updatedProduct.getEmail());
        product.setPhone(updatedProduct.getPhone());
        product.setAddress(updatedProduct.getAddress());
        product.setCreatedDate(updatedProduct.getCreatedDate());

        return Mapper.toModel(productRepository.save(Mapper.toEntity(product)));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
}
