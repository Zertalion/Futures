package com.george.model;

import lombok.*;

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
    private String dateOfBirth;

    public Sales(){

    }
}
