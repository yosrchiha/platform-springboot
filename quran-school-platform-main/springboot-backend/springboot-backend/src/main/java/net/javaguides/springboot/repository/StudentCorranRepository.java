package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.students_coraan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCorranRepository extends JpaRepository<students_coraan, Long> {



}
