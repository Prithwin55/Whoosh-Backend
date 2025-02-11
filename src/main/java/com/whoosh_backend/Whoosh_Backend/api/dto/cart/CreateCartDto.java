package com.whoosh_backend.Whoosh_Backend.api.dto.cart;

import com.whoosh_backend.Whoosh_Backend.api.dto.CartItem.CartItemDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCartDto {
    private Integer customerId;
}