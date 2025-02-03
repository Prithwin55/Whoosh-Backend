package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.LaundryShopMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.OrderItemMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.OrderMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.UserMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.OrderRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDto createOrder(OrderDto order) throws ResourceAlreadyExistException {
        Order savedOrder = orderRepository.save(OrderMapper.INSTANCE.toEntity(order));
        return OrderMapper.INSTANCE.toDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) throws ResourceNotFoundException {
        return orderRepository.findById(id)
                .map(OrderMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto order) throws ResourceNotFoundException {
        return orderRepository.findById(id).map(existingOrder ->
        {if (order.getCustomer() != null) {
            existingOrder.setCustomer(UserMapper.INSTANCE.toEntity(order.getCustomer()));
        }
        if (order.getShopId()!=0) {
            LaundryShop shop = existingOrder.getShop();
            shop.setId(order.getShopId());
            existingOrder.setShop(shop);
        }
        if (order.getDeliveryPerson() != null) {
            existingOrder.setDeliveryPerson(UserMapper.INSTANCE.toEntity(order.getDeliveryPerson()));
        }
        if (order.getStatus() != null) {
            existingOrder.setStatus(order.getStatus());
        }
        if (order.getTotalPrice() != null) {
            existingOrder.setTotalPrice(order.getTotalPrice());
        }
        if (order.getPaymentStatus() != null) {
            existingOrder.setPaymentStatus(order.getPaymentStatus());
        }
        if (order.getOrderItems() != null) {
            existingOrder.setOrderItems(order.getOrderItems().stream()
                    .map(OrderItemMapper.INSTANCE::toEntity)
                    .collect(Collectors.toList()));
        }
        Order updatedOrder = orderRepository.save(existingOrder);
        return OrderMapper.INSTANCE.toDto(updatedOrder);
        }).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }
    @Override
    public String deleteOrder(Long id) throws ResourceNotFoundException {
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order not found");
        }
        orderRepository.deleteById(id);
        return "Order deleted";
    }
}