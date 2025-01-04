package ru.otus.socialnetwork.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
public class User {

    private Long id;
    private String firstName;
    private String secondName;
    private LocalDate birthdate;
    private String biography;
    private String city;

}
