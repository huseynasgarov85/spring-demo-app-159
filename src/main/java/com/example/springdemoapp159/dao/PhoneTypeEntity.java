package com.example.springdemoapp159.dao;

import com.example.springdemoapp159.model.PhoneType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "phones")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PhoneTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private PhoneType phones;
    private String number;
}
