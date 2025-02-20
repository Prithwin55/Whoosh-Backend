package com.whoosh_backend.Whoosh_Backend.api.controller.service;

import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/services")
public class ServiceController {
    private  ServiceService serviceService;

    @GetMapping("/{shopId}")
    ResponseEntity<List<ServiceType>> getAllServices(@PathVariable long shopId) throws ResourceNotFoundException {
        return ResponseEntity.ok(serviceService.getAllServices(shopId));
    }

}
