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
@Table(name = "cart_product")
@Builder
@SequenceGenerator(
        initialValue = 1,
        name = "cart_product_sequence",
        sequenceName = "cart_product_sequence",
        allocationSize = 1
)
public class Cart_product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_product_sequence")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    private Integer quantity;

    @ManyToOne
    private Cart cart;
}
