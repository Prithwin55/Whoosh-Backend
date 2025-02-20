package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopBasicDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.entity.order.Order;
import com.whoosh_backend.Whoosh_Backend.data.entity.orderItem.OrderItem;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface LaundryShopMapper {
    LaundryShopMapper INSTANCE= Mappers.getMapper(LaundryShopMapper.class);
    LaundryShopDto toDto(LaundryShop laundryShop);
    LaundryShop toEntity(LaundryShopDto laundryShopDto);

    LaundryShopBasicDto toBasicDto(LaundryShop laundryShop);



    void updateEntityFromDto(LaundryShopDto laundryShopDto, @MappingTarget LaundryShop laundryShop);




    @Mapping(target = "orderIds", source = "orders", qualifiedByName = "mapOrderIds")
    @Mapping(target = "serviceCategories", source = "serviceCategories",qualifiedByName = "mapServiceCategories")
    LaundryShopResponse toResponse(LaundryShop laundryShop);

    @Named("mapServiceCategories")
    default List<ServiceCategoryDto> mapServiceCategories(List<ServiceCategory> serviceCategories) {
        return serviceCategories.stream()
                .map(sc -> new ServiceCategoryDto(sc.getId(),sc.getServiceType(),sc.getItems()))
                .collect(Collectors.toList());
    }

    @Named("mapOrderIds")
    default List<Long> mapOrderIds(List<Order> orders) {
        return orders != null ? orders.stream().map(Order::getId).toList() : null;
    }
}