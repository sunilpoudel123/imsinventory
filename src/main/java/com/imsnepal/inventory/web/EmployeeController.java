package com.imsnepal.inventory.web;

import com.imsnepal.inventory.data.EmployeeRepository;
import com.imsnepal.inventory.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;

    }

    @GetMapping
    public String getEmployeeForm(){
        return "employee";
    }

    @PostMapping
    public String saveEmployeeData(Employee employee){
        this.employeeRepository.save(employee.toEmployee());
        return "employee";
    }

    @GetMapping(value="/view")
    public String displayAllEmployeeData(Model model){
        Iterable<Employee> employeeData= this.employeeRepository.findAll();
        model.addAttribute("employees", employeeData);
        return "employee-view";
    }



}
