package com.imsnepal.inventory.web;

import com.imsnepal.inventory.data.EmployeeRepository;
import com.imsnepal.inventory.data.OfficeRepository;
import com.imsnepal.inventory.domain.Employee;
import com.imsnepal.inventory.domain.Office;
import com.imsnepal.inventory.domain.OfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/office")
public class OfficeController {

    private OfficeRepository officeRepo;
    private EmployeeRepository employeeRepository;

    //it is unused yet
    @ModelAttribute(name = "office")
    public Office office() {
        return new Office();
    }

    private Office office;

    @Autowired
    public OfficeController(OfficeRepository officeRepository, EmployeeRepository employeeRepository) {
        this.officeRepo = officeRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getOfficeForm(Model model) {
        return "/inventory/office";
    }


    @PostMapping(value = "/add")
    public String saveOfficeData(OfficeModel officeModel) {
        this.officeRepo.save(officeModel.translateModelToOffice());
        return "/inventory/office";
    }

    @GetMapping(value = "/view")
    public String DisplayAllOfficeData(Model model) {
        Iterable<Office> offices = this.officeRepo.findAll();
        model.addAttribute("offices", offices);
        return "/inventory/office-view";
    }

    @GetMapping(value = "/add/{id}")
    public String getOfficeFormById(Model model, @PathVariable Long id) {
        Optional<Office> getOffice = this.officeRepo.findById(id);
        model.addAttribute("office", getOffice.get());
        return "/inventory/office";
    }

    @GetMapping(value = "/{id}")
    public String getOfficeData(Model model, @PathVariable Long id) {
        Iterable<Employee> employee = this.employeeRepository.findAllByOffice_Id(id);
        model.addAttribute("employees", employee);
        return "/inventory/office-employee-view";
    }

    @PostMapping(value = "/add/{id}")
    public String updateOfficeData(Model model, @PathVariable Long id, OfficeModel officeModel) {
        Office updateOffice = officeModel.translateModelToOffice();
        updateOffice.setId(id);
        this.officeRepo.save(updateOffice);
        return "/inventory/office";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        this.officeRepo.deleteById(id);
        Iterable<Office> offices = this.officeRepo.findAll();
        model.addAttribute("offices", offices);
        return "/inventory/office-view";
    }


}
