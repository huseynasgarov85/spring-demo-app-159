package com.example.springdemoapp159.mapper;

import com.example.springdemoapp159.dao.CustomerEntity;
import com.example.springdemoapp159.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class Map {
    public static Map INSTIANCE = Mappers.getMapper(Map.class);
    @Mapping(source ="customerId",target = "id")
    @Mapping(source = "customerName",target = "firsName")
    @Mapping(source = "customerSurname",target = "lastName")
    @Mapping(source = "customerAge",target = "age")
    public abstract CustomerDto mapToDto(CustomerEntity customerEntity);

    @Mapping(source ="id",target = "customerId")
    @Mapping(source = "firsName",target = "customerName")
    @Mapping(source = "lastName",target = "customerSurname")
    @Mapping(source = "age",target = "customerAge")
    public abstract CustomerEntity mapToEntity(CustomerDto customerDto) ;
}
