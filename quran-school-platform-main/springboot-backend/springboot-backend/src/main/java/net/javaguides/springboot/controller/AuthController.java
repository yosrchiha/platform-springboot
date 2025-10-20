package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.students_coraan;
import net.javaguides.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
    @RequestMapping("/api/auth")
    public class AuthController {

        @Autowired
        private AuthService authService;

        @PostMapping("/register")
        public students_coraan register(@RequestBody students_coraan student) {
            return authService.register(student);
        }

        @PostMapping("/login")
        public students_coraan login(@RequestBody Map<String, String> loginData) {
            return authService.login(loginData.get("email"), loginData.get("password"));
        }
    }


