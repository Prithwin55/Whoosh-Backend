package com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop;

import com.whoosh_backend.Whoosh_Backend.data.enums.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LaundryShopCatagoryDto {
    private ServiceType serviceType;
}
