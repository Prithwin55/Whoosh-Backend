package com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.user.User;
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
public class LaundryShopDto {
    private Long id;
    private String shopName;
    private String location;
    private String address;
    private Status status;
    private UserDto owner;
    private List<OrderDto> orders;
}