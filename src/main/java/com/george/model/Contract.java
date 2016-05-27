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
    private int clientId;
    private int salesId;
    private Date creationDate;
    private Date settlementDate;
    private String usedCurrency;
    private String boughtCurrency;
    private double exchangeRate;
    private int amount;
    private int price;
    private String clientName;
    private String salesName;

    public Contract(){}
}

