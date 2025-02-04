package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LaundryShopMapper {
    LaundryShopMapper INSTANCE= Mappers.getMapper(LaundryShopMapper.class);
    LaundryShopDto toDto(LaundryShop laundryShop);
    LaundryShop toEntity(LaundryShopDto laundryShopDto);

    LaundryShopBasicDto toBasicDto(LaundryShop laundryShop);


    void updateEntityFromDto(LaundryShopDto laundryShopDto, @MappingTarget LaundryShop laundryShop);
}