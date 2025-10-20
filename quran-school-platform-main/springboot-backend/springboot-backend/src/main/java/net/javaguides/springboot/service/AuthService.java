package net.javaguides.springboot.service;

import net.javaguides.springboot.model.students_coraan;
import net.javaguides.springboot.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private StudentsRepository studentsRepository;

    // Inscription
    public students_coraan register(students_coraan student) {
        student.setRole("STUDENT"); // rôle par défaut
        return studentsRepository.save(student);
    }

    // Login
    public students_coraan login(String email, String password) {
        Optional<students_coraan> student = studentsRepository.findByEmail(email);
        if (student.isPresent() && student.get().getPassword().equals(password)) {
            return student.get();
        }
        throw new RuntimeException("Email ou mot de passe incorrect");
    }
}
