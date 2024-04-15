package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="brand")
@Builder
@SequenceGenerator(
        initialValue = 1,
        name = "brand_sequence",
        sequenceName = "brand_sequence",
        allocationSize = 1
)
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_sequence")
    private Integer id;
    private String name;
}
