package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.onetomany.Commentt;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */
public interface CommentRepositoryy extends JpaRepository<Commentt, Long> {
}
