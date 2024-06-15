package com.example.springdemoapp159.controller;

import com.example.springdemoapp159.model.CardsDto;
import com.example.springdemoapp159.model.CustomerDto;
import com.example.springdemoapp159.service.CardsService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {
    private final CardsService cardsService;

    @PostMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCards(@RequestBody CardsDto cardsDto, @PathVariable Integer customerId) {
        cardsService.addCards(cardsDto, customerId);
    }
    @DeleteMapping("/customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCards(@PathVariable Integer customerId) {
        cardsService.deleteCards(customerId);
    }
}
