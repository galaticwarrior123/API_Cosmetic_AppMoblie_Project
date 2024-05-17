package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Builder
@Entity
@SequenceGenerator(
        initialValue = 1,
        name = "product_sequence",
        sequenceName = "product_sequence",
        allocationSize = 1
)
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Integer id;
    private String name;
    private String description;
    private Long price;
    private Integer stock;
    private boolean status;

    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Category category;

}
