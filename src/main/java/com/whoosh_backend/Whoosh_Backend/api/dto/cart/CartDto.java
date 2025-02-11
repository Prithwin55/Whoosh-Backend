package com.whoosh_backend.Whoosh_Backend.api.dto.cart;

import com.whoosh_backend.Whoosh_Backend.api.dto.CartItem.CartItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private UserDto customer;
    private List<CartItemDto> cartItems;
}