package com.example.springdemoapp159.mapper;
import com.example.springdemoapp159.dao.CardsEntity;
import com.example.springdemoapp159.model.CardsDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public abstract class CardsMapper {
    public abstract CardsEntity mapToEntitiy(CardsDto cardsDto);
    public abstract CardsDto mapToDto(CardsEntity cardsEntity);
}
