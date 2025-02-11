package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CreateCartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemQuantityDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.CartMapper;
import com.whoosh_backend.Whoosh_Backend.api.mapper.ItemMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.cart.Cart;
import com.whoosh_backend.Whoosh_Backend.data.entity.cartitem.CartItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.CartItemRepository;
import com.whoosh_backend.Whoosh_Backend.data.repository.CartRepository;


import com.whoosh_backend.Whoosh_Backend.data.repository.ItemRepository;
import com.whoosh_backend.Whoosh_Backend.data.repository.UserRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    private UserRepository userRepository;
    private ItemRepository itemRepository;
    private CartItemRepository cartItemRepository;

    @Override
    public CartDto createCart(CreateCartDto createCartDto) {
        User user=userRepository
                .findById(createCartDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = new Cart();
        cart.setCustomer(user);

        cart = cartRepository.save(cart);
        return CartMapper.INSTANCE.toCartDto(cart);
    }

    @Override
    public CartDto getCartByUser(Long userId) {
        Cart cart = cartRepository.findByCustomerId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return CartMapper.INSTANCE.toCartDto(cart);
    }

    @Override
    public List<CartDto> getAllCarts() {
        return cartRepository.findAll().stream()
                .map(CartMapper.INSTANCE::toCartDto)
                .collect(Collectors.toList());
    }

    @Override
    public CartDto updateCartItems(Long cartId, ItemDto itemDto,Integer quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        Item item= ItemMapper.INSTANCE.toItem(itemDto);

        Item dbItem=itemRepository.findById(itemDto.getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        CartItem cartItem=new CartItem();
        cartItem.setCart(cart);
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(itemDto.getPrice()*quantity);
        cartItem.setItem(item);
        cart.getCartItems().add(cartItem);
        cart = cartRepository.save(cart);
        return CartMapper.INSTANCE.toCartDto(cart);
    }

    @Override
    public void deleteCartItem(Long itemId,Long cartId) throws ResourceNotFoundException {

       Cart cart= cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

       CartItem cartItem= cartItemRepository.findByCartIdAndItemId(cartId,itemId).orElseThrow(() -> new ResourceNotFoundException("Cart Item not found"));

        cart.getCartItems().remove(cartItem);
        cartRepository.save(cart);

    }


    @Override
    public CartDto addItemsToCart(Long cartId, List<ItemQuantityDto> items) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        //check if item already exist in any of the cart item
        for (ItemQuantityDto itemDto : items) {
            CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cartId, itemDto.getId()).orElse(null);
            if (cartItem != null) {
                cartItem.setQuantity(itemDto.getQuantity());
                cartItem.setTotalPrice( itemDto.getPrice() * itemDto.getQuantity());
                cartItemRepository.save(cartItem);
                return CartMapper.INSTANCE.toCartDto(cart);
            }
        }

        for (ItemQuantityDto itemDto : items) {
            Item item = itemRepository.findById(itemDto.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Item not found"));

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setItem(item);
            cartItem.setQuantity(itemDto.getQuantity());
            cartItem.setTotalPrice(itemDto.getPrice() * itemDto.getQuantity());

            cart.getCartItems().add(cartItem);
        }

        cart = cartRepository.save(cart);
        return CartMapper.INSTANCE.toCartDto(cart);
    }
}