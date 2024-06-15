package com.example.springdemoapp159.service;

import com.example.springdemoapp159.dao.CardsRepository;
import com.example.springdemoapp159.dao.CustomerRepository;
import com.example.springdemoapp159.mapper.CardsMapper;
import com.example.springdemoapp159.model.CardsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CardsMapper cardsMapper;
    private final CustomerRepository customerRepository;

    public  void addCards(CardsDto cardsDto,Integer customerId){
        log.info("ActionLog.addCards.started.customerId:{}",customerId);
        var cardsEntity = cardsMapper.mapToEntitiy(cardsDto);
        var customerEntitiy = customerRepository.findById(customerId).orElseThrow();
        cardsEntity.setCustomer(customerEntitiy);
        cardsRepository.save(cardsEntity);
        log.info("ActionLog.addCards.end.customerId:{}",customerId);
    }
    public void deleteCards(Integer customerId){
        log.info("ActionLog.deleteCards.started.customerId:{}",customerId);
         customerRepository.deleteById(customerId);
         log.info("ActionLog.deleteCards.end.customerId:{}",customerId);
    }


}
