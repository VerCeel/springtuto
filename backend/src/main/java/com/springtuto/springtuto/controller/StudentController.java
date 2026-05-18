package com.springtuto.springtuto.controller;

import com.springtuto.springtuto.dtos.request.StudentRequestDTO;
import com.springtuto.springtuto.dtos.response.StudentResponseDTO;
import com.springtuto.springtuto.model.Student;
import com.springtuto.springtuto.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public StudentResponseDTO save(@RequestBody StudentRequestDTO student) {
        return studentService.add(student);
    }

    @PatchMapping("/{id}")
    public Student update(@RequestBody StudentRequestDTO student, @PathVariable Long id) {
        return studentService.update(student, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
