package net.javaguides.springboot.service;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Récupérer tous les cours
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Récupérer un cours par ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Créer un nouveau cours
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Mettre à jour un cours
    public Course updateCourse(Long id, Course courseDetails) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            Course existingCourse = course.get();
            existingCourse.setDay(courseDetails.getDay());
            existingCourse.setType(courseDetails.getType());
            existingCourse.setTitle(courseDetails.getTitle());
            existingCourse.setDescription(courseDetails.getDescription());
            existingCourse.setSurah(courseDetails.getSurah());
            return courseRepository.save(existingCourse);
        }
        return null;
    }

    // Supprimer un cours
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Récupérer les cours par jour
    public List<Course> getCoursesByDay(String day) {
        return courseRepository.findByDay(day);
    }

    // Récupérer les cours par type
    public List<Course> getCoursesByType(String type) {
        return courseRepository.findByType(type);
    }
}