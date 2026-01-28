package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cdac.modelmvc.Order;
import com.cdac.repository.OrderRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private OrderRepository orderRepository;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping("/placeOrder")
    public Order placeOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
