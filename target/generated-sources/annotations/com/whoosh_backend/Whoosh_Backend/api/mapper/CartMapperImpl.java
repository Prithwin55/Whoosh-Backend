package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.CartItem.CartItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.cart.CartDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.cart.Cart;
import com.whoosh_backend.Whoosh_Backend.data.entity.cartitem.CartItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T14:33:02+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class CartMapperImpl implements CartMapper {

    @Override
    public CartDto toCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cart.getId() );
        cartDto.setCustomer( userToUserDto( cart.getCustomer() ) );
        cartDto.setCartItems( cartItemListToCartItemDtoList( cart.getCartItems() ) );

        return cartDto;
    }

    @Override
    public Cart toCart(CartDto cartDTO) {
        if ( cartDTO == null ) {
            return null;
        }

        Cart cart = new Cart();

        cart.setId( cartDTO.getId() );
        cart.setCustomer( userDtoToUser( cartDTO.getCustomer() ) );
        cart.setCartItems( cartItemDtoListToCartItemList( cartDTO.getCartItems() ) );

        return cart;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setPassword( user.getPassword() );
        userDto.setEmail( user.getEmail() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        if ( user.getRole() != null ) {
            userDto.setRole( user.getRole().name() );
        }
        userDto.setAddress( user.getAddress() );

        return userDto;
    }

    protected ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setId( item.getId() );
        itemDto.setPrice( item.getPrice() );
        itemDto.setItemName( item.getItemName() );

        return itemDto;
    }

    protected CartItemDto cartItemToCartItemDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemDto cartItemDto = new CartItemDto();

        cartItemDto.setId( cartItem.getId() );
        cartItemDto.setItem( itemToItemDto( cartItem.getItem() ) );
        cartItemDto.setQuantity( cartItem.getQuantity() );
        cartItemDto.setTotalPrice( cartItem.getTotalPrice() );

        return cartItemDto;
    }

    protected List<CartItemDto> cartItemListToCartItemDtoList(List<CartItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItemDto> list1 = new ArrayList<CartItemDto>( list.size() );
        for ( CartItem cartItem : list ) {
            list1.add( cartItemToCartItemDto( cartItem ) );
        }

        return list1;
    }

    protected User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setUsername( userDto.getUsername() );
        user.setPassword( userDto.getPassword() );
        user.setEmail( userDto.getEmail() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        if ( userDto.getRole() != null ) {
            user.setRole( Enum.valueOf( Role.class, userDto.getRole() ) );
        }
        user.setAddress( userDto.getAddress() );

        return user;
    }

    protected Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDto.getId() );
        item.setPrice( itemDto.getPrice() );
        item.setItemName( itemDto.getItemName() );

        return item;
    }

    protected CartItem cartItemDtoToCartItem(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItem cartItem = new CartItem();

        cartItem.setId( cartItemDto.getId() );
        cartItem.setItem( itemDtoToItem( cartItemDto.getItem() ) );
        cartItem.setQuantity( cartItemDto.getQuantity() );
        cartItem.setTotalPrice( cartItemDto.getTotalPrice() );

        return cartItem;
    }

    protected List<CartItem> cartItemDtoListToCartItemList(List<CartItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CartItem> list1 = new ArrayList<CartItem>( list.size() );
        for ( CartItemDto cartItemDto : list ) {
            list1.add( cartItemDtoToCartItem( cartItemDto ) );
        }

        return list1;
    }
}
