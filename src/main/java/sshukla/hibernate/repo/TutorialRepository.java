package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.onetoone.unidirectional.Tutorial;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
