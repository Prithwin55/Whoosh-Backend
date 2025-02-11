package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ServiceCategoryMapper {
    ServiceCategoryMapper INSTANCE = Mappers.getMapper(ServiceCategoryMapper.class);
    @Mapping(target = "items", ignore = true)
    ServiceCategory toEntity(ServiceCategoryDto serviceCategoryDto);
}
