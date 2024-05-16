package com.example.cosmetic_springboot_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
public class Users implements UserDetails {
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
    private String token;
    private boolean status = true;
    private boolean isAdmin=false;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Cart> cart;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> "ROLE_USER");
        if(isAdmin){
            authorities.add((GrantedAuthority) () -> "ROLE_ADMIN");
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
