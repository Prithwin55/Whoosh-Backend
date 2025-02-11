package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CartDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.cart.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    CartDto toCartDto(Cart cart);
    Cart toCart(CartDto cartDTO);
}