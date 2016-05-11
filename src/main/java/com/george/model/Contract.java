package com.george.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Contract {
    private int id;
    private int ClientID;
    private int SalesID;
    private Date creationDate;
    private Date settlementDate;
    private String usedCurrency;
    private String boughtCurrency;
    private double exchangeRate;
    private int amount;
    private int price;

    public Contract(){}
}

