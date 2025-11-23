package edu.janiru.model.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Product {
    private Long id;

    private String name;
    private String description;

    private String sku;
    private String barcode;

    private String color;
    private String size;

    private Double price;

    private Integer stockQuantity;

    private String brand;   // Optional: Nike, Adidas
    private String material; // Cotton, Polyester

    private Boolean active = true;

}