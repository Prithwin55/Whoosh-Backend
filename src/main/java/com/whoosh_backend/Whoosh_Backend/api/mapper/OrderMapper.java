package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE= Mappers.getMapper(OrderMapper.class);
    @Mapping(source = "shop.id", target = "shopId")
    OrderDto toDto(Order order);
    @Mapping(source = "shopId", target = "shop.id")
    Order toEntity(OrderDto orderDto);
    @Mapping(source = "shop.shopName", target = "shopName")
    OrderBasicDto toBasicDto(Order order);
}