package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.students_coraan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<students_coraan, Long> {
    Optional<students_coraan> findByEmail(String email);
}
