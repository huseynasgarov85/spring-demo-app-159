package com.example.springdemoapp159.dao;

import com.example.springdemoapp159.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name = "name")
    private String customerName;
    @Column(name = "surname")
    private String customerSurname;
    @Column(name = "age")
    private Integer customerAge;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasport_id")
    private PasportEntity pasport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",orphanRemoval = true)
    private List<CardsEntity> cards;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "customers_phones",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id"))
    private List<PhoneTypeEntity> phoneType;



//    @Enumerated(EnumType.STRING)
//    private Currency currency;
}
