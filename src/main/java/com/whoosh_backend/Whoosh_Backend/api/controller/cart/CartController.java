package com.whoosh_backend.Whoosh_Backend.api.controller.cart;

import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CreateCartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemQuantityDto;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody CreateCartDto createCartDto) {
        return ResponseEntity.ok(cartService.createCart(createCartDto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CartDto> getCartByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getCartByUser(userId));
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllCarts());
    }

    @PutMapping("/{cartId}/{quantity}")
    public ResponseEntity<CartDto> updateCartItems(@PathVariable Long cartId, @RequestBody ItemDto itemDto,@PathVariable Integer quantity) {
        return ResponseEntity.ok(cartService.updateCartItems(cartId, itemDto,quantity));
    }

    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartDto> addItemsToCart(@PathVariable Long cartId, @RequestBody List<ItemQuantityDto> items) throws ResourceNotFoundException {
        return ResponseEntity.ok(cartService.addItemsToCart(cartId, items));
    }

    @DeleteMapping("/{itemId}/{cartId}")
    public ResponseEntity<String> deleteCartItems(@PathVariable Long itemId,@PathVariable Long cartId) throws ResourceNotFoundException {
        cartService.deleteCartItem(itemId,cartId);
        return ResponseEntity.ok("Deleted Succesfully");
    }
}