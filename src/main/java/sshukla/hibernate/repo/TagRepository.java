package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.manytomany.Tag;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String tagName);
}
