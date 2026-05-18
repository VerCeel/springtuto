package com.springtuto.springtuto.controller;

import com.springtuto.springtuto.dtos.request.ProjectRequestDTO;
import com.springtuto.springtuto.dtos.response.ProjectResponseDTO;
import com.springtuto.springtuto.model.Project;
import com.springtuto.springtuto.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<ProjectResponseDTO> findAll() {
        return projectService.findAll();
    }

    @PostMapping
    public ProjectResponseDTO save(@RequestBody ProjectRequestDTO project) {
        return projectService.add(project);
    }

    @PatchMapping("/{id}")
    public ProjectResponseDTO update(@RequestBody ProjectRequestDTO project, @PathVariable Long id) {
        return projectService.update(project, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }

}
