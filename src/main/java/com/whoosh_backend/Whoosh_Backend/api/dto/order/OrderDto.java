package com.whoosh_backend.Whoosh_Backend.api.dto.order;

import com.whoosh_backend.Whoosh_Backend.api.dto.laundryshop.LaundryShopDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.orderitem.OrderItemDto;
import com.whoosh_backend.Whoosh_Backend.api.dto.user.UserDto;
import com.whoosh_backend.Whoosh_Backend.data.enums.OrderStatus;
import com.whoosh_backend.Whoosh_Backend.data.enums.PaymentStatus;
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
public class OrderDto {
    private Long id;
    private UserDto customer;
    private long shopId;
    private UserDto deliveryPerson;
    private OrderStatus status;
    private Double totalPrice;
    private PaymentStatus paymentStatus;
    private List<OrderItemDto> orderItems;
}