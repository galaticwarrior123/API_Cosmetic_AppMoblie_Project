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
public class Product{
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private boolean status;

    @OneToOne
    private Brand brand;
    @OneToOne
    private Category category;

}
