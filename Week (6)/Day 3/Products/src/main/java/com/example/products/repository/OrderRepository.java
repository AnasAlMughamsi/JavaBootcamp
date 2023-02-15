package com.example.products.repository;

import com.example.products.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findOrderById(Integer id);
    Order findOrderByProductId(Integer id);
}
