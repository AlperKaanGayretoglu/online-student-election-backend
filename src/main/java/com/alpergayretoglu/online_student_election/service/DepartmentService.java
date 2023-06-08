package com.alpergayretoglu.online_student_election.service;

import com.alpergayretoglu.online_student_election.model.entity.Department;
import com.alpergayretoglu.online_student_election.model.entity.User;
import com.alpergayretoglu.online_student_election.model.response.DepartmentRepresentativeResponse;
import com.alpergayretoglu.online_student_election.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(String departmentName) {
        return departmentRepository.findByName(departmentName).orElseThrow(() -> new RuntimeException("Department not found with name: " + departmentName));
    }

    public List<DepartmentRepresentativeResponse> listDepartmentRepresentatives() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department -> {
            User representative = department.getRepresentative();
            return DepartmentRepresentativeResponse.builder()
                    .departmentName(department.getName())
                    .representativeNameSurname(representative == null ? null : department.getRepresentative().getName() + " " + department.getRepresentative().getSurname())
                    .faculty(department.getFaculty().getName())
                    .build();
        })).collect(Collectors.toList());
    }

}
