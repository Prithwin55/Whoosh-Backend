package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> getAllOrderItems();
    OrderItemDto getOrderItemById(Long id) throws ResourceNotFoundException;
    OrderItemDto createOrderItem(OrderItemDto orderItemDto);
    OrderItemDto updateOrderItem(Long id, OrderItemDto orderItemDto) throws ResourceNotFoundException;
    void deleteOrderItem(Long id);
}