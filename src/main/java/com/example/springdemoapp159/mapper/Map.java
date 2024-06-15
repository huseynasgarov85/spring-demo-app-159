package com.example.springdemoapp159.mapper;
import com.example.springdemoapp159.dao.CustomerEntity;
import com.example.springdemoapp159.dao.PhoneTypeEntity;
import com.example.springdemoapp159.model.CustomerDto;
import com.example.springdemoapp159.model.PhoneTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class Map {
    public static Map INSTIANCE = Mappers.getMapper(Map.class);
    @Mapping(source ="customerId",target = "id")
    @Mapping(source = "customerName",target = "firstName")
    @Mapping(source = "customerSurname",target = "lastName")
    @Mapping(source = "customerAge",target = "age")
    @Mapping(target = "fin",source ="pasport.fin" )

    public abstract CustomerDto mapToDto(CustomerEntity customerEntity);

    @Mapping(source = "firstName",target = "customerName")
    @Mapping(source = "lastName",target = "customerSurname")
    @Mapping(source = "age",target = "customerAge")
    @Mapping(source = "fin",target ="pasport.fin" )
    @Mapping(source = "serializeNumber",target ="pasport.serializeNumber" )
    @Mapping(source = "expireDate",target ="pasport.expireDate" )
    @Mapping(source = "id",target = "customerId")
    public abstract CustomerEntity mapToEntity(CustomerDto customerDto) ;

    @Mapping(source = "firstName",target = "customerName")
    @Mapping(source = "lastName",target = "customerSurname")
    @Mapping(source = "age",target = "customerAge")
    @Mapping(target = "customerId", ignore = true)
    public abstract CustomerEntity mapToCustomerDtoForUpdate(@MappingTarget CustomerEntity customerEntity, CustomerDto customerDto);

    public abstract PhoneTypeEntity mapToEntity(PhoneTypeDto phoneTypeDto);

}
