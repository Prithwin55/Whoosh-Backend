package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
   UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    UserDto toDto(User user);
    User toEntity(UserDto userDto);

    void updateEntityFromDto(UserDto userDto, @MappingTarget User user);
}