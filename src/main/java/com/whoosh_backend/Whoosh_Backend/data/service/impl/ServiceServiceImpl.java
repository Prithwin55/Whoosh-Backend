package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.ServiceCategoryRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

   private ServiceCategoryRepository serviceCategoryRepository;

    @Override
    public List<ServiceType> getAllServices(long shopId) throws ResourceNotFoundException {

        List<ServiceType>services=serviceCategoryRepository.findAllByLaundryShopId(shopId)
                .stream().map(ServiceCategory::getServiceType).toList();
        return services;
    }
}
