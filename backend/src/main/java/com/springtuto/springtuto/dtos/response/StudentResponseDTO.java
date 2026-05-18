package com.springtuto.springtuto.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private List<ProjectResponseDTO> projects;
}
