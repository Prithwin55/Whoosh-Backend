package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.delivery.DeliveryDto;
import com.whoosh_backend.Whoosh_Backend.api.response.DeliveryResponse;
import com.whoosh_backend.Whoosh_Backend.data.entity.delivery.Delivery;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeliveryMapper {
    DeliveryMapper INSTANCE= Mappers.getMapper(DeliveryMapper.class);
    DeliveryDto toDto(Delivery delivery);
    Delivery toEntity(DeliveryDto deliveryDto);

    DeliveryResponse toResponse(Delivery delivery);
    void updateEntityFromDto(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}