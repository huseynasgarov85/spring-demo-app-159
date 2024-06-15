package com.example.springdemoapp159.dao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Entity
@Table(name = "pasport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fin;
    private String serializeNumber;
    private LocalDate expireDate;
}
