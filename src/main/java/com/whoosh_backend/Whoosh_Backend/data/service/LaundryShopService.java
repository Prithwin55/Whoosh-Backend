package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface LaundryShopService {
    List<LaundryShopResponse> getAllLaundryShops();
    LaundryShopDto getLaundryShopById(Long id) throws ResourceNotFoundException;
    LaundryShopDto createLaundryShop(LaundryShopDto laundryShopDto);
    LaundryShopDto updateLaundryShop(Long id, LaundryShopDto laundryShopDto) throws ResourceNotFoundException;
    void deleteLaundryShop(Long id);
}