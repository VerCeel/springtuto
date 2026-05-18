package com.springtuto.springtuto.service;

import com.springtuto.springtuto.dtos.request.StudentRequestDTO;
import com.springtuto.springtuto.dtos.response.ProjectResponseDTO;
import com.springtuto.springtuto.dtos.response.StudentResponseDTO;
import com.springtuto.springtuto.model.Project;
import com.springtuto.springtuto.model.Student;
import com.springtuto.springtuto.repository.ProjectRepository;
import com.springtuto.springtuto.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<StudentResponseDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(s -> StudentResponseDTO.builder()
                        .id(s.getId())
                        .firstName(s.getFirstName())
                        .lastName(s.getLastName())
                        .age(Period.between(
                                s.getBirthDate(),
                                LocalDate.now()
                        ).getYears())
                        .build()
                )
                .toList();
    }

    public StudentResponseDTO findById(Long id) {
       Student student = studentRepository.findById(id).orElse(null);
       List<Project> projects = projectRepository.findAllById(id);
        return StudentResponseDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(Period.between(
                        student.getBirthDate(),
                        LocalDate.now()
                ).getYears())
                .projects(projects.stream().map(
                        project -> ProjectResponseDTO.builder()
                                .name(project.getName())
                                .description(project.getDescription())
                                .status(project.getStatus())
                                .build()
                ).toList())
                .build();
    }

    public StudentResponseDTO add(StudentRequestDTO request) {
        Student student = Student.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .birthDate(request.getBirthDate())
                .build();
        studentRepository.save(student);
        return StudentResponseDTO.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .age(Period.between(
                        student.getBirthDate(),
                        LocalDate.now()
                ).getYears())
                .build();

    }

    public Student update(StudentRequestDTO request, Long id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null){
            existingStudent.setFirstName(request.getFirstName());
            existingStudent.setLastName(request.getLastName());
            existingStudent.setBirthDate(request.getBirthDate());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
