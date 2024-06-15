package com.example.springdemoapp159.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasportDto {
    private Integer id;
    private String fin;
    private String serializeNumber;
    private LocalDate expireDate;
}
