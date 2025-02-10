package com.join.joinDemo.controller;

import com.join.joinDemo.Model.Order;
import com.join.joinDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> allOrders = orderService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }
    @GetMapping("/findOrderById/{id}")
    public ResponseEntity<Order> findOrderById(@PathVariable("id") long id){
        Order orderById = orderService.getOrderById(id);
        return new ResponseEntity<>(orderById,HttpStatus.OK);
    }
    @PostMapping("/saveOrder")
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        String msg = orderService.saveOrder(order);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
    @DeleteMapping("/deleteOrder")
    public ResponseEntity<String> deleteOrder(@RequestBody Order order){
        String msg = orderService.deleteOrder(order);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
