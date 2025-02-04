package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.delivery.DeliveryDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.DeliveryMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.delivery.Delivery;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.DeliveryRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<DeliveryDto> getAllDeliveries() {
        return deliveryRepository.findAll().stream()
                .map(DeliveryMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDto getDeliveryById(Long id) throws ResourceNotFoundException {
        return deliveryRepository.findById(id)
                .map(DeliveryMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));
    }

    @Override
    public DeliveryDto createDelivery(DeliveryDto deliveryDto) {
        Delivery delivery = DeliveryMapper.INSTANCE.toEntity(deliveryDto);
        delivery = deliveryRepository.save(delivery);
        return DeliveryMapper.INSTANCE.toDto(delivery);
    }

    @Override
    public DeliveryDto updateDelivery(Long id, DeliveryDto deliveryDto) throws ResourceNotFoundException {

        Delivery existingDelivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));

        //DeliveryMapper.INSTANCE.toEntity(deliveryDto, existingDelivery);
        existingDelivery = deliveryRepository.save(existingDelivery);
        return DeliveryMapper.INSTANCE.toDto(existingDelivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}