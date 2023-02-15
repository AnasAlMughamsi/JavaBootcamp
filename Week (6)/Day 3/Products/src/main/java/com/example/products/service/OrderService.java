package com.example.products.service;


import com.example.products.api.ApiException;
import com.example.products.model.MyUser;
import com.example.products.model.Order;
import com.example.products.model.Product;
import com.example.products.repository.MyUserRepository;
import com.example.products.repository.OrderRepository;
import com.example.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final MyUserRepository myUserRepository;


    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        Order order = orderRepository.findOrderById(id);
        if(order == null) {
            throw new ApiException("order not found!");
        }
        return order;
    }

    public void addOrder(Order order, Integer product_id, MyUser myUser) {
        Product product = productRepository.findProductById(product_id);
        if(product == null) {
            throw new ApiException("Can't add order, no product found!");
        }
        order.setStatus("new");
        double totalPrice = order.getQuantity() * product.getPrice();
        order.setTotalPrice(totalPrice);
//        order.setCustomer(myUser);
        orderRepository.save(order);
    }

    public void updateOrder(Integer id, Order updateOrder, MyUser myUser) {
        Order order = orderRepository.findOrderById(id);
        if(order == null) {
            throw new ApiException("order not found!");
        }

        MyUser myUserOrder = order.getCustomer();
        if(myUserOrder.getId() != myUser.getId()) {
            throw new ApiException("You cant edit this order");
        }
//        order.setQuantity(updateOrder.getQuantity());
        updateOrder.setId(id);
        orderRepository.save(updateOrder);
    }

    public void deleteOrder(Integer id) {
        Order order = orderRepository.findOrderById(id);
        if(order == null) {
            throw new ApiException("order not found!");
        }
        if(order.getStatus().equals("completed") || order.getStatus().equals("inProgress")) {
            throw new ApiException("Order is completed or in progress, you can't delete it");
        }

        orderRepository.delete(order);
    }

    public void assignOrderToCustomer(MyUser customer, Integer customer_id, Integer order_Id) {
        Order order = orderRepository.findOrderById(order_Id);
        MyUser myUser = myUserRepository.findMyUserById(customer_id);
        if(order == null || myUser == null) {
            throw new ApiException("order or customer not found!");
        }

        myUser.getOrderList().add(order);
        order.setCustomer(myUser);
        myUserRepository.save(myUser);
    }
    public void changeStatus(Integer order_Id, String newStatus, MyUser admin) {
        Order order = orderRepository.findOrderById(order_Id);
        if(order == null) {
            throw new ApiException("order not found!");
        }

        order.setStatus(newStatus);
        orderRepository.save(order);
    }
}
