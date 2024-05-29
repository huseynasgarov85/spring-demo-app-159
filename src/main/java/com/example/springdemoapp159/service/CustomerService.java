package com.example.springdemoapp159.service;

import com.example.springdemoapp159.dao.CustomerEntity;
import com.example.springdemoapp159.dao.CustomerRepository;
import com.example.springdemoapp159.mapper.Map;
import com.example.springdemoapp159.model.CustomerDto;
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
        log.info("Action is started");
        List<CustomerEntity> customerEntities = customerRepository.findAll();
        List<CustomerDto> customerDtos = customerEntities.stream().map((c) -> Map.INSTIANCE.mapToDto(c)).toList();
        log.info("Action is finished");
        return customerDtos;
    }

    @SneakyThrows
    public CustomerDto getAllCustomers(int customerId) {
        log.info("Action is started");
        var customerEntity = customerRepository.findById(customerId).
                orElseThrow
                        (() -> {
                                    log.error("Action is failed customerId:" + customerId);
                                    return new RuntimeException("Customer not found");
                                }
                        );
        var customerDto = Map.INSTIANCE.mapToDto(customerEntity);
        log.info("Action is finished");
        return customerDto;
    }

    public void addCustomer(CustomerDto customerDto) {
        log.info("Action is started");
        customerRepository.save(Map.INSTIANCE.mapToEntity(customerDto));
        log.info("Action is finished");
    }

    public void updateCustomer(CustomerDto customerDto, Integer customerId) {
        log.info("Action is started");
        customerRepository.findById(customerId).ifPresent(customerEntity -> {
                    customerEntity.setCustomerName(customerDto.getFirsName());
                    customerEntity.setCustomerSurname(customerDto.getLastName());
                    customerEntity.setCustomerAge(customerDto.getAge());
                    customerRepository.save(customerEntity);
                }
        );
        log.info("Action is finished");
    }

    public void deleteCustomer(Integer customerId) {
        log.info("Action is started");
        customerRepository.deleteById(customerId);
        log.info("Action is finished");
    }
}