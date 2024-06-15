package com.example.springdemoapp159.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardsDto {
    private Integer id;
    private String cardNumber;
    private String cardBalance;
    private Integer cvv;
}
