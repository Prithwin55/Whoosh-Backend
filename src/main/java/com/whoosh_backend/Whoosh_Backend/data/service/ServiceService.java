package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.service.ServiceDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface ServiceService {
    List<ServiceType> getAllServices(long shopId) throws ResourceNotFoundException;
}
