package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.payment.PaymentDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.payment.Payment;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import com.whoosh_backend.Whoosh_Backend.data.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T18:12:24+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentDto toDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId( payment.getId() );
        paymentDto.setOrder( orderToOrderDto( payment.getOrder() ) );
        paymentDto.setPaymentMode( payment.getPaymentMode() );
        paymentDto.setTransactionId( payment.getTransactionId() );
        paymentDto.setStatus( payment.getStatus() );

        return paymentDto;
    }

    @Override
    public Payment toEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentDto.getId() );
        payment.setOrder( orderDtoToOrder( paymentDto.getOrder() ) );
        payment.setPaymentMode( paymentDto.getPaymentMode() );
        payment.setTransactionId( paymentDto.getTransactionId() );
        payment.setStatus( paymentDto.getStatus() );

        return payment;
    }

    @Override
    public void updateEntityFromDto(PaymentDto paymentDto, Payment payment) {
        if ( paymentDto == null ) {
            return;
        }

        payment.setId( paymentDto.getId() );
        if ( paymentDto.getOrder() != null ) {
            if ( payment.getOrder() == null ) {
                payment.setOrder( new Order() );
            }
            orderDtoToOrder1( paymentDto.getOrder(), payment.getOrder() );
        }
        else {
            payment.setOrder( null );
        }
        payment.setPaymentMode( paymentDto.getPaymentMode() );
        payment.setTransactionId( paymentDto.getTransactionId() );
        payment.setStatus( paymentDto.getStatus() );
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

    protected void orderDtoToOrder1(OrderDto orderDto, Order mappingTarget) {
        if ( orderDto == null ) {
            return;
        }

        mappingTarget.setId( orderDto.getId() );
        if ( orderDto.getCustomer() != null ) {
            if ( mappingTarget.getCustomer() == null ) {
                mappingTarget.setCustomer( new User() );
            }
            userDtoToUser1( orderDto.getCustomer(), mappingTarget.getCustomer() );
        }
        else {
            mappingTarget.setCustomer( null );
        }
        mappingTarget.setStatus( orderDto.getStatus() );
        mappingTarget.setTotalPrice( orderDto.getTotalPrice() );
        mappingTarget.setPaymentStatus( orderDto.getPaymentStatus() );
        if ( mappingTarget.getOrderItems() != null ) {
            List<OrderItem> list = orderItemDtoListToOrderItemList( orderDto.getOrderItems() );
            if ( list != null ) {
                mappingTarget.getOrderItems().clear();
                mappingTarget.getOrderItems().addAll( list );
            }
            else {
                mappingTarget.setOrderItems( null );
            }
        }
        else {
            List<OrderItem> list = orderItemDtoListToOrderItemList( orderDto.getOrderItems() );
            if ( list != null ) {
                mappingTarget.setOrderItems( list );
            }
        }
    }
}
