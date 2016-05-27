package com.george.model;


import lombok.*;



@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode


public class Users  {

    private String name;
    private String password;

    public Users(){

    }
}

