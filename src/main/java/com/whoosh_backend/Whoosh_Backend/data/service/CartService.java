package com.whoosh_backend.Whoosh_Backend.data.service;
import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CreateCartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemQuantityDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.cart.Cart;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface CartService {
    CartDto createCart(CreateCartDto cartDTO);
    CartDto getCartByUser(Long userId);
    List<CartDto> getAllCarts();
    CartDto updateCartItems(Long cartId, ItemDto itemDto,Integer quantity);
    void deleteCartItem(Long itemId,Long cartId) throws ResourceNotFoundException;

    CartDto addItemsToCart(Long cartId, List<ItemQuantityDto> items) throws ResourceNotFoundException;
}