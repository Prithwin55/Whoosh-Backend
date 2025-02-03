package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
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
    date = "2025-02-01T22:58:20+0530",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        Long id = orderShopId( order );
        if ( id != null ) {
            orderDto.setShopId( id );
        }
        orderDto.setId( order.getId() );
        orderDto.setCustomer( userToUserDto( order.getCustomer() ) );
        orderDto.setDeliveryPerson( userToUserDto( order.getDeliveryPerson() ) );
        orderDto.setStatus( order.getStatus() );
        orderDto.setTotalPrice( order.getTotalPrice() );
        orderDto.setPaymentStatus( order.getPaymentStatus() );
        orderDto.setOrderItems( orderItemListToOrderItemDtoList( order.getOrderItems() ) );

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setShop( orderDtoToLaundryShop( orderDto ) );
        order.setId( orderDto.getId() );
        order.setCustomer( userDtoToUser( orderDto.getCustomer() ) );
        order.setDeliveryPerson( userDtoToUser( orderDto.getDeliveryPerson() ) );
        order.setStatus( orderDto.getStatus() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setPaymentStatus( orderDto.getPaymentStatus() );
        order.setOrderItems( orderItemDtoListToOrderItemList( orderDto.getOrderItems() ) );

        return order;
    }

    @Override
    public OrderBasicDto toBasicDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderBasicDto orderBasicDto = new OrderBasicDto();

        orderBasicDto.setShopName( orderShopShopName( order ) );
        orderBasicDto.setId( order.getId() );
        orderBasicDto.setCustomer( userToUserDto( order.getCustomer() ) );
        orderBasicDto.setDeliveryPerson( userToUserDto( order.getDeliveryPerson() ) );
        orderBasicDto.setStatus( order.getStatus() );
        orderBasicDto.setTotalPrice( order.getTotalPrice() );
        orderBasicDto.setPaymentStatus( order.getPaymentStatus() );
        orderBasicDto.setOrderItems( orderItemListToOrderItemDtoList( order.getOrderItems() ) );

        return orderBasicDto;
    }

    private Long orderShopId(Order order) {
        LaundryShop shop = order.getShop();
        if ( shop == null ) {
            return null;
        }
        return shop.getId();
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

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDto orderItemDto = new OrderItemDto();

        orderItemDto.setId( orderItem.getId() );
        orderItemDto.setOrder( toDto( orderItem.getOrder() ) );
        orderItemDto.setItemType( orderItem.getItemType() );
        orderItemDto.setQuantity( orderItem.getQuantity() );
        orderItemDto.setPricePerItem( orderItem.getPricePerItem() );

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

    protected LaundryShop orderDtoToLaundryShop(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        LaundryShop laundryShop = new LaundryShop();

        laundryShop.setId( orderDto.getShopId() );

        return laundryShop;
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

    protected OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( orderItemDto.getId() );
        orderItem.setOrder( toEntity( orderItemDto.getOrder() ) );
        orderItem.setItemType( orderItemDto.getItemType() );
        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setPricePerItem( orderItemDto.getPricePerItem() );

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

    private String orderShopShopName(Order order) {
        LaundryShop shop = order.getShop();
        if ( shop == null ) {
            return null;
        }
        return shop.getShopName();
    }
}
