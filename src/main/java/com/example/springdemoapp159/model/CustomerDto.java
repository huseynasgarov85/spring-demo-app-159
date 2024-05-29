package com.example.springdemoapp159.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private Integer id;
    @JsonProperty("name")
    private String firsName;
    private String lastName;
    private Integer age;
}
