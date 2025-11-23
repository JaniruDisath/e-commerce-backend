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

    private final ProductRepository productRepository;
    private final Mapper mapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, Mapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public Product saveProduct(Product product) {
        return mapper.toModel(productRepository.save(mapper.toEntity(product)));
    }

    @Override
    public Product getProduct(Long id) {
        return mapper.toModel(productRepository.findById(id).orElse(null));
    }

    @Override
    public List<Product> getAllProducts() {
        return mapper.toModelList(productRepository.findAll());
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        ProductEntity existingEntity = productRepository.findById(id).orElse(null);

        if (existingEntity == null) return null;

        if (updatedProduct.getName() != null) {
            existingEntity.setName(updatedProduct.getName());
        }
        if (updatedProduct.getDescription() != null) {
            existingEntity.setDescription(updatedProduct.getDescription());
        }
        if (updatedProduct.getSku() != null) {
            existingEntity.setSku(updatedProduct.getSku());
        }
        if (updatedProduct.getBarcode() != null) {
            existingEntity.setBarcode(updatedProduct.getBarcode());
        }
        if (updatedProduct.getColor() != null) {
            existingEntity.setColor(updatedProduct.getColor());
        }

        if (updatedProduct.getSize() != null) {
            existingEntity.setSize(updatedProduct.getSize());
        }

        if (updatedProduct.getPrice() != null) {
            existingEntity.setPrice(updatedProduct.getPrice());
        }

        if (updatedProduct.getStockQuantity() != null) {
            existingEntity.setStockQuantity(updatedProduct.getStockQuantity());
        }

        if (updatedProduct.getBrand() != null) {
            existingEntity.setBrand(updatedProduct.getBrand());
        }

        if (updatedProduct.getMaterial() != null) {
            existingEntity.setMaterial(updatedProduct.getMaterial());
        }

        if (updatedProduct.getActive() != null) {
            existingEntity.setActive(updatedProduct.getActive());
        }


        ProductEntity saved = productRepository.save(existingEntity);
        return mapper.toModel(saved);
    }

    @Override
    public void updateQuantity(Long id, Integer quantity) {
        ProductEntity existingEntity = productRepository.findById(id).orElse(null);

        if (quantity != null) {
            existingEntity.setStockQuantity(existingEntity.getStockQuantity()-quantity);
        }
        ProductEntity saved = productRepository.save(existingEntity);
        mapper.toModel(saved);
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
