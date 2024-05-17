package com.example.cosmetic_springboot_api.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="orders")
@Builder
@Entity
@SequenceGenerator(
        initialValue = 1,
        name = "order_sequence",
        sequenceName = "order_sequence",
        allocationSize = 1
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Integer id;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private String address;
    private String phone;
    private Long total;
    private boolean status=false;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Cart cart;
}
