package com.springtuto.springtuto.dtos.response;

import com.springtuto.springtuto.model.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectResponseDTO {
    private String name;
    private String description;
    private Status status;
}
