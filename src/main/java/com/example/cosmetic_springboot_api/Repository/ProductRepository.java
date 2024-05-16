package com.example.cosmetic_springboot_api.Repository;

import com.example.cosmetic_springboot_api.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.category.id = ?1")
    List<Product> findProductsByCategory_Id(int categoryId);

    @Query("SELECT p FROM Product p WHERE p.brand.id = ?1")
    List<Product> findProductsByBrand_Id(int brandId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.brand.id = ?1")
    void deleteProductByBrand_Id(int brandId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product p WHERE p.category.id = ?1")
    void deleteProductByCategory_Id(int categoryId);

}
