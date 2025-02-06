package com.whoosh_backend.Whoosh_Backend.api.response;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryResponse {
    private Long id;
    private OrderDto order;
    private UserDto deliveryPerson;
    private LocalDateTime pickupTime;
    private LocalDateTime dropTime;
    private DeliveryStatus status;
}
