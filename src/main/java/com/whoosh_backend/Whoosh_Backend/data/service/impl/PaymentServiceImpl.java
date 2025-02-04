package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.whoosh_backend.Whoosh_Backend.api.dto.payment.PaymentDto;
import com.whoosh_backend.Whoosh_Backend.api.mapper.PaymentMapper;
import com.whoosh_backend.Whoosh_Backend.data.entity.payment.Payment;
import com.whoosh_backend.Whoosh_Backend.data.exception.ResourceNotFoundException;
import com.whoosh_backend.Whoosh_Backend.data.repository.PaymentRepository;
import com.whoosh_backend.Whoosh_Backend.data.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(PaymentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto getPaymentById(Long id) throws ResourceNotFoundException {
        return paymentRepository.findById(id)
                .map(PaymentMapper.INSTANCE::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.INSTANCE.toEntity(paymentDto);
        payment = paymentRepository.save(payment);
        return PaymentMapper.INSTANCE.toDto(payment);
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) throws ResourceNotFoundException {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));
        //PaymentMapper.INSTANCE.updateEntityFromDto(paymentDto, existingPayment);
        existingPayment = paymentRepository.save(existingPayment);
        return PaymentMapper.INSTANCE.toDto(existingPayment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}