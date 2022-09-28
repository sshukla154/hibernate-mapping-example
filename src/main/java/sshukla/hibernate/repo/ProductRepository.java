package sshukla.hibernate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.hibernate.onetomany.Product;

/**
 * @author 'Seemant Shukla' on '28/09/2022'
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
