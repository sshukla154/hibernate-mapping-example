package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.onetoone.unidirectional.TutorialDetails;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {
}
