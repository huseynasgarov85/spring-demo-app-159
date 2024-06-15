package com.example.springdemoapp159.dao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cardNumber;
    private Integer cardBalance;
    private Integer cvv;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
