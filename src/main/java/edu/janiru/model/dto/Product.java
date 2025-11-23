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
    private String email;
    private String phone;
    private String address;
    private LocalDate createdDate;

}