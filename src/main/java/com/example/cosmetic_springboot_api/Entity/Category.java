package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
@Builder
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}
