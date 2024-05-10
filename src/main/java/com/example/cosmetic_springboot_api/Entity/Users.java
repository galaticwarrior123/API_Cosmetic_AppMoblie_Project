package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
@Entity
@SequenceGenerator(
        initialValue = 1,
        name = "product_sequence",
        sequenceName = "product_sequence",
        allocationSize = 1
)

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String image;
    private boolean isAdmin = false;
}
