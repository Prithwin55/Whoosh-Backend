package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-01T22:58:20+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDto toDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId( orderItem.getId() );
        orderItemDto.setOrder( orderToOrderDto( orderItem.getOrder() ) );
        orderItemDto.setItemType( orderItem.getItemType() );
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setPricePerItem( orderItem.getPricePerItem() );

        return orderItemDto;
    }

    @Override
    public OrderItem toEntity(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( orderItemDto.getId() );
        orderItem.setOrder( orderDtoToOrder( orderItemDto.getOrder() ) );
        orderItem.setItemType( orderItemDto.getItemType() );
        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setPricePerItem( orderItemDto.getPricePerItem() );

        return orderItem;
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

    protected List<OrderItemDto> orderItemListToOrderItemDtoList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItemDto> list1 = new ArrayList<OrderItemDto>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( toDto( orderItem ) );
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
        orderDto.setDeliveryPerson( userToUserDto( order.getDeliveryPerson() ) );
        orderDto.setStatus( order.getStatus() );
        orderDto.setTotalPrice( order.getTotalPrice() );
        orderDto.setPaymentStatus( order.getPaymentStatus() );
        orderDto.setOrderItems( orderItemListToOrderItemDtoList( order.getOrderItems() ) );

        return orderDto;
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

    protected List<OrderItem> orderItemDtoListToOrderItemList(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemDto orderItemDto : list ) {
            list1.add( toEntity( orderItemDto ) );
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
        order.setDeliveryPerson( userDtoToUser( orderDto.getDeliveryPerson() ) );
        order.setStatus( orderDto.getStatus() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setPaymentStatus( orderDto.getPaymentStatus() );
        order.setOrderItems( orderItemDtoListToOrderItemList( orderDto.getOrderItems() ) );

        return order;
    }
}
