package com.ecommerce.shopping.controller;


import com.ecommerce.shopping.entity.Orders;
import com.ecommerce.shopping.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(consumes = "application/json")
    public HttpStatus saveOrder(@RequestBody Orders orders){
        if(orderService.saveOrder(orders))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;

    }
    @GetMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity<Orders> getOrderInfo(@PathVariable int orderId){
       Orders o = orderService.findOrder(orderId);
        return new ResponseEntity<Orders>(o, HttpStatus.OK);
    }
}
