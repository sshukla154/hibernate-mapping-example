package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.onetoone.bidirectional.User;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
