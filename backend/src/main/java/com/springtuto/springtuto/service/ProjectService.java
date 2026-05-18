package com.springtuto.springtuto.service;

import com.springtuto.springtuto.dtos.request.ProjectRequestDTO;
import com.springtuto.springtuto.dtos.response.ProjectResponseDTO;
import com.springtuto.springtuto.model.Project;
import com.springtuto.springtuto.model.Student;
import com.springtuto.springtuto.repository.ProjectRepository;
import com.springtuto.springtuto.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<ProjectResponseDTO> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(
                p -> ProjectResponseDTO.builder()
                        .name(p.getName())
                        .description(p.getDescription())
                        .status(p.getStatus())
                        .build()
        ).toList();
    }


    public List<ProjectResponseDTO> findByStudentID(Long id){
        return projectRepository.findByStudentId(id).stream().map(
                p -> ProjectResponseDTO.builder()
                        .name(p.getName())
                        .description(p.getDescription())
                        .status(p.getStatus())
                        .build()
        ).toList();
    }

    public ProjectResponseDTO add(ProjectRequestDTO request) {
        System.out.println("Response" + request.getDescription() + request.getStatus() + " " + request.getName());

//        use student service later
        Student student = studentRepository.findById(request.getStudentId()).orElse(null);
        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .student(student)
                .build();
        projectRepository.save(project);

        return ProjectResponseDTO.builder()
                .name(project.getName())
                .description(project.getDescription())
                .status(project.getStatus())
                .build();
    }

    public ProjectResponseDTO update(ProjectRequestDTO request, Long id) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setName(request.getName());
            existingProject.setDescription(request.getDescription());
            existingProject.setStatus(request.getStatus());
            Project savedProject = projectRepository.save(existingProject);
            return ProjectResponseDTO.builder()
                    .name(savedProject.getName())
                    .description(savedProject.getDescription())
                    .status(savedProject.getStatus())
                    .build();

        }
        return null;
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }


}
