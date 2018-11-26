package com.imsnepal.inventory.security;

import com.imsnepal.inventory.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm {

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(PasswordEncoder passwordEncoder) {

        User user = new User();
        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setPassword(passwordEncoder.encode(this.password));
        return user;
    }
}
