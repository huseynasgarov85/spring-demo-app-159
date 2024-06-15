package com.example.springdemoapp159.controller;

import com.example.springdemoapp159.model.CustomerDto;
import com.example.springdemoapp159.model.PhoneTypeDto;
import com.example.springdemoapp159.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerControler {
    private final CustomerService customerService;

    public CustomerControler(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDto getAllCustomers(@PathVariable Integer customerId) {
        return customerService.getAllCustomers(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable Integer customerId) {
        customerService.updateCustomer(customerDto, customerId);
    }

    @DeleteMapping("/{customerId}/cards/{cardsId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCardInCustomer(@PathVariable Integer customerId,@PathVariable Integer cardsId){
        customerService.deleteCardsInCustomer(customerId, cardsId);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
    @PostMapping("/{customerId}/phones")
    @ResponseStatus(HttpStatus.CREATED)
    public void addPhoneType(@PathVariable Integer customerId, @RequestBody PhoneTypeDto phoneTypeDto){
        customerService.addPhoneType(customerId,phoneTypeDto);
    }
    @DeleteMapping("/{customerId}/phones/{phoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhoneInCustomer(@PathVariable Integer customerId,@PathVariable Integer phoneId){
        customerService.deletePhoneInCustomer(customerId,phoneId);
    }

}
