package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
@Builder
@SequenceGenerator(
        initialValue = 1,
        name = "category_sequence",
        sequenceName = "category_sequence",
        allocationSize = 1
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Integer id;
    private String name;
}
