package com.ecommerce.shopping.service;

import com.ecommerce.shopping.entity.Orders;
import com.ecommerce.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Transactional
    public boolean saveOrder(Orders orders){
        Orders o =  orderRepository.save(orders);
        return o!= null;
    }
    @Transactional(readOnly = true)
    public Orders findOrder(int orderId){
        Optional<Orders> op = orderRepository.findById(orderId);
        if(op.isPresent())
            return op.get();
        throw new RuntimeException("order doesn't exist");
    }
}
