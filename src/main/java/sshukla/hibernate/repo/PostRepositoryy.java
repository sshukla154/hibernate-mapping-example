package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sshukla.hibernate.onetomany.Postt;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */
public interface PostRepositoryy extends JpaRepository<Postt, Long> {
}
