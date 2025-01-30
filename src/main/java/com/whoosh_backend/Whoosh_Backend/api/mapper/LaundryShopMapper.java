package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LaundryShopMapper {
    LaundryShopMapper INSTANCE= Mappers.getMapper(LaundryShopMapper.class);
    LaundryShopDto toDto(LaundryShop laundryShop);
    LaundryShop toEntity(LaundryShopDto laundryShopDto);
}