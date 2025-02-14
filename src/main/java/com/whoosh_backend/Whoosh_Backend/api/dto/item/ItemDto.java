package com.whoosh_backend.Whoosh_Backend.api.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
    private Long id;
    private Double price;
    private String itemName;
}
