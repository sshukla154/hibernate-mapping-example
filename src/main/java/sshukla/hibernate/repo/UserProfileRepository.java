package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.onetoone.bidirectional.UserProfile;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
