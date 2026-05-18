package com.springtuto.springtuto.dtos.request;

import com.springtuto.springtuto.model.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
public class ProjectRequestDTO {
    private Long studentId;
    private String name;
    private String description;
    private Status status;
}
