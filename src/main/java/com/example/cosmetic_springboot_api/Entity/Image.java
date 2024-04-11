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
public class Image {
    @Id
    @GeneratedValue
    private int id;
    private String url;

    @ManyToOne
    private Product product;
}
