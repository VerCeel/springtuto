package com.springtuto.springtuto.model;

import com.springtuto.springtuto.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long  id;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @Enumerated(EnumType.STRING)
    private Status status;
}
