package com.whoosh_backend.Whoosh_Backend.api.response;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.UpdateServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.servicecategory.ServiceCategoryDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.servicecategory.ServiceCategory;
import com.whoosh_backend.Whoosh_Backend.data.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaundryShopResponse {
    private Long id;
    private String shopName;
    private String location;
    private String address;
    private Status status;
    private UserDto owner;
    private List<Long> orderIds;
    private List<ServiceCategoryDto> serviceCategories;
}
