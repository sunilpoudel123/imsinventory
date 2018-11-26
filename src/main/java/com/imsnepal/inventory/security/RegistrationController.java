package com.imsnepal.inventory.security;


import com.imsnepal.inventory.data.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder= passwordEncoder;
    }

    @GetMapping
    public String getRegisterForm(Model model){

        return "registration";
    }

    @PostMapping
    public String submitRegisterData(RegistrationForm form){

        userRepository.save(form.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
