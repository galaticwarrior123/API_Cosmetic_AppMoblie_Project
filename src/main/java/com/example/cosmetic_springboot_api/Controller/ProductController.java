package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Response.ProductResponse;
import com.example.cosmetic_springboot_api.Service.ICategoryService;
import com.example.cosmetic_springboot_api.Service.IImageService;
import com.example.cosmetic_springboot_api.Service.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;


    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getAllProductByCategory(@PathVariable int categoryId){
        return ResponseEntity.ok(productService.getAllProductByCategory(categoryId));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("")
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable int id, @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

    @PutMapping("status/{id}")
    public ResponseEntity<ProductResponse> updateStatusProduct(@PathVariable int id){
        return ResponseEntity.ok(productService.updateStatusProduct(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();

    }




}
