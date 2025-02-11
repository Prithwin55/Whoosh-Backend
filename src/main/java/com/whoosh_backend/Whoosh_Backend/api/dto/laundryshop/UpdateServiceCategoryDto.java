// src/main/java/com/whoosh_backend/Whoosh_Backend/api/dto/servicecategory/UpsertServiceCategoryDto.java
package com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop;

import com.whoosh_backend.Whoosh_Backend.data.entity.item.Item;
import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateServiceCategoryDto {
    private ServiceType serviceType;
    private List<Item> items;
}