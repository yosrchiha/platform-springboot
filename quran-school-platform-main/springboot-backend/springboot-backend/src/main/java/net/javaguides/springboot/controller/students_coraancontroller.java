package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.students_coraan;
import net.javaguides.springboot.repository.StudentCorranRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students_coraan")
// ⚡ Corrigé pour CORS avec credentials
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class students_coraancontroller {

    @Autowired
    private StudentCorranRepository studentRepository;

    @GetMapping("/students")
    public List<students_coraan> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public students_coraan createStudent(@RequestBody students_coraan student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (!studentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<students_coraan> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<students_coraan> updateStudent(
            @PathVariable Long id,
            @RequestBody students_coraan studentDetails) {
        return studentRepository.findById(id).map(student -> {
            student.setNom(studentDetails.getNom());
            student.setPrenom(studentDetails.getPrenom());
            student.setAge(studentDetails.getAge());
            student.setAdresse(studentDetails.getAdresse());
            student.setNiveau(studentDetails.getNiveau());
            student.setSourateDe(studentDetails.getSourateDe());
            student.setSourateA(studentDetails.getSourateA());
            student.setEmail(studentDetails.getEmail());
            student.setTelephone(studentDetails.getTelephone());
            student.setParentNom(studentDetails.getParentNom());
            student.setParentEmail(studentDetails.getParentEmail());
            student.setParentTelephone(studentDetails.getParentTelephone());

            students_coraan updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        }).orElse(ResponseEntity.notFound().build());
    }
}
