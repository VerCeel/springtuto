package com.springtuto.springtuto.dtos.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRequestDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
