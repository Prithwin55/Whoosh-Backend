package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.delivery.DeliveryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.delivery.Delivery;
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
    date = "2025-01-29T22:11:09+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryDto toDto(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryDto deliveryDto = new DeliveryDto();

        deliveryDto.setId( delivery.getId() );
        deliveryDto.setOrder( orderToOrderDto( delivery.getOrder() ) );
        deliveryDto.setDeliveryPerson( userToUserDto( delivery.getDeliveryPerson() ) );
        deliveryDto.setPickupTime( delivery.getPickupTime() );
        deliveryDto.setDropTime( delivery.getDropTime() );
        deliveryDto.setStatus( delivery.getStatus() );

        return deliveryDto;
    }

    @Override
    public Delivery toEntity(DeliveryDto deliveryDto) {
        if ( deliveryDto == null ) {
            return null;
        }

        Delivery delivery = new Delivery();

        delivery.setId( deliveryDto.getId() );
        delivery.setOrder( orderDtoToOrder( deliveryDto.getOrder() ) );
        delivery.setDeliveryPerson( userDtoToUser( deliveryDto.getDeliveryPerson() ) );
        delivery.setPickupTime( deliveryDto.getPickupTime() );
        delivery.setDropTime( deliveryDto.getDropTime() );
        delivery.setStatus( deliveryDto.getStatus() );

        return delivery;
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

    protected LaundryShopDto laundryShopToLaundryShopDto(LaundryShop laundryShop) {
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

    protected OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
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
        orderDto.setShop( laundryShopToLaundryShopDto( order.getShop() ) );
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

    protected LaundryShop laundryShopDtoToLaundryShop(LaundryShopDto laundryShopDto) {
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

    protected OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto) {
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
        order.setShop( laundryShopDtoToLaundryShop( orderDto.getShop() ) );
        order.setDeliveryPerson( userDtoToUser( orderDto.getDeliveryPerson() ) );
        order.setStatus( orderDto.getStatus() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setPaymentStatus( orderDto.getPaymentStatus() );
        order.setOrderItems( orderItemDtoListToOrderItemList( orderDto.getOrderItems() ) );

        return order;
    }
}
