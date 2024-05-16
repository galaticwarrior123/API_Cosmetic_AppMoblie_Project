package com.example.cosmetic_springboot_api.Repository;

import com.example.cosmetic_springboot_api.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    @Query("SELECT c FROM Cart c WHERE c.users.id = ?1")
    List<Cart> findCartsByUsers_Id(Integer id);
}
