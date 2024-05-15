package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.PaymentDto;
import com.example.cosmetic_springboot_api.Response.PaymentResponse;
import com.example.cosmetic_springboot_api.Service.IPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


@RestController
@RequestMapping("api/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResponse> createPayment(@Valid @RequestBody PaymentDto paymentDto, BindingResult bindingResult) throws UnsupportedEncodingException {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(paymentService.createPayment(paymentDto.getAmount()));
    }

    @GetMapping("/pay_success")
    public String paySuccess(){
        return "Thanh toán thành công";
    }
}
