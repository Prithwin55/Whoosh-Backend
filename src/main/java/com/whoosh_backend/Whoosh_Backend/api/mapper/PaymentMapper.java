package com.whoosh_backend.Whoosh_Backend.api.mapper;

import com.whoosh_backend.Whoosh_Backend.api.dto.payment.PaymentDto;
import com.whoosh_backend.Whoosh_Backend.data.entity.payment.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE= Mappers.getMapper(PaymentMapper.class);
    PaymentDto toDto(Payment payment);
    Payment toEntity(PaymentDto paymentDto);
}