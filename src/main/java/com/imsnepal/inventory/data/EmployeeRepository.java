package com.imsnepal.inventory.data;

import com.imsnepal.inventory.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Iterable<Employee> findAllByOffice_Id(Long id);
}
