package com.example.cosmetic_springboot_api.Repository;

import com.example.cosmetic_springboot_api.Entity.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("SELECT i.url FROM Image i WHERE i.product.id = ?1")
    List<String> findAllURLByProduct(int productId);

    @Modifying
    @Transactional
    @Query("delete from Image i where i.product.id = ?1")
    void deleteAllByProductId(int id);
}
