package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
@Builder
@Entity
@SequenceGenerator(
        initialValue = 1,
        name = "cart_sequence",
        sequenceName = "cart_sequence",
        allocationSize = 1)
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence")
    private Integer id;
    private String name;
    private Integer price;
    private boolean status=false;
    @ManyToOne
    private Users users;

    @ManyToOne
    private Order order;
}

