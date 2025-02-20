package com.whoosh_backend.Whoosh_Backend.api.dto.service;

import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {
    private List<ServiceCategory> service;
}
