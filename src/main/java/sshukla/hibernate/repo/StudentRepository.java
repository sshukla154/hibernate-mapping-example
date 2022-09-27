package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.manytomany.Student;

import java.util.List;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
public interface StudentRepository  extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);

    void deleteByName(String name);

}
