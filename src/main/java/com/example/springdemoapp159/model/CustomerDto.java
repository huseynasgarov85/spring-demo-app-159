package com.example.springdemoapp159.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String fin;
    private String serializeNumber;
    private LocalDate expireDate;
    private List<CardsDto> cards;
    private List<PhoneTypeDto> phoneType;
}
