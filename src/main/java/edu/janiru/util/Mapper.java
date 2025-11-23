package edu.janiru.util;

import edu.janiru.model.dto.Product;
import edu.janiru.model.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    @Autowired
    private static ModelMapper modelMapper;

    public static Product toModel (ProductEntity productEntity){
        return modelMapper.map(productEntity, Product.class);
    }

    public static ProductEntity toEntity (Product product){
        return modelMapper.map(product, ProductEntity.class);
    }

    public static List<Product> toModelList(List<ProductEntity> productEntities){
        List<Product> productList = new ArrayList<>();
        for (ProductEntity entity : productEntities){
            productList.add(toModel(entity));
        }
        return productList;
    }

    public static List<ProductEntity> toEntityList(List<Product> products){
        List<ProductEntity> productEntityList = new ArrayList<>();
        for (Product product : products){
            productEntityList.add(toEntity(product));
        }
        return productEntityList;
    }
}
