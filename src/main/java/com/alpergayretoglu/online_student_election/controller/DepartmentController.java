package com.alpergayretoglu.online_student_election.controller;

import com.alpergayretoglu.online_student_election.model.response.DepartmentRepresentativeResponse;
import com.alpergayretoglu.online_student_election.model.response.DepartmentResponse;
import com.alpergayretoglu.online_student_election.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
@CrossOrigin
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponse> listDepartments() {
        return departmentService.listDepartments().stream().map(DepartmentResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/representatives")
    public List<DepartmentRepresentativeResponse> listDepartmentRepresentatives() {
        return departmentService.listDepartmentRepresentatives();
    }
}
