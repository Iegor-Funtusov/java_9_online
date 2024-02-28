package ua.com.alevel.service;

import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.Collection;

public interface EmployeeService extends CrudService<Employee> {

    Collection<Employee> findAllDepartment(Department department);
}
