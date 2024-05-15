package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Response.PaymentResponse;

import java.io.UnsupportedEncodingException;

public interface IPaymentService {
    PaymentResponse createPayment(int amount) throws UnsupportedEncodingException;
}
