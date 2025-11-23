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
        ProductEntity existingEntity = productRepository.findById(id).orElse(null);

        if (existingEntity == null) return null;

        existingEntity.setName(updatedProduct.getName());
        existingEntity.setDescription(updatedProduct.getDescription());
        existingEntity.setSku(updatedProduct.getSku());
        existingEntity.setBarcode(updatedProduct.getBarcode());
        existingEntity.setColor(updatedProduct.getColor());
        existingEntity.setSize(updatedProduct.getSize());
        existingEntity.setPrice(updatedProduct.getPrice());
        existingEntity.setStockQuantity(updatedProduct.getStockQuantity());
        existingEntity.setBrand(updatedProduct.getBrand());
        existingEntity.setMaterial(updatedProduct.getMaterial());
        existingEntity.setImageUrl(updatedProduct.getImageUrl());
        existingEntity.setActive(updatedProduct.isActive());

        ProductEntity saved = productRepository.save(existingEntity);
        return Mapper.toModel(saved);
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
}
