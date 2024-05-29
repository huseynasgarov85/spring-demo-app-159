package com.example.springdemoapp159.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {
    @JsonProperty("value")
    private String number;
    private Double balance;

    public AccountDto(String number, Double balance) {
        this.number = number;
        this.balance = balance;
    }

    public AccountDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
