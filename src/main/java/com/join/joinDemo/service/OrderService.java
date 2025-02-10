package com.join.joinDemo.service;

import com.join.joinDemo.Model.Order;

import java.util.List;

public interface OrderService {

     List<Order> getAllOrders();
     Order getOrderById(Long id);
     String saveOrder(Order order);
     String deleteOrder(Order order);
}
