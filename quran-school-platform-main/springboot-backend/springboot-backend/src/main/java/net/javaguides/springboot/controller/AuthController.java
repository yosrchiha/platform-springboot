package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.students_coraan;
import net.javaguides.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // ✅ autorise Angular
public class AuthController {

    @Autowired
    private AuthService authService;

    // ✅ Inscription
    @PostMapping("/register")
    public students_coraan register(@RequestBody students_coraan student) {
        return authService.register(student);
    }

    // ✅ Login
    @PostMapping("/login")
    public students_coraan login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }
}

// ✅ DTO pour la requête login
class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {   // 👈 méthode manquante auparavant
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
