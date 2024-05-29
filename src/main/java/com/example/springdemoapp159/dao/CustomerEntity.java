package com.example.springdemoapp159.dao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerEntity {
    @Id
    @Column(name = "id")
    private Integer customerId;
    @Column(name = "name")
    private String customerName;
    @Column(name = "surname")
    private String customerSurname;
    @Column(name = "age")
    private Integer customerAge;
}
