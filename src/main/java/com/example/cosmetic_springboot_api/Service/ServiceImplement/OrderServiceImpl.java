package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.OrderDto;
import com.example.cosmetic_springboot_api.Entity.*;
import com.example.cosmetic_springboot_api.Repository.*;
import com.example.cosmetic_springboot_api.Response.OrderResponse;
import com.example.cosmetic_springboot_api.Service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final CartProductRepository cartProductRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponse createOrder(OrderDto orderDto) {
        Cart cart = cartRepository.findById(orderDto.getCart().getId()).orElse(null);
        if(cart == null){
            return null;
        }
        Order order = new Order();
        order.setCart(cart);
        order.setAddress(orderDto.getAddress());
        order.setOrderDate(LocalDateTime.now());
        order.setPhone(orderDto.getPhone());
        order.setTotal(orderDto.getTotal());
        orderRepository.save(order);
        return modelMapper.map(order, OrderResponse.class);
    }

    @Override
    public OrderResponse updateOrder(int id, OrderDto orderDto) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order == null){
            return null;
        }
        order.setCart(orderDto.getCart());
        order.setAddress(orderDto.getAddress());
        orderRepository.save(order);
        return modelMapper.map(order, OrderResponse.class);
    }

    @Override
    public OrderResponse updateStatusOrderById(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order == null){
            return null;
        }
        order.setStatus(true);
        orderRepository.save(order);
        Cart cart = order.getCart();
        cart.setStatus(true);
        cartRepository.save(cart);
        List<Cart_product> cart_products = cartProductRepository.findAllByCart(cart);
        for(Cart_product cart_product: cart_products){
            Product product = cart_product.getProduct();
            product.setStock(product.getStock()-cart_product.getQuantity());
            productRepository.save(product);
        }
        return modelMapper.map(order, OrderResponse.class);
    }

    @Override
    public List<OrderResponse> getAllOrderByUserId(int userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        if(user == null){
            return null;
        }
        List<Order> orders = orderRepository.findAllByUsers(user);
        return orders.stream().map(order -> modelMapper.map(order, OrderResponse.class)).toList();
    }

    @Override
    public OrderResponse getOrderById(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order == null){
            return null;
        }
        return modelMapper.map(order, OrderResponse.class);
    }
}
