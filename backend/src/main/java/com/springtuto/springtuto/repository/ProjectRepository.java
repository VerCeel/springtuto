package com.springtuto.springtuto.repository;

import com.springtuto.springtuto.dtos.response.ProjectResponseDTO;
import com.springtuto.springtuto.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<ProjectResponseDTO> findByStudentId(Long studentId);
    List<Project> findAllById(Long id);
}
