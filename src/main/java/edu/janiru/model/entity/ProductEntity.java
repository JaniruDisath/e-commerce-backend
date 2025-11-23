package edu.janiru.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private String sku;
    private String barcode;

    private String color;
    private String size;

    private double price;

    private int stockQuantity;

    private String brand;   // Optional: Nike, Adidas
    private String material; // Cotton, Polyester


    private boolean active = true;

}
