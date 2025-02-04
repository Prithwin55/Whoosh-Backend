package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.OrderItemMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.OrderItemRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(OrderItemMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto getOrderItemById(Long id) throws ResourceNotFoundException {
        return orderItemRepository.findById(id)
                .map(OrderItemMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found"));
    }

    @Override
    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = OrderItemMapper.INSTANCE.toEntity(orderItemDto);
        orderItem = orderItemRepository.save(orderItem);
        return OrderItemMapper.INSTANCE.toDto(orderItem);
    }

    @Override
    public OrderItemDto updateOrderItem(Long id, OrderItemDto orderItemDto) throws ResourceNotFoundException {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrderItem not found"));
//        OrderItemMapper.INSTANCE.updateEntityFromDto(orderItemDto, existingOrderItem);
        existingOrderItem = orderItemRepository.save(existingOrderItem);
        return OrderItemMapper.INSTANCE.toDto(existingOrderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}