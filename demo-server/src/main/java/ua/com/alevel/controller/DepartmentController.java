package ua.com.alevel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.service.impl.DepartmentServiceImpl;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

//    private final DepartmentServiceImpl departmentService;
    private final DepartmentService departmentService;
    private final EmployeeService employeeService;

    @GetMapping
    public String find(Model model) {
        Department department = departmentService.findById(1L);
        model.addAttribute("department", department);
        System.out.println("department = " + department.getName());
        model.addAttribute("employees", employeeService.findAllDepartment(department));
        return "pages/departments/department";
    }
}
