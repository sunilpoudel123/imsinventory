package com.imsnepal.inventory.webapi;

import com.imsnepal.inventory.data.EmployeeRepository;
import com.imsnepal.inventory.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/employee", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeApiController {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeApiController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<Employee> getAllEmployeeData() {
        return this.repository.findAll();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Iterable<Employee> getAllEmployeeDataById(@PathVariable Long id) {
        Iterable<Employee> employeeById = this.repository.findAllByOffice_Id(id);
        return employeeById;
    }


}
