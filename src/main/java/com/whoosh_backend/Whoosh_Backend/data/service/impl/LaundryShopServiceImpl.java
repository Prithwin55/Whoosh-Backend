package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.LaundryShopMapper;
import com.whoosh_backend.Whoosh_Backend.api.response.LaundryShopResponse;
import com.whoosh_backend.Whoosh_Backend.data.entity.laundryshop.LaundryShop;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.LaundryShopRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.LaundryShopService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LaundryShopServiceImpl implements LaundryShopService {

    @Autowired
    private LaundryShopRepository laundryShopRepository;

    @Override
    public List<LaundryShopResponse> getAllLaundryShops() {
        return laundryShopRepository.findAll().stream()
                .map(LaundryShopMapper.INSTANCE::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LaundryShopResponse getLaundryShopById(Long id) throws ResourceNotFoundException {
        return laundryShopRepository.findById(id)
                .map(LaundryShopMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("LaundryShop not found"));
    }

    @Override
    public LaundryShopResponse createLaundryShop(LaundryShopDto laundryShopDto) {
        LaundryShop laundryShop = LaundryShopMapper.INSTANCE.toEntity(laundryShopDto);
        laundryShop = laundryShopRepository.save(laundryShop);
        return LaundryShopMapper.INSTANCE.toResponse(laundryShop);
    }

    @Override
    public LaundryShopResponse updateLaundryShop(Long id, LaundryShopDto laundryShopDto) throws ResourceNotFoundException {
        LaundryShop existingLaundryShop = laundryShopRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LaundryShop not found"));
        LaundryShopMapper.INSTANCE.updateEntityFromDto(laundryShopDto, existingLaundryShop);
        existingLaundryShop = laundryShopRepository.save(existingLaundryShop);
        return LaundryShopMapper.INSTANCE.toResponse(existingLaundryShop);
    }

    @Override
    public void deleteLaundryShop(Long id) {
        laundryShopRepository.deleteById(id);
    }
}