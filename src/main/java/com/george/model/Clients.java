package com.george.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Clients {
    private int id;
    private String lastName;
    private String firstName;
    private String nationality;
    private Date dateOfBirth;



    public Clients(){}
}
