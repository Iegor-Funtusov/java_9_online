package ua.com.alevel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Department;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public void create(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Collection<Department> findAll() {
        return departmentRepository.findAll();
    }
}
