package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Order;
import com.example.cosmetic_springboot_api.Response.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse createOrder(Cart cart);
    OrderResponse updateOrder(int id, Cart cart);

    OrderResponse updateStatusOrderById(int orderId);

    List<OrderResponse> getAllOrderByUserId(int userId);
}
