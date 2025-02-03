package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceAlreadyExistException;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto order) throws ResourceAlreadyExistException;
    OrderDto getOrderById(Long id) throws ResourceNotFoundException;
    List<OrderDto> getAllOrders();
    OrderDto updateOrder(Long id, OrderDto order) throws ResourceNotFoundException;
    String deleteOrder(Long id) throws ResourceNotFoundException;
}