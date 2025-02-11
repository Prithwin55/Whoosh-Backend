package com.whoosh_backend.Whoosh_Backend.api.dto.CartItem;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private ItemDto item;
    private Integer quantity;
    private Double totalPrice;
}