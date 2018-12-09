package com.imsnepal.inventory.web;

import com.imsnepal.inventory.data.UserRepository;
import com.imsnepal.inventory.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public String getUserInfo(Model model) {

        Iterable<User> userdata = this.userRepository.findAll();
        model.addAttribute("userdata", userdata);
        return "/security/user";
    }

    @GetMapping(value = "/{id}")
    public String getUserInfo(Model model, @PathVariable Long id) {

        Optional<User> userdata = this.userRepository.findById(id);
        model.addAttribute("userdata", userdata.get());
        return "user";
    }

}
