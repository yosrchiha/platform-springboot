package net.javaguides.springboot.controller;
import net.javaguides.springboot.model.Course;
import net.javaguides.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // GET: Récupérer tous les cours
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // GET: Récupérer un cours par ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        }
        return ResponseEntity.notFound().build();
    }

    // GET: Récupérer les cours par jour
    @GetMapping("/by-day/{day}")
    public ResponseEntity<List<Course>> getCoursesByDay(@PathVariable String day) {
        List<Course> courses = courseService.getCoursesByDay(day);
        return ResponseEntity.ok(courses);
    }

    // GET: Récupérer les cours par type
    @GetMapping("/by-type/{type}")
    public ResponseEntity<List<Course>> getCoursesByType(@PathVariable String type) {
        List<Course> courses = courseService.getCoursesByType(type);
        return ResponseEntity.ok(courses);
    }

    // POST: Créer un nouveau cours
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        if (course.getDay() == null || course.getType() == null ||
                course.getTitle() == null || course.getSurah() == null) {
            return ResponseEntity.badRequest().build();
        }
        Course createdCourse = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCourse);
    }

    // PUT: Mettre à jour un cours
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        Course updatedCourse = courseService.updateCourse(id, courseDetails);
        if (updatedCourse != null) {
            return ResponseEntity.ok(updatedCourse);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Supprimer un cours
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (courseService.deleteCourse(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}