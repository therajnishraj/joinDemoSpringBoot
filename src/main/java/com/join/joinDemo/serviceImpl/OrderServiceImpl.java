package com.join.joinDemo.serviceImpl;

import com.join.joinDemo.Model.Order;
import com.join.joinDemo.repo.OrderRepo;
import com.join.joinDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        return order.get();
    }

    @Override
    public String saveOrder(Order order) {
        orderRepo.save(order);
        return "Order saved successfully..!";
    }

    @Override
    public String deleteOrder(Order order) {
        orderRepo.delete(order);
        return "Order deleted successfully..!";
    }
}
