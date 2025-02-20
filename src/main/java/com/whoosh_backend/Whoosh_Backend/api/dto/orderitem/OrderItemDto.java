package com.whoosh_backend.Whoosh_Backend.api.dto.orderitem;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {
    private Long id;
    private ItemDto item;
    private Integer quantity;
    private Double totalPrice;
}