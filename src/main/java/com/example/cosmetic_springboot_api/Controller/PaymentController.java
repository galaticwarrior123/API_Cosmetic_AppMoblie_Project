package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.PaymentDto;
import com.example.cosmetic_springboot_api.Entity.Order;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.OrderResponse;
import com.example.cosmetic_springboot_api.Response.PaymentResponse;
import com.example.cosmetic_springboot_api.Response.UsersResponse;
import com.example.cosmetic_springboot_api.Service.ICartService;
import com.example.cosmetic_springboot_api.Service.IOrderService;
import com.example.cosmetic_springboot_api.Service.IPaymentService;
import com.example.cosmetic_springboot_api.Service.IUsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;
    private final IOrderService orderService;
    private final ICartService cartService;
    private final IUsersService usersService;
    private final ModelMapper modelMapper;

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentDto paymentDto, BindingResult bindingResult) throws UnsupportedEncodingException {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(paymentService.createPayment(paymentDto.getAmount()));
    }

    @GetMapping("/pay_success")
    public ResponseEntity<OrderResponse> paySuccess(@RequestParam int orderId){
        OrderResponse order = orderService.getOrderById(orderId);
        UsersResponse users = usersService.getUserById(order.getCart().getUsers().getId());
        Users user = modelMapper.map(users, Users.class);
        System.out.println(user.getEmail());
        cartService.addCart(user);
        return ResponseEntity.ok(orderService.updateStatusOrderById(orderId));
    }
}
