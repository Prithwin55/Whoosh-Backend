package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.delivery.DeliveryDto;
import com.whoosh_backend.Whoosh_Backend.api.response.DeliveryResponse;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface DeliveryService {
    List<DeliveryResponse> getAllDeliveries();
    DeliveryDto getDeliveryById(Long id) throws ResourceNotFoundException;
    DeliveryResponse createDelivery(DeliveryDto deliveryDto) throws ResourceNotFoundException;
    DeliveryDto updateDelivery(Long id, DeliveryDto deliveryDto) throws ResourceNotFoundException;
    void deleteDelivery(Long id);
}