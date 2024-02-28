package ua.com.alevel.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {

    Collection<Employee> findAllByDepartment(Department department);
}
