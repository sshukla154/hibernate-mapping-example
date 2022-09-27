package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sshukla.hibernate.manytomany.Course;
import sshukla.hibernate.manytomany.Student;
import sshukla.hibernate.repo.CourseRepository;
import sshukla.hibernate.repo.StudentRepository;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@RestController
@RequestMapping("/v1/student/course")
@Slf4j
public class StudentAndCourseController {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentAndCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(@PathVariable Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id - " + studentId));
    }

    @GetMapping("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price) {
        return courseRepository.findByFeesLessThan(price);
    }

}
