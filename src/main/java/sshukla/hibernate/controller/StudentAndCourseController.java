package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sshukla.hibernate.manytomany.Course;
import sshukla.hibernate.manytomany.Student;
import sshukla.hibernate.repo.CourseRepository;
import sshukla.hibernate.repo.StudentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@RestController
@RequestMapping("/v1")
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
        Set<Course> courseSet = student.getCourseSet();
        System.out.println("Before Processing Course : " + courseSet);
        Set<Course> studentCourseSet = new HashSet<>();
        for (Course course : courseSet) {
            String courseTitle = course.getTitle();
            Course findCourse = courseRepository.findByTitle(courseTitle);
            Course savedCourse = findCourse == null ? courseRepository.save(course) : findCourse;
            System.out.println("Saved Course : " + savedCourse.toString());
            studentCourseSet.add(savedCourse);
        }

        System.out.println("After Processing Course : " + studentCourseSet);
        student.getCourseSet().clear();
        student.getCourseSet().addAll(studentCourseSet);
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student findStudentById(@PathVariable Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found with id - " + studentId));
    }

    @GetMapping("/student/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name) {
        return studentRepository.findByNameContaining(name);
    }

    @Transactional
    @DeleteMapping("/student/delete/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId) {
        Student savedStudent = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Not found Student with id = " + studentId));
        savedStudent.getCourseSet().removeAll(savedStudent.getCourseSet());
        studentRepository.deleteById(studentId);
    }

    @Transactional
    @DeleteMapping("/course/delete/{name}")
    public void deleteCourseByName(@PathVariable String name) {
        studentRepository.deleteByName(name);
    }

    @GetMapping("/course/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price) {
        return courseRepository.findByFeesLessThan(price);
    }
    //update scenario

}
