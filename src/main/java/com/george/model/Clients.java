package com.george.model;

import lombok.*;

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
    private String dateOfBirth;


 //public Clients(String lastName, String firstName, String nationality, String dateOfBirth) {
 //implement me
 //}
    public Clients(){}
}
