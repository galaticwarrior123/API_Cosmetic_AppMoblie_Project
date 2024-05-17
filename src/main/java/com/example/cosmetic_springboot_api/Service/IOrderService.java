package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.OrderDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Order;
import com.example.cosmetic_springboot_api.Response.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse createOrder(OrderDto orderDto);
    OrderResponse updateOrder(int id, OrderDto orderDto);

    OrderResponse updateStatusOrderById(int orderId);

    List<OrderResponse> getAllOrderByUserId(int userId);

    OrderResponse getOrderById(int orderId);
}
