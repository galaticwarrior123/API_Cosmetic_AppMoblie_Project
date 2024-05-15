package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.ProductResponse;
import com.example.cosmetic_springboot_api.Response.UsersResponse;
import com.example.cosmetic_springboot_api.Service.IProductService;
import com.example.cosmetic_springboot_api.Service.IUsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
public class UsersController {
    private final IUsersService usersService;
    @PostMapping("")
    public ResponseEntity<UsersResponse> addUsers(@Valid @RequestBody UsersDto usersDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(usersService.registerUser(usersDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsersResponse>> getAllUsers(){
        return ResponseEntity.ok(usersService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponse> getUserById(@PathVariable int id){
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<UsersResponse> updateStatus(@PathVariable int id){
        return ResponseEntity.ok(usersService.updateStatusUser(id));
    }

    @PutMapping("/update/{id}")
        public ResponseEntity<UsersResponse> updateUser(@PathVariable int id, @RequestBody UsersDto usersDto){
        return ResponseEntity.ok(usersService.updateUser(id));
    }
}
