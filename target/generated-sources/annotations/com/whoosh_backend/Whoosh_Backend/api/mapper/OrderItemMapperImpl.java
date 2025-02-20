package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.item.ItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-12T18:12:24+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDto toDto(OrderItem orderItem) {
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

    @Override
    public OrderItem toEntity(OrderItemDto orderItemDto) {
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

    @Override
    public void updateEntityFromDto(OrderItemDto orderItemDto, OrderItem orderItem) {
        if ( orderItemDto == null ) {
            return;
        }

        orderItem.setId( orderItemDto.getId() );
        if ( orderItemDto.getItem() != null ) {
            if ( orderItem.getItem() == null ) {
                orderItem.setItem( new Item() );
            }
            itemDtoToItem1( orderItemDto.getItem(), orderItem.getItem() );
        }
        else {
            orderItem.setItem( null );
        }
        orderItem.setQuantity( orderItemDto.getQuantity() );
        orderItem.setTotalPrice( orderItemDto.getTotalPrice() );
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

    protected void itemDtoToItem1(ItemDto itemDto, Item mappingTarget) {
        if ( itemDto == null ) {
            return;
        }

        mappingTarget.setId( itemDto.getId() );
        mappingTarget.setPrice( itemDto.getPrice() );
        mappingTarget.setItemName( itemDto.getItemName() );
    }
}
