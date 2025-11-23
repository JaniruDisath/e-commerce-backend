package edu.janiru.util;

import edu.janiru.model.dto.Product;
import edu.janiru.model.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    public Product toModel (ProductEntity productEntity){
        return modelMapper.map(productEntity, Product.class);
    }

    public ProductEntity toEntity (Product product){
        return modelMapper.map(product, ProductEntity.class);
    }

    public List<Product> toModelList(List<ProductEntity> productEntities){
        List<Product> productList = new ArrayList<>();
        for (ProductEntity entity : productEntities){
            productList.add(toModel(entity));
        }
        return productList;
    }

    public List<ProductEntity> toEntityList(List<Product> products){
        List<ProductEntity> productEntityList = new ArrayList<>();
        for (Product product : products){
            productEntityList.add(toEntity(product));
        }
        return productEntityList;
    }
}
