package com.example.cosmetic_springboot_api.Component;

import com.example.cosmetic_springboot_api.Entity.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Extractor {
    public Integer getUserIdFromToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Users user){
            return user.getId();
        }
        return null;
    }
}
