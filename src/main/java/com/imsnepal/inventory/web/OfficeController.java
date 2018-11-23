package com.imsnepal.inventory.web;

import com.imsnepal.inventory.data.OfficeRepository;
import com.imsnepal.inventory.domain.Office;
import com.imsnepal.inventory.domain.OfficeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/office")
public class OfficeController {

    private OfficeRepository officeRepo;

    //it is unused yet
    @ModelAttribute(name="office")
    public Office office(){
        return new Office();
    }

    private Office office;

    @Autowired
    public OfficeController(OfficeRepository officeRepository){
        this.officeRepo=officeRepository;
    }

    @GetMapping
    public String getOfficeForm(Model model){
        return "office";
    }

    @PostMapping(value="/add")
    public String saveOfficeData(OfficeModel officeModel){

        this.officeRepo.save(officeModel.translateModelToOffice());

       return  "office";
    }

    @GetMapping(value = "/view")
    public String DisplayAllOfficeData(Model model){

        Iterable<Office> offices= this.officeRepo.findAll();
        model.addAttribute("offices", offices);
        return "office-view";
    }


}
