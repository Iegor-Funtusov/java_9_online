package ua.com.alevel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/rest/departments")
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<Department> findDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<Collection<Employee>> findEmployeesByDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findAllDepartment(departmentService.findById(id)));
    }
}
