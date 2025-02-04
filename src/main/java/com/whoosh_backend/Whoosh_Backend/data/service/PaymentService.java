package com.whoosh_backend.Whoosh_Backend.data.service;

import com.whoosh_backend.Whoosh_Backend.api.dto.payment.PaymentDto;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> getAllPayments();
    PaymentDto getPaymentById(Long id) throws ResourceNotFoundException;
    PaymentDto createPayment(PaymentDto paymentDto);
    PaymentDto updatePayment(Long id, PaymentDto paymentDto) throws ResourceNotFoundException;
    void deletePayment(Long id);
}