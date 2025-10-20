package net.javaguides.springboot.repository;
import net.javaguides.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByDay(String day);
    List<Course> findByType(String type);
    List<Course> findBySurah(String surah);
}
