package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-20T11:29:10+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class LaundryShopMapperImpl implements LaundryShopMapper {

    @Override
    public LaundryShopDto toDto(LaundryShop laundryShop) {
        if ( laundryShop == null ) {
            return null;
        }

        LaundryShopDto laundryShopDto = new LaundryShopDto();

        laundryShopDto.setId( laundryShop.getId() );
        laundryShopDto.setShopName( laundryShop.getShopName() );
        laundryShopDto.setLocation( laundryShop.getLocation() );
        laundryShopDto.setAddress( laundryShop.getAddress() );
        laundryShopDto.setStatus( laundryShop.getStatus() );
        laundryShopDto.setOwner( userToUserDto( laundryShop.getOwner() ) );
        laundryShopDto.setOrders( orderListToOrderDtoList( laundryShop.getOrders() ) );

        return laundryShopDto;
    }

    @Override
    public LaundryShop toEntity(LaundryShopDto laundryShopDto) {
        if ( laundryShopDto == null ) {
            return null;
        }

        LaundryShop laundryShop = new LaundryShop();

        laundryShop.setId( laundryShopDto.getId() );
        laundryShop.setShopName( laundryShopDto.getShopName() );
        laundryShop.setLocation( laundryShopDto.getLocation() );
        laundryShop.setAddress( laundryShopDto.getAddress() );
        laundryShop.setStatus( laundryShopDto.getStatus() );
        laundryShop.setOwner( userDtoToUser( laundryShopDto.getOwner() ) );
        laundryShop.setOrders( orderDtoListToOrderList( laundryShopDto.getOrders() ) );

        return laundryShop;
    }

    @Override
    public LaundryShopBasicDto toBasicDto(LaundryShop laundryShop) {
        if ( laundryShop == null ) {
            return null;
        }

        LaundryShopBasicDto laundryShopBasicDto = new LaundryShopBasicDto();

        laundryShopBasicDto.setId( laundryShop.getId() );
        laundryShopBasicDto.setShopName( laundryShop.getShopName() );
        laundryShopBasicDto.setLocation( laundryShop.getLocation() );
        laundryShopBasicDto.setAddress( laundryShop.getAddress() );
        laundryShopBasicDto.setStatus( laundryShop.getStatus() );
        laundryShopBasicDto.setOwner( userToUserDto( laundryShop.getOwner() ) );

        return laundryShopBasicDto;
    }

    @Override
    public void updateEntityFromDto(LaundryShopDto laundryShopDto, LaundryShop laundryShop) {
        if ( laundryShopDto == null ) {
            return;
        }

        laundryShop.setId( laundryShopDto.getId() );
        laundryShop.setShopName( laundryShopDto.getShopName() );
        laundryShop.setLocation( laundryShopDto.getLocation() );
        laundryShop.setAddress( laundryShopDto.getAddress() );
        laundryShop.setStatus( laundryShopDto.getStatus() );
        if ( laundryShopDto.getOwner() != null ) {
            if ( laundryShop.getOwner() == null ) {
                laundryShop.setOwner( new User() );
            }
            userDtoToUser1( laundryShopDto.getOwner(), laundryShop.getOwner() );
        }
        else {
            laundryShop.setOwner( null );
        }
        if ( laundryShop.getOrders() != null ) {
            List<Order> list = orderDtoListToOrderList( laundryShopDto.getOrders() );
            if ( list != null ) {
                laundryShop.getOrders().clear();
                laundryShop.getOrders().addAll( list );
            }
            else {
                laundryShop.setOrders( null );
            }
        }
        else {
            List<Order> list = orderDtoListToOrderList( laundryShopDto.getOrders() );
            if ( list != null ) {
                laundryShop.setOrders( list );
            }
        }
    }

    @Override
    public LaundryShopResponse toResponse(LaundryShop laundryShop) {
        if ( laundryShop == null ) {
            return null;
        }

        LaundryShopResponse laundryShopResponse = new LaundryShopResponse();

        laundryShopResponse.setOrderIds( mapOrderIds( laundryShop.getOrders() ) );
        laundryShopResponse.setServiceCategories( mapServiceCategories( laundryShop.getServiceCategories() ) );
        laundryShopResponse.setId( laundryShop.getId() );
        laundryShopResponse.setShopName( laundryShop.getShopName() );
        laundryShopResponse.setLocation( laundryShop.getLocation() );
        laundryShopResponse.setAddress( laundryShop.getAddress() );
        laundryShopResponse.setStatus( laundryShop.getStatus() );
        laundryShopResponse.setOwner( userToUserDto( laundryShop.getOwner() ) );

        return laundryShopResponse;
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

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId( orderItem.getId() );
        orderItemDto.setItem( itemToItemDto( orderItem.getItem() ) );
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setTotalPrice( orderItem.getTotalPrice() );

        return orderItemDto;
    }

    protected List<OrderItemDto> orderItemListToOrderItemDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDto> list1 = new ArrayList<OrderItemDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( orderItemToOrderItemDto( orderItem ) );
        }

        return list1;
    }

    protected OrderDto orderToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setCustomer( userToUserDto( order.getCustomer() ) );
        orderDto.setStatus( order.getStatus() );
        orderDto.setTotalPrice( order.getTotalPrice() );
        orderDto.setPaymentStatus( order.getPaymentStatus() );
        orderDto.setOrderItems( orderItemListToOrderItemDtoList( order.getOrderItems() ) );

        return orderDto;
    }

    protected List<OrderDto> orderListToOrderDtoList(List<Order> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto> list1 = new ArrayList<OrderDto>( list.size() );
        for ( Order order : list ) {
            list1.add( orderToOrderDto( order ) );
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

    protected OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( orderItemDto.getId() );
        orderItem.setItem( itemDtoToItem( orderItemDto.getItem() ) );
        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setTotalPrice( orderItemDto.getTotalPrice() );

        return orderItem;
    }

    protected List<OrderItem> orderItemDtoListToOrderItemList(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemDto orderItemDto : list ) {
            list1.add( orderItemDtoToOrderItem( orderItemDto ) );
        }

        return list1;
    }

    protected Order orderDtoToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setCustomer( userDtoToUser( orderDto.getCustomer() ) );
        order.setStatus( orderDto.getStatus() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setPaymentStatus( orderDto.getPaymentStatus() );
        order.setOrderItems( orderItemDtoListToOrderItemList( orderDto.getOrderItems() ) );

        return order;
    }

    protected List<Order> orderDtoListToOrderList(List<OrderDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Order> list1 = new ArrayList<Order>( list.size() );
        for ( OrderDto orderDto : list ) {
            list1.add( orderDtoToOrder( orderDto ) );
        }

        return list1;
    }

    protected void userDtoToUser1(UserDto userDto, User mappingTarget) {
        if ( userDto == null ) {
            return;
        }

        mappingTarget.setId( userDto.getId() );
        mappingTarget.setUsername( userDto.getUsername() );
        mappingTarget.setPassword( userDto.getPassword() );
        mappingTarget.setEmail( userDto.getEmail() );
        mappingTarget.setPhoneNumber( userDto.getPhoneNumber() );
        if ( userDto.getRole() != null ) {
            mappingTarget.setRole( Enum.valueOf( Role.class, userDto.getRole() ) );
        }
        else {
            mappingTarget.setRole( null );
        }
        mappingTarget.setAddress( userDto.getAddress() );
    }
}
