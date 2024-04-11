package com.example.cosmetic_springboot_api.Controller;


import com.example.cosmetic_springboot_api.Dto.BrandDto;
import com.example.cosmetic_springboot_api.Response.BrandResponse;
import com.example.cosmetic_springboot_api.Service.IBrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandController {
    private final IBrandService brandService;

    @GetMapping("")
    public ResponseEntity<List<BrandResponse>> getAllBrand(){
        return ResponseEntity.ok(brandService.getAllBrand());
    }

    @PostMapping("")
    public ResponseEntity<BrandResponse> addBrand(@Valid @RequestBody BrandDto brandDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(brandService.addBrand(brandDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> updateBrand(@PathVariable int id, @RequestBody BrandDto brandDto){
        return ResponseEntity.ok(brandService.updateBrand(id, brandDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable int id){
        brandService.deleteBrand(id);
        return ResponseEntity.ok().build();
    }

}
