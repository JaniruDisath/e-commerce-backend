package edu.janiru.util;

import edu.janiru.model.dto.Product;
import edu.janiru.model.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static Product toModel (ProductEntity productEntity){
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getEmail(),
                productEntity.getPhone(),
                productEntity.getAddress(),
                productEntity.getCreatedDate()
        );
    }

    public static ProductEntity toEntity (Product product){
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getEmail(),
                product.getPhone(),
                product.getAddress(),
                product.getCreatedDate()
        );
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
