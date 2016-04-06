package com.george.model;

import lombok.*;

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
    private String creationDate;
    private String settlementDate;
    private String usedCurrency;
    private String boughtCurrency;
    private double exchangeRate;
    private int amount;
    private int price;

    public Contract(){}
}

