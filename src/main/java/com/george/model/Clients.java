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
    private int age;
    private int SalesID;

 public Clients(String lastName, String firstName, String nationality, int age, int SalesID) {
 //implement me
 }
}
