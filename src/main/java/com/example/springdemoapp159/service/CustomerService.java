package com.example.springdemoapp159.service;

import com.example.springdemoapp159.dao.CustomerEntity;
import com.example.springdemoapp159.dao.CustomerRepository;
import com.example.springdemoapp159.exception.ValidationException;
import com.example.springdemoapp159.mapper.Map;
import com.example.springdemoapp159.model.CustomerDto;
import com.example.springdemoapp159.model.PhoneTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
//    private final Map map;

    public List<CustomerDto> getCustomers() {
        log.info("ActionLog.getCustomers.start");
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerDto> customerDtos = customerEntities.stream().map((c) -> Map.INSTIANCE.mapToDto(c)).toList();
        log.info("ActionLog.getCustomers.end");
        return customerDtos;
    }

    @SneakyThrows
    public CustomerDto getAllCustomers(Integer customerId) {
        log.info("ActionLog.getAllCustomer.started.customerId:{}", customerId);
        var customerEntity = customerRepository.findById(customerId).
                orElseThrow
                        (() -> {
                                    log.error("Action is failed customerId:" + customerId);
                                    return new ValidationException("Customer not found");
                                }
                        );
        var customerDto = Map.INSTIANCE.mapToDto(customerEntity);
        log.info("ActionLog.getAllCustomer.ended.customerId:{}" + customerId);
        return customerDto;
    }

    public void addCustomer(CustomerDto customerDto) {
        log.info("ActionLog.addCustomer.start.customerDto:{}", customerDto);
        var customerEntitiy = Map.INSTIANCE.mapToEntity(customerDto);
        customerRepository.save(customerEntitiy);
        log.info("ActionLog.addCustomer.end.customerDto:{}", customerDto);
    }

    public void updateCustomer(CustomerDto customerDto, Integer customerId) {
        log.info("ActionLog.updateCustomer.started.customerDto:{}", customerDto, customerId);
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Map.INSTIANCE.mapToCustomerDtoForUpdate(customerEntity, customerDto);
        customerRepository.save(customerEntity);
        log.info("ActionLog.updateCustomer.end.finished.customerDto:{}", customerDto, customerId);
    }

    public void deleteCustomer(Integer customerId) {
        log.info("ActionLog.deleteCustomer.start.customerId:{}", customerId);
        customerRepository.deleteById(customerId);
        log.info("ActionLog.deleteCustomer.end.customerId:{}", customerId);

    }

    public void deleteCardsInCustomer(Integer customerId, Integer cardsId) {
        log.info("ActionLog.deleteCardsInCustomer.start.customerId:{},{}", customerId, cardsId);
        var customerEntitiy = customerRepository.findById(customerId).orElseThrow();
        var cards = customerEntitiy.getCards();
        cards.removeIf(m -> m.getId().equals(cardsId));
        customerEntitiy.setCards(cards);
        customerRepository.save(customerEntitiy);
        log.info("ActionLog.deleteCardsInCustomer.end.customerId:{},{}", customerId, cardsId);
    }

    public void addPhoneType(Integer customerId, PhoneTypeDto phoneTypeDto) {
        log.info("ActionLog.addPhoneType.start.customerId:{},{}", customerId, phoneTypeDto);
        var customerEntity = customerRepository.findById(customerId).orElseThrow();
        var phoneEntity = Map.INSTIANCE.mapToEntity(phoneTypeDto);
        customerEntity.getPhoneType().add(phoneEntity);
        customerRepository.save(customerEntity);
        log.info("ActionLog.addPhoneType.end.customerId:{},{}", customerId, phoneTypeDto);
    }

    public void deletePhoneInCustomer(Integer customerId, Integer phoneId) {
        log.info("ActionLog.deletePhoneInCustomer.start.customerId:{},{}", customerId, phoneId);
        var customerEntity = customerRepository.findById(customerId).orElseThrow();
        var phones = customerEntity.getPhoneType();
        phones.removeIf(m -> m.getId().equals(phoneId));
        customerRepository.save(customerEntity);
        log.info("ActionLog.deletePhoneInCustomer.end.customerId:{},{}", customerId, phoneId);
    }

}