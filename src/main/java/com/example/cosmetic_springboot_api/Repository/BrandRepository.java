package com.example.cosmetic_springboot_api.Repository;

import com.example.cosmetic_springboot_api.Entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
