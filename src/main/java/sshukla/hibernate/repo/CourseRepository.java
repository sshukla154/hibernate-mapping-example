package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.manytomany.Course;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeesLessThan(double fees);

    Course findByTitle(String title);
}
