package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
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
    date = "2025-02-12T18:12:24+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
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
        orderBasicDto.setStatus( order.getStatus() );
        orderBasicDto.setTotalPrice( order.getTotalPrice() );
        orderBasicDto.setPaymentStatus( order.getPaymentStatus() );
        orderBasicDto.setOrderItems( orderItemListToOrderItemDtoList( order.getOrderItems() ) );

        return orderBasicDto;
    }

    @Override
    public void updateEntityFromDto(OrderDto orderDto, Order order) {
        if ( orderDto == null ) {
            return;
        }

        order.setId( orderDto.getId() );
        if ( orderDto.getCustomer() != null ) {
            if ( order.getCustomer() == null ) {
                order.setCustomer( new User() );
            }
            userDtoToUser1( orderDto.getCustomer(), order.getCustomer() );
        }
        else {
            order.setCustomer( null );
        }
        order.setStatus( orderDto.getStatus() );
        order.setTotalPrice( orderDto.getTotalPrice() );
        order.setPaymentStatus( orderDto.getPaymentStatus() );
        if ( order.getOrderItems() != null ) {
            List<OrderItem> list = orderItemDtoListToOrderItemList( orderDto.getOrderItems() );
            if ( list != null ) {
                order.getOrderItems().clear();
                order.getOrderItems().addAll( list );
            }
            else {
                order.setOrderItems( null );
            }
        }
        else {
            List<OrderItem> list = orderItemDtoListToOrderItemList( orderDto.getOrderItems() );
            if ( list != null ) {
                order.setOrderItems( list );
            }
        }
    }

    private Long orderShopId(Order order) {
        if ( order == null ) {
            return null;
        }
        LaundryShop shop = order.getShop();
        if ( shop == null ) {
            return null;
        }
        Long id = shop.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    private String orderShopShopName(Order order) {
        if ( order == null ) {
            return null;
        }
        LaundryShop shop = order.getShop();
        if ( shop == null ) {
            return null;
        }
        String shopName = shop.getShopName();
        if ( shopName == null ) {
            return null;
        }
        return shopName;
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
