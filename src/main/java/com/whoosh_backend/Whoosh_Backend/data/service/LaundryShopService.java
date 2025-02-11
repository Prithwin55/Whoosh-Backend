package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.UpdateServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface LaundryShopService {
    List<LaundryShopResponse> getAllLaundryShops();
    LaundryShopResponse getLaundryShopById(Long id) throws ResourceNotFoundException;
    LaundryShopResponse createLaundryShop(LaundryShopDto laundryShopDto) throws ResourceNotFoundException;
    LaundryShopResponse updateLaundryShop(Long id, LaundryShopDto laundryShopDto) throws ResourceNotFoundException;
    LaundryShopResponse updateServiceCategory(Long laundryShopId, ServiceCategoryDto upsertServiceCategoryDto) throws ResourceNotFoundException;
    void deleteLaundryShop(Long id);
}