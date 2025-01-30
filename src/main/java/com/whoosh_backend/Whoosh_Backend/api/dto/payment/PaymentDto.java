package com.whoosh_backend.Whoosh_Backend.api.dto.payment;

import com.whoosh_backend.Whoosh_Backend.api.dto.order.OrderDto;
import com.whoosh_backend.Whoosh_Backend.data.enums.PaymentMode;
import com.whoosh_backend.Whoosh_Backend.data.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentDto {
    private Long id;
    private OrderDto order;
    private PaymentMode paymentMode;
    private String transactionId;
    private PaymentStatus status;
}