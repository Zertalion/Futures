package com.george.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Sales {
    private int id;
    private String lastName;
    private String firstName;
    private String department;
    private Date dateOfBirth;

    public Sales(){

    }
}
