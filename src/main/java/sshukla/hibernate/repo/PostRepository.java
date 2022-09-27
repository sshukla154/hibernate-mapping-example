package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.manytomany.Post;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
