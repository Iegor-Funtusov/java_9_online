package ua.com.alevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.repository.EmployeeRepository;

import java.util.UUID;

@SpringBootApplication
public class DemoServerApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoServerApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        Department department = new Department();
        department.setName("JAVA");
        departmentRepository.save(department);

        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setFirstName(UUID.randomUUID().toString());
            employee.setLastName(UUID.randomUUID().toString());
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }
}
