package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image")
@Builder
@Entity
@SequenceGenerator(
        initialValue = 1,
        name = "image_sequence",
        sequenceName = "image_sequence",
        allocationSize = 1
)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
    private Integer id;
    private String url;

    @ManyToOne
    private Product product;
}
