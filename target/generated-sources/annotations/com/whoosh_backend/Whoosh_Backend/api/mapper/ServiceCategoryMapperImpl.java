package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-11T14:33:02+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
public class ServiceCategoryMapperImpl implements ServiceCategoryMapper {

    @Override
    public ServiceCategory toEntity(ServiceCategoryDto serviceCategoryDto) {
        if ( serviceCategoryDto == null ) {
            return null;
        }

        ServiceCategory serviceCategory = new ServiceCategory();

        serviceCategory.setId( serviceCategoryDto.getId() );
        serviceCategory.setServiceType( serviceCategoryDto.getServiceType() );

        return serviceCategory;
    }
}
